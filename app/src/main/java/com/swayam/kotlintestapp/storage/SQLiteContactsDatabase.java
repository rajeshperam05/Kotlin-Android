package com.swayam.kotlintestapp.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by rajesh on 14/6/17.
 */

public class SQLiteContactsDatabase extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Contacts_db";
    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String NUMBER = "Number";
    public static final String CREATE_TABLE = "Create table "
            + TABLE_NAME + " ("
            + ID + " Integer primary key, "
            + NAME + " VARCHAR, "
            + NUMBER + " VARCHAR)";

    public static final String DROP_TABLE = "Drop table if exists " + TABLE_NAME;


    public SQLiteContactsDatabase(Context context) {
        super(context, TABLE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    public long insert(Contact contact){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, contact.getName());
        contentValues.put(NUMBER, contact.getNumber());

        SQLiteDatabase db = this.getWritableDatabase();


        return db.insert(TABLE_NAME, null, contentValues);

    }

    public ArrayList<Contact> getAllContacts(){

        ArrayList<Contact> contactList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME, null);
        cursor.moveToNext();
        while (!cursor.isAfterLast()){

            int id = cursor.getInt(cursor.getColumnIndex(ID));
            String name = cursor.getString(cursor.getColumnIndex(NAME));
            String number = cursor.getString(cursor.getColumnIndex(NUMBER));
            contactList.add(new Contact(id, name, number));
            cursor.moveToNext();
        }

        return contactList;
    }

    public boolean delete(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + "=? ", new String[]{Integer.toString(id)});

        return true;
    }
}


