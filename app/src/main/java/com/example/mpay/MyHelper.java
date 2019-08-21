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
        String sql="CREATE TABLE PRODUCTS(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,DESCRIPTION TEXT,PRICE REAL,VAT INTEGER,TOTAL INTEGER,TXN INTEGER,RUPI INTEGER,PHONE INTEGER )";
        db.execSQL(sql);
        insertData("Binita Niroula","Laxmi Dhakal",1500.00,50,1550,1234556565,9750,98009090,db);
        //insertData("laxmi dhakal","Mamta sharma",1500.00,50,1550,1234556565,9750,98009090,db);
       // insertData("Mamta sharma","Binita niroula",1500.00,50,1550,1234556565,9750,98009090,db);




    }
    private void insertData(String name,String description,double price,Integer vat,Integer total, Integer txn,Integer amount,Integer phone,SQLiteDatabase database){
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("DESCRIPTION",description);
        values.put("PRICE",price);
        values.put("VAT",vat);
        values.put("TOTAL",total);
        values.put("TXN",txn);
        values.put("RUPI",amount);
        values.put("PHONE",phone);
        database.insert("PRODUCTS",null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}


