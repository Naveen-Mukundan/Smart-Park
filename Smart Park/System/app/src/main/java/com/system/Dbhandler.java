package com.system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhandler extends  SQLiteOpenHelper {

    private static final int DATABASE_VERSION =18;
    private static final String DATABASE_NAME = "system.db";
    public static final String TABLE_REGISTER = "system";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PARK_COUNT = "parkcount";
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_START_TIME_HOUR = "sthr";
    public static final String COLUMN_START_TIME_MIN = "stmin";

    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_PARK_ALLOT = "pallot";



    public Dbhandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_REGISTER + "(" +
                COLUMN_ID + " TEXT PRIMARY KEY, " +
                COLUMN_USER_NAME + " TEXT NOT NULL, " +
                COLUMN_AMOUNT + " TEXT NOT NULL, " +
                COLUMN_PARK_COUNT + " TEXT NOT NULL, " +
                COLUMN_START_TIME_HOUR + " TEXT, " +
                COLUMN_START_TIME_MIN + " TEXT, " +
                 COLUMN_STATUS + " TEXT, " +
                COLUMN_PARK_ALLOT + " TEXT " + ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_REGISTER);
        onCreate(db);
    }
    public void add(Register register1) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, register1.get_Id());
        values.put(COLUMN_USER_NAME, register1.get_Username());
        values.put(COLUMN_AMOUNT, register1.get_Amt());
        values.put(COLUMN_PARK_COUNT, register1.get_pc());

        values.put(COLUMN_PARK_ALLOT,"0");
        values.put(COLUMN_STATUS,"0");
        values.put(COLUMN_START_TIME_HOUR,"0");
        values.put(COLUMN_START_TIME_MIN,"0");
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_REGISTER, null, values);
        db.close();
    }
    public String getamount(String id) {
        SQLiteDatabase db =getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_REGISTER + " WHERE id=? ", new String[]{id});
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String at = cursor.getString(cursor.getColumnIndex("parkcount"));
        cursor.close();
        return at;
       }
    public String update(String id,String sthr,String stmin,String park,String status) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_START_TIME_HOUR,sthr);
        values.put(COLUMN_START_TIME_MIN,stmin);
        values.put(COLUMN_PARK_ALLOT,park);
        values.put(COLUMN_STATUS,status);
         db.update(TABLE_REGISTER, values, COLUMN_ID + "=?", new String[]{id});
        db.close();
        return "6";
    }
    public String getallocation(String id) {
        SQLiteDatabase db =getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_REGISTER + " WHERE id=? ", new String[]{id});
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String at = cursor.getString(cursor.getColumnIndex("status"));
        cursor.close();
        return at;

    }
    public String getstarthr(String id) {
        SQLiteDatabase db =getWritableDatabase();

        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_REGISTER + " WHERE id=? ", new String[]{id});
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String at = cursor.getString(cursor.getColumnIndex("sthr"));
        cursor.close();
        return at;
    }
    public String getstartmin(String id) {
        SQLiteDatabase db =getWritableDatabase();

        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_REGISTER + " WHERE id=? ", new String[]{id});
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String at = cursor.getString(cursor.getColumnIndex("stmin"));
        cursor.close();
        return at;
    }

    public String getstatus(String id) {
        SQLiteDatabase db =getWritableDatabase();

        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_REGISTER + " WHERE id=? ", new String[]{id});
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String at = cursor.getString(cursor.getColumnIndex("status"));
        cursor.close();
        return at;
    }

    public String getparkcount(String id) {
        SQLiteDatabase db =getWritableDatabase();

        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_REGISTER + " WHERE id=? ", new String[]{id});
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String at = cursor.getString(cursor.getColumnIndex("amount"));
        cursor.close();
        return at;
    }

    public String updatestatus(String id,String status) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_STATUS,status);
        db.update(TABLE_REGISTER, values, COLUMN_ID + "=?", new String[]{id});
        db.close();
        return "1";

    }
    public void updatefinal(String id,String sthr,String stmin,String park,String status,String amt,String count) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PARK_ALLOT,park);
        values.put(COLUMN_STATUS,status);
        values.put(COLUMN_START_TIME_HOUR,sthr);
        values.put(COLUMN_START_TIME_MIN,stmin);
        values.put(COLUMN_AMOUNT,amt);
        values.put(COLUMN_PARK_COUNT,count);
        db.update(TABLE_REGISTER, values, COLUMN_ID + "=?", new String[]{id});
        db.close();

    }
}

