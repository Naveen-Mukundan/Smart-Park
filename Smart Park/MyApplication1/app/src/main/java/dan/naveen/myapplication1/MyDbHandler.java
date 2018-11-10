package dan.naveen.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHandler extends  SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 25;
    private static final String DATABASE_NAME = "smartdb.db";
    public static final String TABLE_REGISTER = "register";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LAST_NAME = "lastname";
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_PHONE = " phone";
    public static final String COLUMN_CAR_NUMBER = "car_number";
    public static final String COLUMN_CAR_COMP = "car_comp";
    public static final String COLUMN_CAR_COMP1 = "car_comp1";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "pass";



    public MyDbHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_REGISTER + "(" +
                COLUMN_ID + " TEXT NOT NULL, " +
                COLUMN_FIRST_NAME + " TEXT NOT NULL, " +
                COLUMN_LAST_NAME + " TEXT NOT NULL, " +
                COLUMN_PHONE + " TEXT NOT NULL, " +
                COLUMN_USER_NAME + " TEXT NOT NULL, " +
                COLUMN_CAR_NUMBER + " TEXT NOT NULL, " +
                COLUMN_CAR_COMP + " TEXT NOT NULL, " +
                COLUMN_CAR_COMP1 + " TEXT NOT NULL, " +
                COLUMN_EMAIL + " TEXT NOT NULL, " +

                COLUMN_PASSWORD + " TEXT NOT NULL " + ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_REGISTER);
        onCreate(db);
    }


    public boolean Login(String username, String password) throws Exception {

        SQLiteDatabase db = getWritableDatabase();
        Cursor mCursor = db.rawQuery(" SELECT * FROM " + TABLE_REGISTER + " WHERE username=? AND pass=? ", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }


    public void add(Register1 register1) {

        ContentValues values = new ContentValues();
       values.put(COLUMN_ID,"SP100");
        values.put(COLUMN_FIRST_NAME, register1.get_first_name());
        values.put(COLUMN_LAST_NAME, register1.get_last_name());
        values.put(COLUMN_PHONE, register1.get_phone());
        values.put(COLUMN_USER_NAME, register1.get_user_name());
        values.put(COLUMN_CAR_NUMBER, register1.get_car_number());
        values.put(COLUMN_CAR_COMP, register1.get_car_comp());
        values.put(COLUMN_CAR_COMP1, register1.get_car_comp1());
        values.put(COLUMN_EMAIL, register1.get_email());

        values.put(COLUMN_PASSWORD, register1.get_pass());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_REGISTER, null, values);
        db.close();
    }


    public String getSinlgeEntry(String userName) {
        SQLiteDatabase db =getWritableDatabase();

        Cursor cursor = db.query("register", null, " username=?", new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("id"));
        cursor.close();
        return password;
    }
}






