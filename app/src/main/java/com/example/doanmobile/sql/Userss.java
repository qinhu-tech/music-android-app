package com.example.doanmobile.sql;

import android.provider.ContactsContract;

public class Userss {
    int ids;
    String names;
    String avatars;
    int departid;
    String departname;

    public Userss(int ids, String names, String avatars) {
        this.ids = ids;
        this.names = names;
        this.avatars = avatars;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public int getDepartid() {
        return departid;
    }

    public void setDepartid(int departid) {
        this.departid = departid;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }
}
