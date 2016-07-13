package com.example.tecnoparque4.prototipo.Fragmentos;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tecnoparque4.prototipo.R;

import static com.example.tecnoparque4.prototipo.R.id.fragment_container;

public class Actividades extends Fragment implements View.OnClickListener{

    Button Atras,aceptar;
    public Actividades() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.actividades, container, false);

        Atras = (Button)vista.findViewById(R.id.Btn_Atras_Actividad);
        aceptar = (Button)vista.findViewById(R.id.Btn_Aceptar);
        Atras.setOnClickListener(this);
        aceptar.setOnClickListener(this);

        return vista;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (v.getId()){
            case R.id.Btn_Atras_Actividad:
                    fragment = new Fragment_Base();
                    transaction.replace(fragment_container,fragment).commit();
                    break;
            case R.id.Btn_Aceptar:
                    fragment = new Recursos_Diarios();
                    transaction.replace(fragment_container,fragment).commit();
                    break;
             }




    }
}
