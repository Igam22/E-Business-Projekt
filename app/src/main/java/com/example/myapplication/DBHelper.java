package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Funktionen für SQLite Datenbank Aufrufe
public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context){
        super(context, "register.db",  null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table person(name TEXT, mail TEXT primary key, password TEXT, passwordrepeat TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1 ) {

        MyDB.execSQL("drop Table if exists person");

    }

    // Funktionen zum Schreiben von Daten
    public Boolean insertData(String name, String mail, String password, String passwordrepeat){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mail",mail);
        contentValues.put("password",password);
        contentValues.put("passwordrepeat",passwordrepeat);
        long result = MyDB.insert("person",null,contentValues);

        return result != -1;
    }

    // Funktion zum überschreiben von Daten
    public Boolean replaceData(String name, String mail, String password, String passwordrepeat){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mail",mail);
        contentValues.put("password",password);
        contentValues.put("passwordrepeat",passwordrepeat);
        long result = MyDB.replace("person",null,contentValues);

        return result != -1;
    }

    // Funktion zum Finden existierender Konten
    public Boolean checkMail(String mail){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from person where mail = ?",new String[]{mail});
        return cursor.getCount() > 0;
    }

    // Funktion für Passwortabgleich
    public Boolean checkEmailPassword(String mail, String password) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from person where mail = ? and password = ?", new String[] {mail, password});
        return cursor.getCount() > 0;
    }
}
