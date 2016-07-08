package com.example.tecnoparque4.prototipo;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener{

    private EditText contras;
    Button Btn_FInca,Btn_Entrar;
    LinearLayout Frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        contras = (EditText)findViewById(R.id.txt_password);
        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        contras.setText(prefe.getString("pass",""));

        Btn_Entrar = (Button)findViewById(R.id.Btn_Entrar_login);
        Btn_Entrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (contras.getText().toString().equals("zeus")){
               Intent intent = new Intent(Activity_Login.this,Fincas.class);
               startActivity(intent);
        }else{
            Toast.makeText(Activity_Login.this,"Error Contraseña !!!",Toast.LENGTH_LONG).show();
        }


//        switch (v.getId()){
//           case R.id.Btn_Entrar:
//               Intent intent = new Intent(Activity_Login.this,Sacam_admin.class);
//               startActivity(intent);
//               break;
////            case R.id.Btn_Crear_Finca:
////                FragmentManager fragmentManager = getFragmentManager();
////                My_Dialogo my_dialogo = new My_Dialogo();
////                my_dialogo.show(fragmentManager,"My_Dialogo");
////                break;
//        }

    }
}
