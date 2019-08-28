package com.example.mpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    private static final String dbname="mydb";
    private static final int version=1;
    public MyHelper( Context context) {
        super(context,dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE BINITA(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,DESCRIPTION TEXT,PRICE REAL,VAT DOUBLE,TOTAL INTEGER,TXN INTEGER,RUPI INTEGER )";
        db.execSQL(sql);

        insertData("Binita Niroula","Laxmi Dhakal",1500.00,0.13*1500,1550,1234556565,9750,db);




    }
    private void insertData(String name,String receiver,double price,double vat,Integer total, Integer txn,Integer amount,SQLiteDatabase database){
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("DESCRIPTION",receiver);
        values.put("PRICE",price);
        values.put("VAT",vat);
        values.put("TOTAL",total);
        values.put("TXN",txn);
        values.put("RUPI",amount);

        database.insert("BINITA",null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}


