package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Klasse für die Registrierungsseite
public class RegisterPage extends AppCompatActivity {

    EditText name, mail, password, passwordrepeat;
    Button submit;
    Button goToLogin;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Nutzereingabe speichern
        name = (EditText) findViewById(R.id.name);
        mail = (EditText) findViewById(R.id.mail);
        password = (EditText) findViewById(R.id.password);
        passwordrepeat = (EditText) findViewById(R.id.passwordrepeat);
        // Regex für valide Email
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        submit = (Button) findViewById(R.id.action_register);
        MyDB = new DBHelper(this);

        //Link zum Login
        goToLogin = (Button) findViewById(R.id.button_loginScreen);
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginPage.class);
                view.getContext().startActivity(intent);}
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee = name.getText().toString();
                String maill = mail.getText().toString();
                String passwordd = password.getText().toString();
                String passwordrepeatt = passwordrepeat.getText().toString();
                Matcher matcher = pattern.matcher(maill);

                // Plausibilitätschecks
                if(namee.equals("") || maill.equals("") || passwordd.equals("") || passwordrepeatt.equals(""))
                {
                    Toast.makeText(RegisterPage.this, "Bitte keines der Felder leer lassen.", Toast.LENGTH_SHORT).show();
                }

                else if (!matcher.matches()) {
                    Toast.makeText(RegisterPage.this, "Bitte valide E-Mail angeben", Toast.LENGTH_SHORT).show();
                }

                else if (!(passwordd.equals(passwordrepeatt))) {
                    Toast.makeText(RegisterPage.this, "Bitte Passwort kontrollieren.", Toast.LENGTH_SHORT).show();
                }

                else if (passwordd.length()<8) {
                    Toast.makeText(RegisterPage.this, "Das Passwort muss mindestens 8 Zeichen lang sein", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Boolean result = MyDB.checkMail(maill);

                    if(result == false)
                    {
                        // Benutzer existiert noch nicht -> Registrierung möglich
                        Boolean res = MyDB.insertData(namee, maill, passwordd, passwordrepeatt);

                        if(res==true)
                        {
                            Toast.makeText(RegisterPage.this,"Registrierung erfolgreich!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterPage.this, Home.class);
                            RegisterPage.this.startActivity(intent);
                        }

                        else
                        {
                            Toast.makeText(RegisterPage.this,"Registrierung fehlgeschlagen!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else{
                        // Benutzer existiert bereits
                        Toast.makeText(RegisterPage.this, "Dieses Konto existiert bereits.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                        RegisterPage.this.startActivity(intent);
                    }
                }
            }
        });
    }
}
