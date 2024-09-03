package com.example.doanmobile.song;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Utilss {
    public static String getAssetJsonData(Context contextss) {
        String json;
        try{
            InputStream is = contextss.getAssets().open("json/songs.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
