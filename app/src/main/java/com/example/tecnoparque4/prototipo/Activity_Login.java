package com.example.tecnoparque4.prototipo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener{

    Button Dialogo;
    LinearLayout Frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Frag = (LinearLayout)findViewById(R.id.Layou_Finca);
        Frag.setVisibility(View.INVISIBLE);
        Button Nuevo = (Button)findViewById(R.id.Btn_Crear_Finca);
        Nuevo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Frag.setVisibility(View.VISIBLE);
//        AlertDialog alertDialog;
//        alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle("Nuevo");
//        alertDialog.setMessage("Mensaje de Dialogo");
//        alertDialog.show();
    }
}
