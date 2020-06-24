package com.example.tutiontracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 2;
    private static String DATABASE_NAME = "StudentName";
    private static String DATABASE_TABLE = "StudentDetails";
    private static String DATABASE_FEE = "StudentFee";


    StudentDatabase(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //Columns names
    private static String KEY_ID = "id";
    private static String KEY_NAME= "name";
    private static String KEY_CLASS="class";
    private static String KEY_FEE="fee";
    private static String KEY_PHONE ="phone";
    private static String KEY_DATE = "data";
    //Second table
    private static String KEY_CODE = "code";
    private static String KEY_STUD = "student";
    private static String KEY_JAN = "jan";
    private static String KEY_FEB = "feb";
    private static String KEY_MAR = "mar";
    private static String KEY_APR = "apr";
    private static String KEY_MAY = "may";
    private static String KEY_JUN = "jun";
    private static String KEY_JUL = "jul";
    private static String KEY_AUG = "aug";
    private static String KEY_SEPT = "sept";
    private static String KEY_OCT = "oct";
    private static String KEY_NOV = "nov";
    private static String KEY_DEC = "dec";



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_CLASS + " TEXT," + KEY_FEE + " TEXT," + KEY_PHONE + " TEXT," + KEY_DATE + " TEXT" + ")";
        String secondQuery = "CREATE TABLE " + DATABASE_FEE + " (" + KEY_CODE + " TEXT PRIMARY KEY," + KEY_STUD + " TEXT," + KEY_JAN + " TEXT," + KEY_FEB + " TEXT," + KEY_MAR + " TEXT," + KEY_APR + " TEXT," +
               KEY_MAY + " TEXT," + KEY_JUN + " TEXT," + KEY_JUL + " TEXT," + KEY_AUG + " TEXT," + KEY_SEPT + " TEXT," + KEY_OCT + " TEXT," + KEY_NOV + " TEXT," + KEY_DEC + " TEXT" + ")";

        db.execSQL(query);
        db.execSQL(secondQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion>=newVersion)
        {
            return;
        }
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_FEE);

        onCreate(db);
    }



    public long addStudent(Student student)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_NAME, student.getName());
        c.put(KEY_CLASS,student.getStandard());
        c.put(KEY_FEE,student.getFee());
        c.put(KEY_PHONE,student.getPhone());
        c.put(KEY_DATE,student.getDate());
        long id = db.insert(DATABASE_TABLE,null, c);

        ContentValues b = new ContentValues();
        b.put(KEY_STUD,student.getName());
        b.put(KEY_JAN,"JAN");
        b.put(KEY_FEB,"FEB");
        b.put(KEY_MAR,"MAR");
        b.put(KEY_APR,"APR");
        b.put(KEY_MAY,"MAY");
        b.put(KEY_JUN,"JUN");
        b.put(KEY_JUL,"JUL");
        b.put(KEY_AUG,"AUG");
        b.put(KEY_SEPT,"SEPT");
        b.put(KEY_OCT,"OCT");
        b.put(KEY_NOV,"NOV");
        b.put(KEY_DEC,"DEC");
        long i =  db.insert(DATABASE_FEE,null,b);
        return id;
    }

    public List<Student> getStudentList()
    {

        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + DATABASE_TABLE + " ORDER BY " + KEY_ID + " DESC ";
        List<Student> students = new ArrayList<>();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                Student student = new Student();
                student.setName(cursor.getString(1));
                student.setStandard(cursor.getString(2));
                student.setFee(cursor.getString(3));
                student.setPhone(cursor.getString(4));
                student.setDate(cursor.getString(5));

                students.add(student);
            }while(cursor.moveToNext());
        }
        return students;
    }

    public Student getStudent(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        Student student = new Student();
        String[] query = new String[] {KEY_ID,KEY_NAME,KEY_CLASS,KEY_FEE,KEY_PHONE,KEY_DATE};
        Cursor cursor = db.query(DATABASE_TABLE,query, KEY_NAME + "=?",new String[]{name},null,null,null,null);
        if(cursor != null)
        {
            if(cursor.moveToFirst())
            {
                student.setName(cursor.getString(1));
                student.setStandard(cursor.getString(2));
                student.setFee(cursor.getString(3));
                student.setPhone(cursor.getString(4));
                student.setDate(cursor.getString(5));
            }
        }
        String[] secondQuery = new String[] {KEY_CODE,KEY_STUD,KEY_JAN,KEY_FEB,KEY_MAR,KEY_APR,KEY_MAY,KEY_JUN,KEY_JUL,KEY_AUG,KEY_SEPT,KEY_OCT,KEY_NOV,KEY_DEC};
        Cursor cursor1 = db.query(DATABASE_FEE,secondQuery,KEY_STUD + "=?",new String[]{name},null,null,null,null);
        if(cursor1 != null)
        {
            if(cursor1.moveToFirst())
            {
                student.setJan(cursor1.getString(2));
                student.setFeb(cursor1.getString(3));
                student.setMar(cursor1.getString(4));
                student.setApr(cursor1.getString(5));
                student.setMay(cursor1.getString(6));
                student.setJun(cursor1.getString(7));
                student.setJul(cursor1.getString(8));
                student.setAug(cursor1.getString(9));
                student.setSept(cursor1.getString(10));
                student.setOct(cursor1.getString(11));
                student.setNov(cursor1.getString(12));
                student.setDec(cursor1.getString(13));


            }
        }
        return student;
    }

    public void deleteStudent(String id)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DATABASE_TABLE,KEY_NAME + "=?",new String[] {id});
        db.close();
    }

    public void feePaid(String name, String mon)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c  = new ContentValues();
        if(mon.equalsIgnoreCase("jan"))
        {
            c.put(KEY_JAN,"JAN PAID");
        }
        if(mon.equalsIgnoreCase("feb"))
        {
            c.put(KEY_FEB,"FEB PAID");
        }
        if(mon.equalsIgnoreCase("mar"))
        {
            c.put(KEY_MAR,"MAR PAID");
        }
        if(mon.equalsIgnoreCase("apr"))
        {
            c.put(KEY_APR,"APR PAID");
        }
        if(mon.equalsIgnoreCase("may"))
        {
            c.put(KEY_MAY,"MAY PAID");
        }
        if(mon.equalsIgnoreCase("jun"))
        {
            c.put(KEY_JUN,"JUN PAID");
        }

        if(mon.equalsIgnoreCase("jul"))
        {
            c.put(KEY_JUL,"JUL PAID");
        }
        if(mon.equalsIgnoreCase("aug"))
        {
            c.put(KEY_AUG,"AUG PAID");
        }
        if(mon.equalsIgnoreCase("sept"))
        {
            c.put(KEY_SEPT,"SEPT PAID");
        }
        if(mon.equalsIgnoreCase("oct"))
        {
            c.put(KEY_OCT,"OCT PAID");
        }
        if(mon.equalsIgnoreCase("nov"))
        {
            c.put(KEY_NOV,"NOV PAID");
        }
        if(mon.equalsIgnoreCase("dec"))
        {
            c.put(KEY_DEC,"DEC PAID");
        }



        db.update(DATABASE_FEE,c,KEY_STUD + "=?",new String[] {name});
    }

}
