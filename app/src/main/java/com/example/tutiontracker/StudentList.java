package com.example.tutiontracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StudentList extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Adapter adapter;
    List<Student> students = new ArrayList<>();
    TextView noText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("StudentList","StudentList is loading");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        toolbar = findViewById(R.id.StudentToolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.ListStudent);
        getSupportActionBar().setTitle("Student List");
        StudentDatabase db = new StudentDatabase(this);
        students = db.getStudentList();
        noText = findViewById(R.id.NoText);


        if(students.isEmpty())
        {
            noText.setVisibility(View.VISIBLE);
        }
        else
        {
            noText.setVisibility(View.GONE);
            displayList();
        }
    }

    private void displayList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,students);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.addstudent,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.AddStudent)
        {
            Toast.makeText(this,"Add new Student",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,StudentAdd.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }
}