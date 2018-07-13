package com.example.admin.sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.sqlite.model.Champion;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "lolchampion_manager";
    private static String TABLE_NAME = "lol";

    private String SQLquery = "create table " + TABLE_NAME +
            " ( id integer primary key autoincrement, name text, price float, type text)";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addChampion(Champion champion)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", champion.getName());
        values.put("price", champion.getPrice());
        values.put("type", champion.getType());
        db.insert(TABLE_NAME,null,values);
    }
    public List<Champion> getAllChampion()
    {
        List<Champion> listStudent = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            do {
                Champion champion = new Champion();
                champion.setName(cursor.getString(1));
                champion.setPrice(cursor.getDouble(2));
                champion.setType(cursor.getString(3));
                listStudent.add(champion);
            } while (cursor.moveToNext());
        }
        db.close();
        return  listStudent;
    }
}
