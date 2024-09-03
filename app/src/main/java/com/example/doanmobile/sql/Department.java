package com.example.doanmobile.sql;

public class Department {
    int ids;
    String names;

    public Department(int ids, String names) {
        this.ids = ids;
        this.names = names;
    }

    public int getIds() {
        return ids;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Override
    public String toString(){return names;}
}
