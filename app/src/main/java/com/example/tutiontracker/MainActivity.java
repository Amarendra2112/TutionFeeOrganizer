package com.example.tutiontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    EditText userName, password;
    TextView register;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.UserNameHome);
        password = findViewById(R.id.LoginPassword);
        login = findViewById(R.id.Login);
        register = findViewById(R.id.RegisterLink);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    public void onClick(View v)
    {
        if(v.getId() == R.id.Login)
        {
            RegisterDatabase db = new RegisterDatabase(this);
            User user=db.getLogin();

            if(user.getPassword().equalsIgnoreCase(password.getText().toString()) && user.getUserName().equalsIgnoreCase(userName.getText().toString()))
                {
                    Intent i = new Intent(this,StudentList.class);
                    startActivity(i);
                }
            else if(user.getPassword().equalsIgnoreCase(password.getText().toString()))
                {
                    Toast.makeText(this,"Wrong Username",Toast.LENGTH_SHORT).show();
                }
            else
            {
                Toast.makeText(this,"Wrong Password",Toast.LENGTH_SHORT).show();
            }

        }
        if(v.getId() == R.id.RegisterLink)
        {
            Intent intent = new Intent(this, Registeration.class);
            startActivity(intent);
        }

    }

}