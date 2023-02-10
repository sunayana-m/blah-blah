package com.example.a4_165;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbname="studentdb";
    private static final String tname="student";
    private static final int dbversion=1;

    DBHelper(@Nullable Context context,@Nullable String name,@Nullable SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+tname+" (uname VARCHAR(10),pswd VARCHAR(8))"+";");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tname);
        onCreate(db);
    }

    public long add(String u, String p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("uname",u);
        cv.put("pswd",p);
        long res=db.insert(tname,null,cv);
        db.close();
        return res;
    }

    public void update(String u,String p){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE "+tname+" SET pswd='"+p+"' WHERE uname='"+u+"';");
        db.close();
    }

    public void delete(String u,String p){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+tname+" WHERE uname='"+u+"';");
        db.close();
    }


    public String display(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tname,null);
        String a="";
        while (c.moveToNext()){
            a+=c.getString(0)+" : "+c.getString(1)+"  |  ";
        }
        return a;
    }
}
