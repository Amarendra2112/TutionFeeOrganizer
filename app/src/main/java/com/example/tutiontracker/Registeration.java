package com.example.tutiontracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registeration extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    EditText username, password, cPassword;
    Button register;
    private static int use = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        toolbar = findViewById(R.id.RegistrationToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Student");
        username = findViewById(R.id.RegistrationUN);
        password = findViewById(R.id.RegestrationPW);
        cPassword = findViewById(R.id.RegistrationCPW);
        register = findViewById(R.id.RegistrationBTN);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.RegistrationBTN) {
            use = use + 1;

            if (password.getText().toString().equalsIgnoreCase(cPassword.getText().toString()) & use == 1) {
                User user = new User();
                RegisterDatabase db = new RegisterDatabase(this);
                user.setUserName(username.getText().toString());
                user.setPassword(password.getText().toString());
                db.addUser(user);
                goToMain();
                Toast.makeText(this, "You are registered user", Toast.LENGTH_SHORT).show();
            } else if (use > 0) {
                Toast.makeText(this, "You have already registered", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Password miss match", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}