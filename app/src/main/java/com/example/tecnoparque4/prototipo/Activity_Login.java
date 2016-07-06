package com.example.tecnoparque4.prototipo;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener{

    Button Btn_FInca,Btn_Entrar;
    LinearLayout Frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Btn_Entrar = (Button)findViewById(R.id.Btn_Entrar);
        Btn_FInca = (Button)findViewById(R.id.Btn_Crear_Finca);

        Btn_Entrar.setOnClickListener(this);
        Btn_FInca.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
           case R.id.Btn_Entrar:
               Intent intent = new Intent(Activity_Login.this,Sacam_admin.class);
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
