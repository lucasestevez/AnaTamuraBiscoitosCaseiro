package com.br.anatamurabiscoitoscaseiros.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBController {
    private SQLiteDatabase db;
    private final DBHelper dbHelper;
    protected String NAME = "NAME",EMAIL = "EMAIL" , DATE = "DATE" , PHONE = "PHONE", PASSWORD = "PASSWORD";

    public DBController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public Boolean loadDataByCode(String email, String password) {

        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from USERS where EMAIL = ? and PASSWORD = ?", new String[]{email, password});

        return cursor.getCount() > 0;

    }

    public Boolean save(String name, String email, String dateBirth, String phoneNumber, String password) {

        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME, name);
        values.put(EMAIL, email);
        values.put(DATE, dateBirth);
        values.put(PHONE, phoneNumber);
        values.put(PASSWORD, password);

        long result = db.insert("USERS", null, values);
        db.close();

        return result != -1;

    }

}
