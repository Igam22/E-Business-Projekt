package com.example.blutwert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_DATUM = "CUSTOMER_DATUM";
    public static final String COLUMN_CUSTOMER_EISENGEHALT = "CUSTOMER_EISENGEHALT";
    public static final String COLUMN_CUSTOMER_CHOLOSTERINGEHALT = "CUSTOMER_CHOLOSTERINGEHALT";
    public static final String COLUMN_CUSTOMER_BLUTZUCKER = "CUSTOMER_BLUTZUCKER";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_CUSTOMER_TRIGLYCERIDE = "CUSTOMER_TRIGLYCER" + COLUMN_ID + "E";
    public static final String COLUMN_CUSTOMER_BLUTDRUCK = "CUSTOMER_BLUTDRUCK";

    public static final String COLUMN_CUSTOMER_VITAMIND = "CUSTOMER_VITAMIND";
    public static final String COLUMN_CUSTOMER_VITAMINB_12 = "CUSTOMER_VITAMINB12";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    //this is called thr first time a database is created. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String crateTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_DATUM + " TEXT, " + COLUMN_CUSTOMER_EISENGEHALT + " INT, " + COLUMN_CUSTOMER_CHOLOSTERINGEHALT + " INT, " + COLUMN_CUSTOMER_BLUTZUCKER + " INT, " + COLUMN_CUSTOMER_TRIGLYCERIDE + " INT, " + COLUMN_CUSTOMER_BLUTDRUCK + " INT, " + COLUMN_CUSTOMER_VITAMIND + " INT," + COLUMN_CUSTOMER_VITAMINB_12 + " INT)";

        db.execSQL(crateTableStatement);
    }


    //This is called if the database version number changes. It prevents previous users app from breaking when you change database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(CustomerModel customerModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CUSTOMER_DATUM, customerModel.getDatum());
        cv.put(COLUMN_CUSTOMER_EISENGEHALT, customerModel.getEisengehalt());
        cv.put(COLUMN_CUSTOMER_BLUTZUCKER, customerModel.getBlutzucker());
        cv.put(COLUMN_CUSTOMER_TRIGLYCERIDE, customerModel.getTriglyceride());
        cv.put(COLUMN_CUSTOMER_BLUTDRUCK, customerModel.getBlutdruck());
        cv.put(COLUMN_CUSTOMER_VITAMIND, customerModel.getVitaminD());
        cv.put(COLUMN_CUSTOMER_VITAMINB_12, customerModel.getVitaminB12());

        long insert = db.insert(CUSTOMER_TABLE,null ,cv);
        if(insert == -1){
            return  false;
        }
        else{
            return true;
        }
    }
}
/*
    public List<CustomerModel>getEveryone() {
        List<CustomerModel> returnList = new ArrayList<>();
        //get data from the database

        String queryString = "SELECT * FROM " + CUSTOMER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop trough the cursor (result set) and create new customer objects. Put them into return list.
            do {
                int CustomerID = cursor.getInt(0);
                String Datum = cursor.getString(1);
                int Eisengehalt = cursor.getInt(2);
                int Cholesteringehalt = cursor.getInt(3);
                int Blutzucker = cursor.getInt(4);
                int Triglyceride = cursor.getInt(5);
                int Blutdruck = cursor.getInt(6);
                int VitaminD = cursor.getInt(7);
                int VitaminB12 = cursor.getInt(8);

                CustomerModel newCustomer = new CustomerModel(CustomerID, Datum, Eisengehalt, Cholesteringehalt, Blutzucker, Triglyceride, Blutdruck, VitaminD, VitaminB12);
                returnList.add(newCustomer);

            } while (cursor.moveToNext());
        } else {
            //failure. do not add anything to the List
        }
        // close both the cursor and the db when done
        cursor.close();
        db.close();
        return returnList;
    }
}
*/