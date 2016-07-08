package com.example.tecnoparque4.prototipo;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Fincas extends AppCompatActivity implements View.OnClickListener {

    Spinner Spiner_fincas;
    Button Btn_entrar,Btn_Crear_Finca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fincas);

        Spiner_fincas =(Spinner)findViewById(R.id.Spineer_fincas);
        Btn_entrar =(Button)findViewById(R.id.Btn_Entrar_Admin);
        Btn_Crear_Finca =(Button)findViewById(R.id.Btn_Crear_Finca);
        Btn_entrar.setOnClickListener(this);
        Btn_Crear_Finca.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.Btn_Entrar_Admin:
               Intent intent = new Intent(Fincas.this,Sacam_admin.class);
               startActivity(intent);
               break;
            case R.id.Btn_Crear_Finca:
                FragmentManager fragmentManager = getFragmentManager();
                My_Dialogo my_dialogo = new My_Dialogo();
                my_dialogo.show(fragmentManager,"My_Dialogo");
                break;
        }
    }
}
