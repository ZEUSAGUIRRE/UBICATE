package com.example.tecnoparque4.prototipo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TECNOPARQUE4 on 29/06/2016.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
        String TABLE_1 = "ADMIN";
        String BD = "FINCA_1";
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_1+"(CEDULA INTEGER PRIMARY KEY," +
                                           " NOMBRE TEXT," +
                                           " APELLIDOS TEXT," +
                                           " CONTRASEÑA TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_1);
        db.execSQL("CREATE TABLE "+TABLE_1+"(CEDULA INTEGER PRIMARY KEY," +
                                           " NOMBRE TEXT," +
                                           " APELLIDOS TEXT," +
                                           " CONTRASEÑA TEXT)");
    }
}
