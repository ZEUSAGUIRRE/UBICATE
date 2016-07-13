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
import com.example.tecnoparque4.prototipo.Sacam_admin;

import static com.example.tecnoparque4.prototipo.R.id.fragment_container;

public class Contrasena extends Fragment  implements View.OnClickListener{
    Sacam_admin PP;
    Button atras;
    public Contrasena() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista =  inflater.inflate(R.layout.contrasena, container, false);

        atras = (Button)vista.findViewById(R.id.btn_atras_contras);
        atras.setOnClickListener(this);


        return  vista;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (v.getId()){
            case R.id.btn_cambiar_contrasena:

                break;
            case R.id.btn_atras_contras:
                fragment = new Fragment_Base();
                transaction.replace(fragment_container,fragment).commit();
                break;
        }
    }
}
