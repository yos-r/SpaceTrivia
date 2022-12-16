package com.example.spacetrivia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    public DBHelper(Context ctx){
        super(ctx, "login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table USERS(username TEXT primary key,password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table  if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("username",username);
        cv.put("password",password);
        long result= MyDB.insert("users",null,cv);
        if (result==-1) return false; else return true;
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("select * from users where username = ? ",new String[] {username});
        if (cursor.getCount()>0){return true;}
        else return false;
    }
    public Boolean checkPwd(String username,String pwd){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("select * from users where username = ? and password= ?",new String[] {username,pwd});
        if (cursor.getCount()>0){return true;}
        else return false;
    }


}
