package com.example.doanmobile.sql;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;

import java.io.IOException;
import java.io.InputStream;

public class Util {
    //database
    public static final String DATABASE_NAME = "db-user";
    public static final String TABLE_USER = "users";
    public static final String COLUMN_USER_ID = "ids";
    public static final String COLUMN_USER_NAME = "names";
    public static final String COLUMN_USER_AVATAR = "avatars";
    public static final String COLUMN_USER_DEPARTID = "departid";
    //Department
    public static final String TABLE_DEPARTMENT = "department";
    public static final String COLUMN_DEPA_ID = "ids";
    public static final String COLUMN_DEPA_NAME = "names";

    public static Bitmap convertToBitmapFromAssets(Context contexts, String nameImage)
    {
        AssetManager assetManager = contexts.getAssets();
        try {
            InputStream inputStream = assetManager.open("images/"+nameImage);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}

