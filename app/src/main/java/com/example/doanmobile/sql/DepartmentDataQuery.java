package com.example.doanmobile.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DepartmentDataQuery {
    // thêm mới 1 user
    public static long insert(Context contexts, Department de)
    {

        UserDBHelper userDBHelper= new UserDBHelper(contexts);
        SQLiteDatabase sqLiteDatabase= userDBHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Util.COLUMN_DEPA_NAME,de.names);

        long rs= sqLiteDatabase.insert(Util.TABLE_DEPARTMENT,null,values);
        return (rs);
    }
    // lay danh sach
    public static ArrayList<Department> getAll(Context contexts)
    {
        ArrayList<Department> lstDepartment= new ArrayList<>();
        UserDBHelper userDBHelper= new UserDBHelper(contexts);
        SQLiteDatabase db=userDBHelper.getReadableDatabase();
        Cursor cs= db.rawQuery("Select * from "+Util.TABLE_DEPARTMENT,null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            int ids = cs.getInt(0);
            String names= cs.getString(1);
            lstDepartment.add(new Department(ids,names));
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return lstDepartment;

    }
    // xoa item
    public static boolean delete (Context contexts, int ids)
    {
        UserDBHelper userDBHelper= new UserDBHelper(contexts);
        SQLiteDatabase sqLiteDatabase= userDBHelper.getWritableDatabase();
        int rs= sqLiteDatabase.delete(Util.TABLE_DEPARTMENT,Util.COLUMN_USER_ID+ "=?", new String[]{String.valueOf(ids)});
        return (rs>0);
    }
    // cập nhật
    public static int update(Context contexts, Department de)
    {
        UserDBHelper userDBHelper= new UserDBHelper(contexts);
        SQLiteDatabase sqLiteDatabase= userDBHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Util.COLUMN_DEPA_NAME,de.getNames());
        int rs= sqLiteDatabase.update(Util.TABLE_DEPARTMENT,values,Util.COLUMN_DEPA_ID + "=?",new String[]{String.valueOf(de.ids)});
        return  (rs);
    }
}
