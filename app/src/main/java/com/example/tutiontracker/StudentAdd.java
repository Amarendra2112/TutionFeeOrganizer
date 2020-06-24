package com.example.tutiontracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class StudentAdd extends AppCompatActivity {
    Toolbar toolbar;
    EditText name,standard,fee,phone;
    Calendar calendar;
    String todayDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        toolbar = findViewById(R.id.StudentToolbar);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.StudentName);
        standard = findViewById(R.id.NStudentClass);
        fee = findViewById(R.id.NStudentFee);
        phone = findViewById(R.id.NStudentPhone);
        getSupportActionBar().setTitle("Add Student");

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != "")
                {
                    getSupportActionBar().setTitle(s);
                }
                if(getSupportActionBar().getTitle().length() == 0)
                {
                    getSupportActionBar().setTitle("Add Student");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        calendar = Calendar.getInstance();
        todayDate = calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) +1) + "/" + calendar.get(Calendar.YEAR);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.newstudent,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.SaveStudent)
        {
            String i =  phone.getText().toString();

            if(i.length() >= 10)
            {
                Toast.makeText(this,"Student added",Toast.LENGTH_LONG).show();
                Student student = new Student();
                student.setName(name.getText().toString());
                student.setStandard(standard.getText().toString());
                student.setFee(fee.getText().toString());
                student.setPhone(phone.getText().toString());

                student.setDate(todayDate);
                StudentDatabase db = new StudentDatabase(this);
                long id = db.addStudent(student);
                goToStudentList();
            }
            else
            {
                Toast.makeText(this,"Phone number is wrong",Toast.LENGTH_LONG).show();
            }

        }
        else if(item.getItemId() == R.id.ResetBtn)
        {
            Toast.makeText(this,"Details Reset",Toast.LENGTH_LONG).show();
            name.setText(null);
            standard.setText(null);
            fee.setText(null);
            phone.setText(null);
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToStudentList()
    {
        Intent intent = new Intent(this,StudentList.class);
        startActivity(intent);
    }
}