package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// Klasse für den Login
public class LoginPage extends AppCompatActivity {

    Button goToRegister;
    Button forgot;
    Button button2;
    EditText mail;
    EditText password;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = (EditText) findViewById(R.id.login_mail);
        password = (EditText) findViewById(R.id.login_pw);
        MyDB = new DBHelper(this);

        // Link zur Registrierung
        goToRegister = (Button) findViewById(R.id.button_register);
        goToRegister.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), RegisterPage.class);
            view.getContext().startActivity(intent);});

        // Link zum Passwortzurücksetzen
        forgot = (Button) findViewById(R.id.button_forgot_password);
        forgot.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ForgotPage.class);
            view.getContext().startActivity(intent);});

        // Button für Login
        button2 = (Button) findViewById(R.id.action_login);
        button2.setOnClickListener(v -> {

            String maill = mail.getText().toString();
            String passwordd = password.getText().toString();

            // Plausibilitätschecks
            if(maill.equals(""))
            {
                Toast.makeText(LoginPage.this, "Enter email", Toast.LENGTH_SHORT).show();
            }

             else{
                Boolean result = MyDB.checkMail(maill);


                if(!result)
                {
                    // User existiert nicht
                    Toast.makeText(LoginPage.this, "Benutzer nicht gefunden.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), RegisterPage.class);
                    startActivity(intent);
                }

                else if(!MyDB.checkEmailPassword(maill, passwordd)){
                    // Nutzer und Passwort stimmen nicht überein
                    Toast.makeText(LoginPage.this, "Passwort ist inkorrekt.", Toast.LENGTH_SHORT).show();
                }

                else{
                    // Login erfolgreich
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                }
            }
        });
    }
}
