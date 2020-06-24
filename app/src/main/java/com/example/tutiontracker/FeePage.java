package com.example.tutiontracker;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FeePage extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    Button jan, feb, mar,apr,may,jun,jul,aug,sept,oct,nov,dec;
    StudentDatabase db = new StudentDatabase(this);
    String student;
    Student studentDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_page);
        toolbar = findViewById(R.id.StudentToolbar);
        setSupportActionBar(toolbar);
        Intent i = getIntent();
        student = i.getStringExtra("StudName");
        getSupportActionBar().setTitle(student);
        ActivityCompat.requestPermissions(FeePage.this,new String[] {Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        jan = findViewById(R.id.JanBtn);
        feb = findViewById(R.id.FebBtn);
        mar = findViewById(R.id.MarBtn);
        apr = findViewById(R.id.AprlBtn);
        may = findViewById(R.id.MayBtn);
        jun = findViewById(R.id.JuneBtn);
        jul = findViewById(R.id.JulyBtn);
        aug = findViewById(R.id.AugBtn);
        sept = findViewById(R.id.SeptBtn);
        oct = findViewById(R.id.OctBtn);
        nov = findViewById(R.id.NovBtn);
        dec = findViewById(R.id.DecBtn);
        jan.setOnClickListener(this);
        feb.setOnClickListener(this);
        mar.setOnClickListener(this);
        apr.setOnClickListener(this);
        may.setOnClickListener(this);
        jun.setOnClickListener(this);
        jul.setOnClickListener(this);
        aug.setOnClickListener(this);
        sept.setOnClickListener(this);
        oct.setOnClickListener(this);
        nov.setOnClickListener(this);
        dec.setOnClickListener(this);
        studentDe = db.getStudent(student);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.JanBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"jan");
                    String meg = "Tuition fee of "+student + " for the month of JANUARY has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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
            Toast.makeText(this,"JANUARY FEE RECEIVED",Toast.LENGTH_LONG).show();


        }
        else if(v.getId() == R.id.FebBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"feb");
                    String meg = "Tuition fee of "+student + " for the month of FEBRUARY has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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


            Toast.makeText(this,"FEBRUARY FEE RECEIVED",Toast.LENGTH_LONG).show();
        }
        else if(v.getId() == R.id.DecBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"dec");
                    String meg = "Tuition fee of "+student + " for the month of DECEMBER has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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


            Toast.makeText(this,"DECEMBER FEE RECEIVED",Toast.LENGTH_LONG).show();
        }
        else if(v.getId() == R.id.MarBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"mar");
                    String meg = "Tuition fee of "+student + " for the month of MARCH has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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



            Toast.makeText(this,"MARCH FEE RECEIVED",Toast.LENGTH_LONG).show();


        }
        else if(v.getId() == R.id.AprlBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"apr");
                    String meg = "Tuition fee of "+student + " for the month of APRIL has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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



            Toast.makeText(this,"APRIL FEE RECEIVED",Toast.LENGTH_LONG).show();
        }
        else if(v.getId() == R.id.MayBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"may");
                    String meg = "Tuition fee of "+student + " for the month of MAY has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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



            Toast.makeText(this,"MAY FEE RECEIVED",Toast.LENGTH_LONG).show();

        }
        else if(v.getId() == R.id.JuneBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"jun");
                    String meg = "Tuition fee of "+student + " for the month of JUNE has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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



            Toast.makeText(this,"JUNE FEE RECEIVED",Toast.LENGTH_LONG).show();

        }
        else if(v.getId() == R.id.JulyBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"jul");
                    String meg = "Tuition fee of "+student + " for the month of JULY has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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



            Toast.makeText(this,"JULY FEE RECEIVED",Toast.LENGTH_LONG).show();

        }
        else if(v.getId() == R.id.AugBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"aug");
                    String meg = "Tuition fee of "+student + " for the month of AUGUST has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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



            Toast.makeText(this,"AUGUST FEE RECEIVED",Toast.LENGTH_LONG).show();

        }
        else if(v.getId() == R.id.SeptBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"sept");
                    String meg = "Tuition fee of "+student + " for the month of SEPTEMBER has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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



            Toast.makeText(this,"SEPTEMBER FEE RECEIVED",Toast.LENGTH_LONG).show();

        }
        else if(v.getId() == R.id.OctBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"oct");
                    String meg = "Tuition fee of "+student + " for the month of OCTOBER has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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



            Toast.makeText(this,"OCTOBER FEE RECEIVED",Toast.LENGTH_LONG).show();

        }
        else if(v.getId() == R.id.NovBtn)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(FeePage.this);
            builder.setMessage("Do you want to send msg?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.feePaid(student,"nov");
                    String meg = "Tuition fee of "+student + " for the month of NOVEMBER has be received by us.";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(studentDe.getPhone(),null,meg,null,null);
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


            Toast.makeText(this,"NOVEMBER FEE RECEIVED",Toast.LENGTH_LONG).show();

        }

    }

    public void toMain()
    {
        Intent intent = new Intent(this,StudentList.class);
        startActivity(intent);
    }

}