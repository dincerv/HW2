package com.dincervelioglu.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class GymTable {

    public static final String TABLE_NAME="gym";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_EQUIPMENT = "equipment";

    public static final String CREATE_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_ID+" number, "+FIELD_NAME +" text, "+FIELD_EQUIPMENT+" equipment);";
    public static final String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;

    public static ArrayList<Gym> getAllMedia (DatabaseHelper db){

        Cursor cursor = db.getAllRecords(TABLE_NAME, null);
        //Cursor cursor db.getAllRecordsMethod2("SELECT * FROM "+TABLE_NAME, null)
        ArrayList<Gym> data=new ArrayList<>();
        Gym gm = null; while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String equipment = cursor.getString(2);
            int image = cursor.getInt(3);
            gm = new Gym(id, name, equipment, image);
            data.add(gm);
        }
        return data;
    }

    public static ArrayList<Gym> findGm(DatabaseHelper db, String key){
        String where = FIELD_NAME+" like '%"+key+"%'";
        Cursor cursor = db.getSomeRecords(TABLE_NAME,null, where);
        ArrayList<Gym> data=new ArrayList<>();
        Gym gm = null; while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String equipment = cursor.getString(2);
            int image = cursor.getInt(3);
            gm = new Gym(id, name, equipment, image);
            data.add(gm); }
        return data;
    }

    public static boolean insertGm(DatabaseHelper db, int id, String name, String equipment){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_ID, id);
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_EQUIPMENT, equipment);

        boolean res = db.insert(TABLE_NAME,contentValues);

        return res;
    }

    public static boolean insertGm(DatabaseHelper db, Gym gm){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_ID, gm.getId());
        contentValues.put(FIELD_NAME, gm.getName());
        contentValues.put(FIELD_EQUIPMENT, gm.getEquipment());

        boolean res = db.insert(TABLE_NAME,contentValues);

        return res;
    }

    public static boolean updateGm(DatabaseHelper db, int id, String name, String equipment){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_EQUIPMENT, equipment);

        String where = FIELD_ID +" = "+id;
        boolean res = db.update(TABLE_NAME,contentValues,where);
        return res;
    }

    public static boolean updateGm(DatabaseHelper db, Gym gm){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, gm.getName());
        contentValues.put(FIELD_EQUIPMENT, gm.getEquipment());

        String where = FIELD_ID +" = "+gm.getId();
        boolean res = db.update(TABLE_NAME,contentValues,where);
        return res;
    }

    public static boolean deleteGm(DatabaseHelper db, int id){
        String where = FIELD_ID +" = "+ id;
        boolean res = db.delete(TABLE_NAME,where);
        return res;
    }
}