package com.example.mobilepackages.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


public class MyDbHelper extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public MyDbHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void queryData(String str) {
        getWritableDatabase().execSQL(str);
    }

    public void insertData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        SQLiteStatement compileStatement = writableDatabase.compileStatement("INSERT INTO " + str + " VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)");
        compileStatement.clearBindings();
        compileStatement.bindString(1, "" + str2);
        compileStatement.bindString(2, "" + str3);
        compileStatement.bindString(3, "" + str4);
        compileStatement.bindString(4, "" + str5);
        compileStatement.bindString(5, "" + str6);
        compileStatement.bindString(6, "" + str7);
        compileStatement.bindString(7, "" + str8);
        compileStatement.executeInsert();
    }

    public boolean hasObject(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        boolean z = true;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM " + str2 + " WHERE title =?", new String[]{str});
        if (rawQuery.moveToFirst()) {
            do {
            } while (rawQuery.moveToNext());
        } else {
            z = false;
        }
        rawQuery.close();
        writableDatabase.close();
        return z;
    }

    public void updateData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        SQLiteStatement compileStatement = writableDatabase.compileStatement("UPDATE " + str + " SET title=?, duration=?, volume=?, activation=?, deactivation=?, remaining=?, price=? WHERE id=?");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str2);
        compileStatement.bindString(1, sb.toString());
        compileStatement.bindString(2, "" + str3);
        compileStatement.bindString(3, "" + str4);
        compileStatement.bindString(4, "" + str5);
        compileStatement.bindString(5, "" + str6);
        compileStatement.bindString(6, "" + str7);
        compileStatement.bindString(7, "" + str8);
        compileStatement.bindDouble(8, (double) i);
        compileStatement.execute();
        writableDatabase.close();
    }

    public void deleteData(String str, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        SQLiteStatement compileStatement = writableDatabase.compileStatement("DELETE FROM " + str + " WHERE id=?");
        compileStatement.clearBindings();
        compileStatement.bindDouble(1, (double) i);
        compileStatement.execute();
        writableDatabase.close();
    }

    public void deleteData(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        SQLiteStatement compileStatement = writableDatabase.compileStatement("DELETE FROM " + str + " WHERE title=?");
        compileStatement.clearBindings();
        compileStatement.bindString(1, str2);
        compileStatement.execute();
        writableDatabase.close();
    }

    public Cursor getData(String str) {
        return getReadableDatabase().rawQuery(str, null);
    }
}
