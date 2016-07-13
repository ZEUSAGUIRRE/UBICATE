package com.example.tecnoparque4.prototipo.Base_Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.security.PublicKey;

public class DataBaseManager {
//----------------------------------TABLA 1----------------------------------------------
    public static  final String TABLE_INSUMOS="INSUMOS"; // Nombre de la tabla
    public static  final String Dni="Dni";
    public static  final String Tipo_Insumo="Tipo_Insumo";
    public static  final String Nombre_Insumo="Nombre_Insumo";
    public static  final String Can_Insumo="Can_Insumo";
    public static  final String Presen_Insumo="Presen_Insumo";
    public static  final String Precio_Insumo="Precio_Insumo";

    public static  final String CREATE_TABLE_INSUMOS = "create table "+TABLE_INSUMOS+" ("
           + Dni +" integer primary key autoincrement,"
           + Tipo_Insumo+" text not null,"
           + Nombre_Insumo+ " text not null,"
           + Can_Insumo+ " text," //integer
           + Presen_Insumo +" text not null,"
           + Precio_Insumo +" text);" ; //integer
//------------------------------------Tabla 2---------------------------------------------
  private AdminSQLiteOpenHelper helper;
  private  SQLiteDatabase db;

    public DataBaseManager(Context context) {
         helper = new AdminSQLiteOpenHelper(context);
         db = helper.getWritableDatabase();

    }

    public Boolean INSERTAR(String TABLA, String COL_1, String COL_2, String COL_3, String Entero_1, String Entero_2){
            ContentValues valores = new ContentValues();
        Boolean Guardado=null;
        switch (TABLA){
            case "INSUMOS":
              //  db.execSQL("insert into "+TABLA+" values (null, '"+COL_1+"','"+COL_2+"',"+Entero_1+",'"+COL_3+"',"+Entero_2+")");
                valores.put(Tipo_Insumo,COL_1);
                valores.put(Nombre_Insumo,COL_2);
                valores.put(Can_Insumo,Entero_1);
                valores.put(Presen_Insumo,COL_3);
                valores.put(Precio_Insumo,Entero_2);
                db.insert(TABLA,null,valores);
                Guardado = true;
                break;
        }
        db.close();
    return Guardado;
    }


    public  Boolean ELIMINAR(String TABLA,String COLUMNA,String LLAVE){
        Boolean Eliminado=null;
        db.delete(TABLA,COLUMNA+"=?",new String[]{LLAVE});






        db.close();
        return Eliminado;
    }

    public  Boolean MODIFICAR(String TABLA,String COLUMNA,String LLAVE){
        Boolean Modificado=null;
//        db.update(TABLA,valores,COLUMNA+"=?",new String[]{LLAVE});



        db.close();
        return Modificado;
    }

    public  Cursor MOSTRAR(){
        Cursor C;
        String[] Columnas = new String[]{Tipo_Insumo,Nombre_Insumo,Can_Insumo,Presen_Insumo,Precio_Insumo};
         C = db.query(TABLE_INSUMOS,Columnas,null, null,null,null,null);

        if (C!=null){
            C.moveToFirst();
        }
        db.close();
        return C;
    }
}
