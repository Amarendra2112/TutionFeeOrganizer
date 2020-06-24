package com.example.tutiontracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class StudentDetails extends AppCompatActivity {
    Toolbar toolbar;
    TextView name, date,phone, jan, feb, mar,apr,may,jun,jul,aug,sept,oct,nov,dec;
    StudentDatabase db = new StudentDatabase(this);
    String studentName;
    Student student =  new Student();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        toolbar = findViewById(R.id.RegistrationToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student Details");
        Intent intent = getIntent();

        name = findViewById(R.id.StudentDetailName);
        date = findViewById(R.id.DateStudentDetail);
        phone = findViewById(R.id.PhoneNumberDetail);

        jan = findViewById(R.id.Jan);
        feb =  findViewById(R.id.Feb);
        mar = findViewById(R.id.Mar);
        apr = findViewById(R.id.Aprl);
        may =  findViewById(R.id.May);
        jun = findViewById(R.id.June);
        jul = findViewById(R.id.Jul);
        aug = findViewById(R.id.Aug);
        sept = findViewById(R.id.Sept);
        oct = findViewById(R.id.Oct);
        nov= findViewById(R.id.Nov);
        dec  = findViewById(R.id.Dec);

        studentName = intent.getStringExtra("Name");
        student = db.getStudent(studentName);

        name.setText(student.getName());
        date.setText(student.getDate());
        phone.setText(student.getPhone());

        jan.setText(student.getJan());
        feb.setText(student.getFeb());
        mar.setText(student.getMar());
        apr.setText(student.getApr());
        may.setText(student.getMay());
        jun.setText(student.getJun());
        jul.setText(student.getJul());
        aug.setText(student.getAug());
        sept.setText(student.getSept());
        oct.setText(student.getOct());
        nov.setText(student.getNov());
        dec.setText(student.getDec());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.details,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.StudentEdit)
        {
            Toast.makeText(this,"Edit Student detail",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, FeePage.class);
            intent.putExtra("StudName",studentName);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.DeleteStudent)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(StudentDetails.this);
            builder.setMessage("Do you want to delete record of " + student.getName()+" ?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.deleteStudent(student.getName());
                    toMain();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    toMain();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            Toast.makeText(this,"Delete Student detail",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void toMain()
    {
        Intent intent = new Intent(this,StudentList.class);
        startActivity(intent);
    }
}