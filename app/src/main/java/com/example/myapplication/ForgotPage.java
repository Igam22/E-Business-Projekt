package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Klasse zum Passwortzurücksetzen
public class ForgotPage extends AppCompatActivity {

    EditText name, mail, password, passwordrepeat;
    Button submit;
    Button goToLogin;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        // Speichern der Nutzereingabe
        name = (EditText) findViewById(R.id.username_set);
        mail = (EditText) findViewById(R.id.mail_set);
        password = (EditText) findViewById(R.id.pw_set);
        passwordrepeat = (EditText) findViewById(R.id.pw_confirm);
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        submit = (Button) findViewById(R.id.button_resetPW);
        MyDB = new DBHelper(this);

        // Link zur LoginPage
        goToLogin = (Button) findViewById(R.id.button_loginScreen);
        goToLogin.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), LoginPage.class);
            view.getContext().startActivity(intent);});

        // Button zum Passwortzurücksetzen
        submit.setOnClickListener(view -> {
            String namee = name.getText().toString();
            String maill = mail.getText().toString();
            String passwordd = password.getText().toString();
            String passwordrepeatt = passwordrepeat.getText().toString();
            Matcher matcher = pattern.matcher(maill);

            // Plausibilitätschecks
            if(namee.equals("") || maill.equals("") || passwordd.equals("") || passwordrepeatt.equals(""))
            {
                Toast.makeText(ForgotPage.this, "Bitte keines der Felder leer lassen.", Toast.LENGTH_SHORT).show();
            }
            else if (!matcher.matches()) {
                Toast.makeText(ForgotPage.this, "Bitte valide E-Mail angeben", Toast.LENGTH_SHORT).show();
            }

            else if (!(passwordd.equals(passwordrepeatt))) {
                Toast.makeText(ForgotPage.this, "Bitte Passwort kontrollieren.", Toast.LENGTH_SHORT).show();
            }
            else if (passwordd.length()<8) {
                Toast.makeText(ForgotPage.this, "Das Passwort muss mindestens 8 Zeichen lang sein", Toast.LENGTH_SHORT).show();
            }

            else
            {
                Boolean result = MyDB.checkMail(maill);

                // Wenn Konto nicht existiert kann Passwort nicht zurückgesetzt werden
                if(!result)
                {
                    Toast.makeText(ForgotPage.this, "Dieses Konto existiert nicht!", Toast.LENGTH_SHORT).show();
                }

                // Passwort zurücksetzen
                else{
                    Boolean res = MyDB.replaceData(namee, maill, passwordd, passwordrepeatt);
                    if(res)
                    {
                        Toast.makeText(ForgotPage.this,"Passwort zurückgesetzt.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ForgotPage.this, LoginPage.class);
                        ForgotPage.this.startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(ForgotPage.this,"Passwort konnte nicht zurückgesetzt werden.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
