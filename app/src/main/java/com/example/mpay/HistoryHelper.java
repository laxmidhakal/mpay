package com.example.mpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class HistoryHelper extends SQLiteOpenHelper {
    private static final String dbname = "history";
    private static final int version = 1;
    private static final String TABLE_USER = "HISTORY";

    // User Table Columns names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CUSTOMER_ID = "cutomer_id";
    private static final String COLUMN_VAT = "vat";

    public HistoryHelper(Context context) {
        super(context, dbname, null, 1);
    }

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CUSTOMER_ID + " TEXT,"
            + COLUMN_VAT + " TEXT" + ")";
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);


    }

  /*  public void add(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CUSTOMER_ID, customer.getCustomerid());
        values.put(COLUMN_VAT, customer.getvat());


        // Inserting Row
        db.insert(TABLE_USER, null, values);
        //db.close();
      /*  public List<Customer> getAllCustomer () {
            // array of columns to fetch
            String[] columns = {
                    COLUMN_ID,
                    COLUMN_CUSTOMER_ID,
                    COLUMN_VAT,

            };
            // sorting orders
            String sortOrder =
                    COLUMN_CUSTOMER_ID + " ASC";
            List<User> userList = new ArrayList<User>();

            SQLiteDatabase db = this.getReadableDatabase();

            // query the user table
            /**
             * Here query function is used to fetch records from user table this function works like we use sql query.
             * SQL query equivalent to this query function is
             * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
             */
       /* Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
    }*/
}








