package com.example.tecnoparque4.prototipo;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.example.tecnoparque4.prototipo.Base_Datos.DataBaseManager;
import com.example.tecnoparque4.prototipo.Clases_Objetos.ArrayAdapterCl_Fincas;
import java.util.ArrayList;

public class Fincas extends AppCompatActivity implements View.OnClickListener {
    Spinner  Spinner_fincas;
    Button Btn_entrar,Btn_Crear_Finca;
    DataBaseManager manager;
    ArrayAdapterCl_Fincas adaptador;
    ArrayList<String> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fincas);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Spinner_fincas =(Spinner) findViewById(R.id.Spinner_fincas);
        Btn_entrar =(Button)findViewById(R.id.Btn_Entrar_Admin);
        Btn_Crear_Finca =(Button)findViewById(R.id.Btn_Crear_Finca);
        Btn_entrar.setOnClickListener(this);
        Btn_Crear_Finca.setOnClickListener(this);
        LLENAR_FINCAS();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.Btn_Entrar_Admin:
               //Fincas.this.finish();
               Intent intent = new Intent(Fincas.this,Sacam_admin.class);
           String Dato= Spinner_fincas.getOnItemSelectedListener().toString();
               intent.putExtra("Nombre_finca",Dato);
               startActivity(intent);
               break;
            case R.id.Btn_Crear_Finca:
                FragmentManager fragmentManager = getFragmentManager();
                My_Dialogo my_dialogo = new My_Dialogo();
                my_dialogo.show(fragmentManager,"My_Dialogo");
                break;
        }
    }

    public void LLENAR_FINCAS(){
        manager= new DataBaseManager(this);
        List= new ArrayList<String>();
        List=manager.GetListaFincas();
 //       List=manager.GetListaADMIN();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.lista_fincas,R.id.text_1_finca,List);
        Spinner_fincas.setAdapter(adapter);
    }
}
