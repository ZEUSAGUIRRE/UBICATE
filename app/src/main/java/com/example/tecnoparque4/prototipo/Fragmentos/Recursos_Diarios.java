package com.example.tecnoparque4.prototipo.Fragmentos;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tecnoparque4.prototipo.R;
public class Recursos_Diarios extends Fragment implements View.OnClickListener {

    ImageButton Btn_1, Btn_2,Btn_3,Btn_4;
    Button Btn_atras;
    public Recursos_Diarios() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.recursos_diarios, container, false);

        Seleccione_Opcion fragmentBase = new Seleccione_Opcion();
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.Contenedor_gastos_diarios,fragmentBase).commit();

        Btn_1 = (ImageButton)vista.findViewById(R.id.Btn_1);
        Btn_2 = (ImageButton)vista.findViewById(R.id.Btn_2);
        Btn_3 = (ImageButton)vista.findViewById(R.id.Btn_3);
        Btn_4 = (ImageButton)vista.findViewById(R.id.Btn_4);
        Btn_atras = (Button)vista.findViewById(R.id.btn_Atras_Diarios);

        Btn_1.setOnClickListener(this);
        Btn_2.setOnClickListener(this);
        Btn_3.setOnClickListener(this);
        Btn_4.setOnClickListener(this);
        Btn_atras.setOnClickListener(this);

return vista;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.Btn_1:
                fragment = new Frag_Insumos();
                transaction.replace(R.id.Contenedor_gastos_diarios,fragment).commit();
                break;
            case R.id.Btn_2:
                fragment = new Frag_Mano_Obra();
                transaction.replace(R.id.Contenedor_gastos_diarios,fragment).commit();
                break;
            case R.id.Btn_3:
                fragment = new Frag_Maquinaria();
                transaction.replace(R.id.Contenedor_gastos_diarios,fragment).commit();
                break;
            case R.id.Btn_4:
                fragment = new Frag_Otros_Gastos();
                transaction.replace(R.id.Contenedor_gastos_diarios,fragment).commit();
                break;
            case R.id.btn_Atras_Diarios:
                fragment = new Actividades();
                transaction.replace(R.id.fragment_container,fragment).commit();
                break;
        }
    }
}