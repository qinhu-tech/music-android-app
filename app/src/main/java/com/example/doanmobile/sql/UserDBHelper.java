package com.example.doanmobile.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.doanmobile.Utils;

public class UserDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = Util.DATABASE_NAME;
    private static final int DATABASE_VERSION = 3;

    public UserDBHelper(Context contexts) {

        super(contexts, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_DEPA_TABLE = "CREATE TABLE " + Util.TABLE_DEPARTMENT + "("
                + Util.COLUMN_DEPA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Util.COLUMN_DEPA_NAME + " TEXT"
                +")";
        String CREATE_USER_TABLE = "CREATE TABLE " + Util.TABLE_USER + "("
                + Util.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Util.COLUMN_USER_NAME + " TEXT, "
                + Util.COLUMN_USER_AVATAR + " TEXT,"
                + Util.COLUMN_USER_DEPARTID + " TEXT"
                +")";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_DEPA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_USER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_DEPARTMENT);
        onCreate(sqLiteDatabase);
    }
}
