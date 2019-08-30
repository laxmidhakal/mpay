package sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_CUSTOMER = "customer";
    private static final String TABLE_COMPANY = "company";
    private static final String HIST0RY_USER = "HISTORY";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_BANKNAME = "user_bankname";
    private static final String COLUMN_USER_ACCOUNTNO = "user_accountno";
    private static final String COLUMN_USER_MOBILE = "user_mobile";
    //transaction history user
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CUSTOMER_ID = "cutomer_id";
    private static final String COLUMN_VAT = "vat";
    private static final String COLUMN_COMPANYID = "companyid";
    private static final String COLUMN_AMOUNT = "amount";

    private String CREATE_HISTORY_TABLE = "CREATE TABLE " + HIST0RY_USER + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CUSTOMER_ID + " TEXT,"
            + COLUMN_VAT + " INTEGER," + COLUMN_COMPANYID +"INTEGER,"+COLUMN_AMOUNT+"INTEGER"+ ")";




    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," +COLUMN_USER_BANKNAME + " TEXT,"+COLUMN_USER_ACCOUNTNO + " INTEGER,"+COLUMN_USER_MOBILE+" INTEGER"+ ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_HISTORY_TABLE);
        //company ko table
        String sql="CREATE TABLE COMPANY(_id INTEGER PRIMARY KEY AUTOINCREMENT, TXN INTEGER,NAME STRING,BANKNAME STRING,ACCOUNTNUMBER INTEGER )";
        db.execSQL(sql);
        insertData(1234556565,"footwear","Himalaya bank",21345,db);
        insertData(1234587688,"clothingstore","Himal bank",32145,db);
        insertData(1256565666,"kiranasuppliers","Asian bank",521345,db);
        //user table
        String user="CREATE TABLE USER(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,RECEIVER TEXT,PRICE REAL,VAT DOUBLE,TOTAL INTEGER,TXN INTEGER,AMOUNT INTEGER )";
        db.execSQL(user);
        insertuser("Mamta sharma","Binita niroula",1500.00,0.13*1500,1550,1234556565,9750,db);
        insertuser("Laxmi Dhakal","Sweta koirala",1500.00,0.13*1500,1550,1234556565,9750,db);
        insertuser("Binita Niroula","Laxmi Dhakal",1500.00,0.13*1500,1550,1234556565,9750,db);
        db.execSQL(CREATE_USER_TABLE);

    }
    //company ko insert garne data
    private void insertData(Integer txn,String name,String bankname,Integer accountno,SQLiteDatabase database){
        ContentValues values=new ContentValues();
        values.put("TXN",txn);
        values.put("NAME",name);
        values.put("BANKNAME",bankname);
        values.put("ACCOUNTNUMBER",accountno);

        database.insert("COMPANY",null,values);

    }
    //mamta ko insert gareko data
    private void insertuser(String name,String receiver,double price,double vat,Integer total, Integer txn,Integer amount,SQLiteDatabase database){
        ContentValues value=new ContentValues();
        value.put("NAME",name);
        value.put("RECEIVER",receiver);
        value.put("PRICE",price);
        value.put("VAT",vat);
        value.put("TOTAL",total);
        value.put("TXN",txn);
        value.put("RUPI",amount);
        database.insert("USER",null,value);

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_BANKNAME,user.getBankname());
        values.put(COLUMN_USER_ACCOUNTNO,user.getAccount());
        values.put(COLUMN_USER_MOBILE,user.getMobile());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_BANKNAME,
                COLUMN_USER_ACCOUNTNO,
                COLUMN_USER_MOBILE
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setBankname(cursor.getString(cursor.getColumnIndex(COLUMN_USER_BANKNAME)));
                user.setAccount(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ACCOUNTNO))));
                user.setMobile(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_MOBILE))));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_BANKNAME,user.getBankname());
        values.put(COLUMN_USER_ACCOUNTNO,user.getAccount());
        values.put(COLUMN_USER_MOBILE,user.getMobile());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
