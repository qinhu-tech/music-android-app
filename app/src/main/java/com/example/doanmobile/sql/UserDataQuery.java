package com.example.doanmobile.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserDataQuery {
    // thêm mới 1 user
    public static long insert(Context contexts, Userss us)
    {
        UserDBHelper userDBHelper= new UserDBHelper(contexts);
        SQLiteDatabase sqLiteDatabase= userDBHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Util.COLUMN_USER_DEPARTID,us.departid);
        values.put(Util.COLUMN_USER_NAME,us.names);
        values.put(Util.COLUMN_USER_AVATAR,us.avatars);
        long rs= sqLiteDatabase.insert(Util.TABLE_USER,null,values);
        return (rs);
    }
    // lay danh sach
    public static ArrayList<Userss> getAll(Context context)
    {
        ArrayList<Userss> lstUsers = new ArrayList<>();
        UserDBHelper userDBHelper= new UserDBHelper(context);
        SQLiteDatabase db=userDBHelper.getReadableDatabase();
        String strReadUser= "select us.*, de.names as departname from users us left join department de on us.departid= de.ids" ;
        //Cursor cs= db.rawQuery("Select * from "+Util.TABLE_USER,null);
        Cursor cs= db.rawQuery(strReadUser,null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            int ids= cs.getInt(0);
            String names= cs.getString(1);
            String avatars= cs.getString(2);
            Userss item= new Userss(ids,names,avatars);
            item.departid= cs.getInt(3);
            item.departname= cs.getString(4);
            lstUsers.add(item);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return lstUsers;
    }
    // xoa item
    public static boolean delete (Context contexts, int ids)
    {
        UserDBHelper userDBHelper= new UserDBHelper(contexts);
        SQLiteDatabase sqLiteDatabase= userDBHelper.getWritableDatabase();
        int rs= sqLiteDatabase.delete(Util.TABLE_USER,Util.COLUMN_USER_ID+"=?", new String[]{String.valueOf(ids)});
        return (rs>0);
    }
    // cập nhật
    public static int update(Context contexts, Userss us)
    {
        UserDBHelper userDBHelper= new UserDBHelper(contexts);
        SQLiteDatabase sqLiteDatabase= userDBHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Util.COLUMN_USER_NAME,us.getNames());
        values.put(Util.COLUMN_USER_AVATAR,us.getAvatars());
        values.put(Util.COLUMN_USER_DEPARTID,us.getDepartid());
        int rs= sqLiteDatabase.update(Util.TABLE_USER,values,Util.COLUMN_USER_ID+"=?",new String[]{String.valueOf(us.ids)});
        return  (rs);
    }
}
