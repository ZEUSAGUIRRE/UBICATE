package com.example.tecnoparque4.prototipo;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tecnoparque4.prototipo.Base_Datos.DataBaseManager;

public class Registrarse extends DialogFragment {

    Button Guardar;
    EditText USU,CONTA;
    DataBaseManager PP;
    public Registrarse() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View vista = inflater.inflate(R.layout.registrarse, container, false);

        USU = (EditText)vista.findViewById(R.id.txt_nuevo_usu);
        CONTA = (EditText)vista.findViewById(R.id.txt_nuevo_contra);
        Guardar = (Button)vista.findViewById(R.id.Btn_Nuevo_usu);
        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseManager manager = new DataBaseManager(getActivity());
                   String U = USU.getText().toString();
                   String C = CONTA.getText().toString();
                    if (U!="" && C!=""){
                        Boolean Guardar = manager.INSERTAR("ADMIN",U, C,"",0,0);
                        if(Guardar==true){
                            Toast.makeText(getActivity(),"Usuario ha sido creado !!",Toast.LENGTH_SHORT).show();
                            dismiss();
                        }
                    }else{
                   Toast.makeText(getActivity(),"Ingrese Usuario y Contraseña !!",Toast.LENGTH_LONG).show();
                    }
            }
        });

    return vista;
    }

}
