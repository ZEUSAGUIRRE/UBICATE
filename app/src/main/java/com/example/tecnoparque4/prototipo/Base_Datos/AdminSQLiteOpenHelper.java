package com.example.tecnoparque4.prototipo.Base_Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    DataBaseManager PP;
    private  static  final String DB_NAME ="SACAM";
    private  static  final int DB_SCHEME_VERSION=1;

    public AdminSQLiteOpenHelper(Context context) {
        super(context, DB_NAME,null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBaseManager.CREATE_TABLE_INSUMOS);
            db.execSQL(DataBaseManager.CREATE_TABLE_FINCA);
            db.execSQL(DataBaseManager.CREATE_TABLE_ADMIN);
//            ContentValues dato= new ContentValues();
//            dato.put(PP.USUARIO,"ADMIN");
//            dato.put(PP.CONTRASENA,"SACAM");
//            db.insert("ADMIN",null,dato);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DataBaseManager.TABLE_INSUMOS);
            db.execSQL("DROP TABLE IF EXISTS "+DataBaseManager.TABLE_FINCA);
            db.execSQL("DROP TABLE IF EXISTS "+DataBaseManager.TABLE_ADMIN);
            db.execSQL(DataBaseManager.CREATE_TABLE_INSUMOS);
            db.execSQL(DataBaseManager.CREATE_TABLE_FINCA);
            db.execSQL(DataBaseManager.CREATE_TABLE_ADMIN);
    }
}
