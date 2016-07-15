package com.example.tecnoparque4.prototipo.Base_Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tecnoparque4.prototipo.Clases_Objetos.CL_Fincas;
import com.example.tecnoparque4.prototipo.Clases_Objetos.CL_Insumos;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
    private AdminSQLiteOpenHelper helper;
    private  SQLiteDatabase db;
    //----------------------------------TABLA 1----------------------------------------------
    public static  final String TABLE_INSUMOS="INSUMOS"; // Nombre de la tabla
    public static  final String Dni="Dni";
    public static  final String Tipo_Insumo="Tipo_Insumo";
    public static  final String Nombre_Insumo="Nombre_Insumo";
    public static  final String Can_Insumo="Can_Insumo";
    public static  final String Presen_Insumo="Presen_Insumo";
    public static  final String Precio_Insumo="Precio_Insumo";
    public static  final String CREATE_TABLE_INSUMOS = "create table "+TABLE_INSUMOS+" ("
           +Dni +" integer primary key autoincrement,"+Tipo_Insumo+" text not null,"
           +Nombre_Insumo+ " text not null,"+Can_Insumo+ " int," //integer
           +Presen_Insumo +" text not null,"+ Precio_Insumo +" int);" ; //integer
//------------------------------------Tabla 2---------------------------------------------
    public static  final String TABLE_FINCA="FINCA";
    public static  final String NOMBRE_FINCA="NOMBRE_FINCA";
    public static  final String ESTADO_FINCA="ESTADO_FINCA";
    public static  final String CREATE_TABLE_FINCA = "create table "+TABLE_FINCA+" ("
            + Dni +" integer primary key autoincrement,"+ NOMBRE_FINCA +" text not null,"+ ESTADO_FINCA +" text not null);";
//------------------------------------Tabla 3---------------------------------------------
    public static  final String TABLE_ADMIN="ADMIN"; // Nombre de la tabla
    public static  final String USUARIO="USUARIO";
    public static  final String CONTRASENA="CONTRASENA";
    public static  final String CREATE_TABLE_ADMIN = "create table "+TABLE_ADMIN+" ("+USUARIO+" TEXT primary key,"+ CONTRASENA +" text not null);";
//------------------------------------Tabla 3---------------------------------------------
    public DataBaseManager(Context context) {
         helper = new AdminSQLiteOpenHelper(context);
         db = helper.getWritableDatabase();
    }

    public Boolean INSERTAR(String TABLA, String COL_1, String COL_2, String COL_3, int Entero_1, int Entero_2){
            ContentValues valores = new ContentValues();
        Boolean Guardado=null;
        switch (TABLA){
            case TABLE_ADMIN:
                valores.put(USUARIO,COL_1);
                valores.put(CONTRASENA,COL_2);
                db.insert(TABLE_ADMIN,null,valores);
                Guardado = true;
                break;
            case TABLE_INSUMOS:
                        valores.put(Tipo_Insumo,COL_1);
                        valores.put(Nombre_Insumo,COL_2);
                        valores.put(Can_Insumo,Entero_1);
                        valores.put(Presen_Insumo,COL_3);
                        valores.put(Precio_Insumo,Entero_2);
                        db.insert(TABLE_INSUMOS,null,valores);
                        Guardado = true;
                        break;
            case TABLE_FINCA:
                        valores.put(NOMBRE_FINCA,COL_1);
                        valores.put(ESTADO_FINCA,COL_2);
                        db.insert(TABLE_FINCA,null,valores);
                        Guardado = true;
                        break;
        }
        db.close();
    return Guardado;
    }
//    public  Boolean ELIMINAR(String TABLA,String COLUMNA,String LLAVE){
//        Boolean Eliminado=null;
//        db.delete(TABLA,COLUMNA+"=?",new String[]{LLAVE});
//        db.close();
//        return Eliminado;
//    }

//    public  Boolean MODIFICAR(String TABLA,String COLUMNA,String LLAVE){
//        Boolean Modificado=null;
////        db.update(TABLA,valores,COLUMNA+"=?",new String[]{LLAVE});
//        db.close();
//        return Modificado;
//    }

    public ArrayList<CL_Insumos> GetListaInsumos(){
        ArrayList<CL_Insumos>Lista = new ArrayList<CL_Insumos>();
        Cursor C = db.rawQuery("SELECT "+Tipo_Insumo+","+Nombre_Insumo+","+Can_Insumo+","+Presen_Insumo+","+Precio_Insumo+" FROM "+TABLE_INSUMOS,null);
        while (C.moveToNext()){
        CL_Insumos m = new CL_Insumos();
        m.setTxt_Tipo_Insumo(C.getString(0));
        m.setTxt_Nombre_Insumo(C.getString(1));
        m.setTxt_Can_Insumo(C.getInt(2));
        m.setTxt_Presentacion(C.getString(3));
        m.setTxt_Precio_Insumo(C.getInt(4));
        Lista.add(m);
        }
        return Lista;
    }

    public  ArrayList<String> GetListaFincas(){
        ArrayList<String>Lista = new ArrayList<String>();
        Cursor C = db.rawQuery("SELECT "+Dni+","+NOMBRE_FINCA+","+ESTADO_FINCA+" FROM "+TABLE_FINCA,null);
        while (C.moveToNext()){
        String M;
        M = String.valueOf(C.getInt(0));
        M = M +" "+C.getString(1);
        M = M +" "+ C.getString(2);
        Lista.add(M);
        }
        return Lista;
    }

    public boolean LOGIN(String USU, String CONTRA){
        boolean ENTRAR=false;
        Cursor C = db.rawQuery("SELECT "+USUARIO+","+CONTRASENA+" FROM "+TABLE_ADMIN+" WHERE "+USUARIO+"='"+USU+"' AND "+CONTRASENA+"='"+CONTRA+"'",null);
        if (C.moveToFirst()){
            ENTRAR=true;
        }
        return ENTRAR;
    }

    public  ArrayList<String> GetListaADMIN(){
        ArrayList<String>Lista = new ArrayList<String>();
        Cursor C = db.rawQuery("SELECT "+USUARIO+","+CONTRASENA+" FROM "+TABLE_ADMIN,null);
        while (C.moveToNext()){
            String M="";
            M = M +" "+C.getString(0);;
            M = M +" "+C.getString(1);
            Lista.add(M);
        }
        return Lista;
    }
}
