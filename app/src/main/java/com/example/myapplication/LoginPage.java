package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        goToRegister = (Button) findViewById(R.id.button_register);
        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RegisterPage.class);
                view.getContext().startActivity(intent);}
        });

        forgot = (Button) findViewById(R.id.button_forgot_password);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ForgotPage.class);
                view.getContext().startActivity(intent);}
        });
        button2 = (Button) findViewById(R.id.action_login);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String maill = mail.getText().toString();
                String passwordd = password.getText().toString();


                if(mail.equals(""))
                {
                    Toast.makeText(LoginPage.this, "Enter email", Toast.LENGTH_SHORT).show();
                }
                 else{
                    Boolean result = MyDB.checkMail(maill);
                    if(result == false)
                    {

                        Toast.makeText(LoginPage.this, "User does not exists.\n Kindly Register", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), RegisterPage.class);
                        startActivity(intent);
                    }
                    else if(!MyDB.checkEmailPassword(maill, passwordd)){
                        Toast.makeText(LoginPage.this, "Passwort ist inkorrekt", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }
                }

            }
        });

    }

}
