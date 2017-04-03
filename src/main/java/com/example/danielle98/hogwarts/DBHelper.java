package com.example.danielle98.hogwarts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Danielle98 on 3/31/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String TAG = DBHelper.class.getSimpleName();
    public static final String DB_name = "Hogwarts Database";
    public static final int DB_version = 7;

    public static final String WIZARDS_TABLE= "wizards";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "Wizard";
    public static final String COLUMN_PASS = "Password";
    public static final String COLUMN_HOUSE = "House";


    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + WIZARDS_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_PASS + " TEXT,"
            + COLUMN_HOUSE + " TEXT);";

    public DBHelper(Context context) {
        super(context, DB_name, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WIZARDS_TABLE);
        onCreate(db);
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String email, String password, String house) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, email);
        values.put(COLUMN_PASS, password);
        values.put(COLUMN_HOUSE, house);

        long id = db.insert(WIZARDS_TABLE, null, values);
        db.close();

        Log.d(TAG, "user inserted" + id);
    }

    public boolean getUser(String email, String pass){
        String selectQuery = "select * from  " + WIZARDS_TABLE + " where " +
                COLUMN_NAME + " = " + "'"+email+"'" + " AND " + COLUMN_PASS + " = " + "'"+pass+"';";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }
}
