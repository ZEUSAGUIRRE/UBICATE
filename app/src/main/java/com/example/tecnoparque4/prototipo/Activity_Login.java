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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tecnoparque4.prototipo.Base_Datos.DataBaseManager;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener{

    EditText USUARIO,CONTRASENA;
    Button Btn_Entrar,Btn_Registrar;
    DataBaseManager PP;
    private CheckBox estado;
    Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        USUARIO = (EditText) findViewById(R.id.txt_usuario);
        CONTRASENA = (EditText) findViewById(R.id.txt_password);
        estado = (CheckBox)findViewById(R.id.checkbox_Guardar);
        Btn_Entrar = (Button) findViewById(R.id.Btn_Entrar_login);
        Btn_Registrar = (Button) findViewById(R.id.Btn_Registrar);
        Btn_Entrar.setOnClickListener(this);
        Btn_Registrar.setOnClickListener(this);
        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estado.isChecked()) {
                    SharedPreferences mis_preferences= getSharedPreferences("PreferenciasUsuario",Context.MODE_PRIVATE);
                    editor = mis_preferences.edit();
                    editor.putString("USUARIO",USUARIO.getText().toString());
                    editor.putString("CONTRASENA",CONTRASENA.getText().toString());
                    editor.commit();
                }else if (!estado.isChecked()){
                    SharedPreferences mis_preferences= getSharedPreferences("PreferenciasUsuario",Context.MODE_PRIVATE);
                    editor = mis_preferences.edit();
                    editor.clear();
                }
            }
        });
        Cargar_preferencias();
    }

    @Override
    public void onClick(View v) {
       // Guardar();
        switch (v.getId()){
            case R.id.Btn_Entrar_login:
                        estado.callOnClick();
                        DataBaseManager manager = new DataBaseManager(this);
                        String USU= USUARIO.getText().toString();
                        String CON= CONTRASENA.getText().toString();
                        if (USU.equals("") || CON.equals("")){
                        Toast.makeText(this,"Digite Usuario y Contraseña",Toast.LENGTH_LONG).show();
                        }else{
                        Boolean ENTRAR = manager.LOGIN(USU,CON);
                        if (ENTRAR==true){
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
    public void Cargar_preferencias(){  // Sharepreferences
        SharedPreferences mis_preferences=getSharedPreferences("PreferenciasUsuario",Context.MODE_PRIVATE);
//        estado.setChecked(mis_preferences.getBoolean("checked",false));
        String U=mis_preferences.getString("USUARIO","");
        String C=mis_preferences.getString("CONTRASENA","");
        if (U!="" || C!="" ){
            USUARIO.setText(mis_preferences.getString("USUARIO",""));
            CONTRASENA.setText(mis_preferences.getString("CONTRASENA",""));
        }
    }
}
