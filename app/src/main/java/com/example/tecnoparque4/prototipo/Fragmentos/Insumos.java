package com.example.tecnoparque4.prototipo.Fragmentos;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tecnoparque4.prototipo.Clases_Objetos.CL_Insumos;
import com.example.tecnoparque4.prototipo.R;

import static com.example.tecnoparque4.prototipo.R.id.fragment_container;

public class Insumos extends Fragment implements View.OnClickListener{

    CL_Insumos PP;
    EditText txt_Tipo_Insumo,txt_Nombre_Insumo,txt_Can_Insumo,txt_Presentacion,txt_Precio_Insumo;
    Button Btn_Guardar_Insumo;

    Button Atras;
   public Insumos() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.insumos, container, false);

        // Cajas de Texto
        txt_Tipo_Insumo = (EditText)vista.findViewById(R.id.txt_Tipo_Insumo);
        txt_Nombre_Insumo = (EditText)vista.findViewById(R.id.txt_Nombre_Insumo);
        txt_Can_Insumo = (EditText)vista.findViewById(R.id.txt_Can_Insumo);
        txt_Presentacion = (EditText)vista.findViewById(R.id.txt_Presentacion);
        txt_Precio_Insumo = (EditText)vista.findViewById(R.id.txt_Precio_Insumo);

        // Botones
        Btn_Guardar_Insumo = (Button)vista.findViewById(R.id.Btn_Guardar_Insumo);
        Atras = (Button)vista.findViewById(R.id.Btn_Atras);

        // Acciones de los Botones
        Atras.setOnClickListener(this);
        Btn_Guardar_Insumo.setOnClickListener(this);

    return vista;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Btn_Guardar_Insumo:
                Guardar_Insumo();
                break;
            case R.id.Btn_Atras:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment fragment = new Fragment_Base();
                transaction.replace(fragment_container,fragment).commit();
                break;
        }
        }

    private void Guardar_Insumo(){
        txt_Tipo_Insumo.setText(String.valueOf(PP.getTxt_Tipo_Insumo()));
        txt_Nombre_Insumo.setText(String.valueOf(PP.getTxt_Nombre_Insumo()));
        txt_Can_Insumo.setText(PP.getTxt_Can_Insumo());
        txt_Presentacion.setText(String.valueOf(PP.getTxt_Presentacion()));
        txt_Precio_Insumo.setText(PP.getTxt_Precio_Insumo());
    }
}
