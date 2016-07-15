package com.example.tecnoparque4.prototipo;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tecnoparque4.prototipo.Base_Datos.DataBaseManager;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener{

    EditText USUARIO,CONTRASENA;
    Button Btn_Entrar,Btn_Registrar;
    DataBaseManager PP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        CONTRASENA = (EditText)findViewById(R.id.txt_password);
        USUARIO = (EditText)findViewById(R.id.txt_usuario);

        SharedPreferences preferences = getSharedPreferences("datos",Context.MODE_PRIVATE);
        USUARIO.setText(preferences.getString("USUARIO",""));
        CONTRASENA.setText(preferences.getString("CONTRASENA",""));
        Btn_Entrar = (Button)findViewById(R.id.Btn_Entrar_login);
        Btn_Registrar = (Button)findViewById(R.id.Btn_Registrar);

        Btn_Entrar.setOnClickListener(this);
        Btn_Registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Btn_Entrar_login:
                        DataBaseManager manager = new DataBaseManager(this);
                        String USU= USUARIO.getText().toString();
                        String CON= CONTRASENA.getText().toString();
                        if (USU.equals("") || CON.equals("")){
                        Toast.makeText(this,"Digite Usuario y Contraseña",Toast.LENGTH_LONG).show();
                        }else{
                        Boolean ENTRAR = manager.LOGIN(USU,CON);
                        if (ENTRAR==true){
                        Guardar();
                        Intent intent = new Intent(this,Fincas.class);
                        startActivity(intent);
                        }else{
                        Toast.makeText(this,"Error de Ingreso !!!",Toast.LENGTH_LONG).show();
                        }
                        }
            break;
            case R.id.Btn_Registrar:
                FragmentManager fragmentManager = getFragmentManager();
                Registrarse dialogo = new Registrarse();
                dialogo.show(fragmentManager,"Dialogo");
                break;
        }
    }

    public void Guardar(){ // Sharepreferences
      SharedPreferences preferencias= getSharedPreferences("datos",Context.MODE_PRIVATE);
        Editor editor = preferencias.edit();
        editor.putString("USUARIO",USUARIO.getText().toString());
        editor.putString("CONTRASENA",CONTRASENA.getText().toString());
        editor.commit();
    }
}
