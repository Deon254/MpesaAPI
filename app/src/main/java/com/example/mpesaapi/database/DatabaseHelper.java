package com.example.mpesaapi.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

import java.sql.PreparedStatement;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String database = "mpesa.db";

    //stk push table
    public static final String table = "stkpush";
    public static final String id = "id";
    public static final String password = "password";
    public static final String date = "dates";
    public static final String checkOutId = "checkOutId";


    public DatabaseHelper(@Nullable Context context) {
        super(context, database, null, 1);
        Log.d("DATABASE: ","database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE stkpush (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,password TEXT,dates VARCHAR(50),checkOutId TEXT)");
        //db.execSQL("CREATE TABLE login(name varchar(50),password varchar(50))");
        Log.d("DATABASE: ","table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS login");
        onCreate(db);
    }

    public void insertSTKPush(String password,String date,String checkOutId){
        SQLiteDatabase database = getWritableDatabase();
        String sql ="INSERT INTO " + table + "(password,dates,checkOutId)VALUES(?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,password);
        statement.bindString(2,date);
        statement.bindString(3,checkOutId);
        statement.executeInsert();
        statement.close();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(sql,null);
    }




}
