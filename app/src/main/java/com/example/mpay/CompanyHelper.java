package com.example.mpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CompanyHelper extends SQLiteOpenHelper {
    private static final String dbname="company";
    private static final int version=1;
    public CompanyHelper( Context context) {
        super(context,dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE COMPANY(_id INTEGER PRIMARY KEY AUTOINCREMENT, TXN INTEGER,NAME STRING,BANKNAME STRING,ACCOUNTNUMBER INTEGER )";
        db.execSQL(sql);
        insertData(1234556565,"footwear","Himalaya bank",21345,db);
        insertData(1234587688,"clothingstore","Himal bank",32145,db);
        insertData(1256565666,"kiranasuppliers","Asian bank",521345,db);





    }
    private void insertData(Integer txn,String name,String bankname,Integer accountno,SQLiteDatabase database){
        ContentValues values=new ContentValues();
        values.put("TXN",txn);
        values.put("NAME",name);
        values.put("BANKNAME",bankname);
        values.put("ACCOUNTNUMBER",accountno);




      database.insert("COMPANY",null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}




