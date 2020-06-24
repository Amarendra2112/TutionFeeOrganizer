package com.example.tutiontracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class RegisterDatabase extends SQLiteOpenHelper {

    //Database creation
    private static int DATABASE_VERSION = 2;
    private static String DATABASE_NAME = "RegisterDatabase";
    private static String DATABASE_TABLE = "RegisterTable";
   // private static String DATABASE_LOGIN = "Login";

    RegisterDatabase(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //Database column
    private static String KEY_ID ="id";
    private static String KEY_USERNAME = "UserName";
    private static String KEY_PASSWORD = "PassWord";




    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + DATABASE_TABLE + " ( " + KEY_ID + " TEXT PRIMARY KEY," +  KEY_USERNAME + " TEXT," + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion>=newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }


    public void addUser(User user)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_USERNAME, user.getUserName());
        c.put(KEY_PASSWORD, user.getPassword());
        long id = db.insert(DATABASE_TABLE,null,c);

    }

    public User getLogin()
    {
        SQLiteDatabase db = getReadableDatabase();
        User user =  new User();
//        String[] query = new String[] {KEY_ID,KEY_USERNAME,KEY_PASSWORD};
//        Cursor cursor = db.query(DATABASE_TABLE,query,KEY_USERNAME + "=?",new String[]{userName},null,null,null,null);
        String query = " SELECT * FROM " + DATABASE_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor != null)
        {
            cursor.moveToFirst();
            user.setUserName(cursor.getString(1));
            user.setPassword(cursor.getString(2));
        }

        return user;
    }
}
