package com.example.tecnoparque4.prototipo.Fragmentos;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tecnoparque4.prototipo.Base_Datos.DataBaseManager;
import com.example.tecnoparque4.prototipo.Clases_Objetos.CL_Insumos;
import com.example.tecnoparque4.prototipo.R;
import com.example.tecnoparque4.prototipo.Sacam_admin;

import static com.example.tecnoparque4.prototipo.R.id.fragment_container;
import static com.example.tecnoparque4.prototipo.R.id.layout_dialogo;

public class Insumos extends Fragment implements View.OnClickListener {
    CL_Insumos PP;
    EditText txt_Tipo_Insumo, txt_Nombre_Insumo, txt_Can_Insumo, txt_Presentacion, txt_Precio_Insumo;
    Button Btn_Guardar_Insumo;
    View vista;
    //Button Atras;
    public Insumos() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.insumos, container, false);
        // Cajas de Texto
        txt_Tipo_Insumo = (EditText) vista.findViewById(R.id.txt_Tipo_Insumo);
        txt_Nombre_Insumo = (EditText) vista.findViewById(R.id.txt_Nombre_Insumo);
        txt_Can_Insumo = (EditText) vista.findViewById(R.id.txt_Can_Insumo);
        txt_Presentacion = (EditText) vista.findViewById(R.id.txt_Presentacion);
        txt_Precio_Insumo = (EditText) vista.findViewById(R.id.txt_Precio_Insumo);
        // Botones
        Btn_Guardar_Insumo = (Button) vista.findViewById(R.id.Btn_Guardar_Insumo);
      //  Atras = (Button) vista.findViewById(R.id.Btn_Atras);
        // Acciones de los Botones
//        Atras.setOnClickListener(this);
        Btn_Guardar_Insumo.setOnClickListener(this);
        return vista;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Btn_Guardar_Insumo:
                Guardar_Insumo();
                break;
//            case R.id.Btn_Atras:
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                Fragment fragment = new Fragment_Base();
//                transaction.replace(fragment_container, fragment).commit();
//                break;
        }
    }

//    @TargetApi(Build.VERSION_CODES.M)
    private void Guardar_Insumo() {
        DataBaseManager manager = new DataBaseManager(getActivity());
        String Col_1 = txt_Tipo_Insumo.getText().toString();
        String Col_2 = txt_Nombre_Insumo.getText().toString();
        int Entero_1 = (Integer.parseInt(String.valueOf(txt_Can_Insumo.getText())));
        String Col_3 = txt_Presentacion.getText().toString();
        int Entero_2 = (Integer.parseInt(String.valueOf(txt_Precio_Insumo.getText())));
        Boolean Guard = manager.INSERTAR("INSUMOS", Col_1, Col_2, Col_3, Entero_1, Entero_2);
        if (Guard == true) {
            Toast.makeText(getActivity(), "Datos Guardados Satisfactoriamente !!!",Toast.LENGTH_LONG).show();
            txt_Tipo_Insumo.setText(null);
            txt_Nombre_Insumo.setText(null);
            txt_Can_Insumo.setText(null);
            txt_Presentacion.setText(null);
            txt_Precio_Insumo.setText(null);
        }
    }
}