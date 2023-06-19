package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Klasse für den Willkommen Screen
public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Link zur Registrierung
        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), RegisterPage.class);
            view.getContext().startActivity(intent);});
    }
}