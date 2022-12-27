package com.dincervelioglu.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "gymDB.db";
    private static int DATABASE_VERSION = 1;
    SQLiteDatabase db;
    Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();//Writable and Readable mode
        Log.d("DATABASE OPERATIONS", "Connection Provided");
    }

    public void close() {
        if (db != null && db.isOpen()) {
            db.close();//Wirtable and Readable mode
            Log.d("DATABASE OPERATIONS", "CLOSE");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //onCreate called if database doesn't exist
            try {
                sqLiteDatabase.execSQL(GymTable.CREATE_TABLE_SQL);
            }catch (SQLException e){
                e.printStackTrace();
            }
            Log.d("DATABASE OPERATIONS","OnCreate, table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //onUpgrade called when DATABASE_VERSION is changed
        // SQLiteDatabase object used to execute SQL statements
        try {
            sqLiteDatabase.execSQL(GymTable.DROP_TABLE_SQL);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(sqLiteDatabase);
        Log.d("DATABASE OPERATIONS","onUpgrade, table dropped, old version "
                +oldVersion+" new version "+newVersion);
    }

    public void openDatabase () {
        String dbPath = context.getDatabasePath (DATABASE_NAME).getPath();
        if (db != null && db.isOpen()) {
            return;
        }
        db = SQLiteDatabase.openDatabase (dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase () {
        if (db != null) {
            db.close();
        }

    }
        public List<Gym> getListExercises() {
            Gym gym = null;
            List<Gym> exercisesList = new ArrayList<>();
            openDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM PRODUCT", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                gym = new Gym(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
                exercisesList.add(gym);
                cursor.moveToNext();
            }
            cursor.close();
            closeDatabase();
            return exercisesList;
        }

    public Cursor getAllRecords(String tableName, String[] columns ){
        Cursor cursor = db.query(tableName, columns, null, null, null, null, null );
        Log.d("DATABASE OPERATIONS", "GET THE RECORDS");
        return cursor;
    }

    public Cursor getSomeRecords(String tableName, String[] columns, String where ){
        Cursor cursor = db.query(tableName, columns, where, null, null, null, null); Log.d("DATABASE OPERATIONS", "GET ALL RECORDS WITH WHERE CLAUSE");
        return cursor;
    }

    public boolean insert(String tableName, ContentValues contentValues){
        //ContentValues allows to define key value pairs.
        // The key represents the table column identifier and the value represents the content for the table record in this column.
        // ContentVales can be used for insert and update operations over table
        Log.d("DATABASE OPERATIONS", "INSERT DONE");
        return db.insert(tableName, null, contentValues)>0;
    }

    public boolean update(String tableName, ContentValues contentValues, String whereCondition){
        //ContentValues allows to define key value pairs.
        // The key represents the table column identifier and the value represents the content for the table record in this column.
        // ContentVales can be used for insert and update operations over table
        Log.d("DATABASE OPERATIONS", "UPDATE DONE");
        return db.update(tableName,contentValues,whereCondition,null)>0;
    }

    public boolean delete(String tableName, String whereCondition){
        Log.d("DATABASE OPERATIONS", "DELETE DONE");
        return db.delete(tableName, whereCondition, null)>0;
    }
}