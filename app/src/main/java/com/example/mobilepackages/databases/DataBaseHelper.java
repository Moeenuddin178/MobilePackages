package com.example.mobilepackages.databases;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Database.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    static Cursor cursor;

    private static DataBaseHelper instance;
    public static String DB_PATH = "";
    private static SQLiteDatabase sqliteDb;

    private Context context=null;

    public DataBaseHelper(Context paramContext) {
        super(paramContext, DATABASE_NAME, null, 1);
        //check os version for accessing database directery
        if (Build.VERSION.SDK_INT >= 17)
            DB_PATH = paramContext.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + paramContext.getPackageName() + "/databases/";
        this.context = paramContext;
    }

    @Override
    public synchronized void close() {
        if (sqliteDb != null)
            sqliteDb.close();
        super.close();
    }


    private boolean checkDatabase() {
        SQLiteDatabase tempDB = null;
        try {
            String path = DB_PATH + DATABASE_NAME;
            tempDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);

        } catch (SQLiteException exception) {
        }
        if (tempDB != null)
            tempDB.close();
        return tempDB!=null?true:false;
    }

    private  void copyDataBase() {
        try {
            InputStream myInput = context.getAssets().open(DATABASE_NAME);
            String outfilename = DB_PATH+DATABASE_NAME;
            OutputStream myOutput=new FileOutputStream(outfilename);
            int lenght;
            byte[] buffer = new byte[1024];
            while ((lenght=myInput.read(buffer))>0){
                myOutput.write(buffer, 0, lenght);
                }
            //close flush
            myOutput.flush();
            myInput.close();
            myInput.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openDatabase(){

        String path = DB_PATH + DATABASE_NAME;
        sqliteDb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void createDatabase(){
        boolean isDBExists= checkDatabase();
        if(isDBExists){

        }
        else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            }catch (Exception e){}
        }
    }


    public Cursor rawQuery(String paramString) {
            sqliteDb=this.getWritableDatabase();
           Cursor cursor;
            cursor=sqliteDb.rawQuery(paramString,null);
        return cursor;

    }


    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    }
}

