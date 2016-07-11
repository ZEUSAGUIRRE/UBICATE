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

public class Insumos extends Fragment implements View.OnClickListener{


    Button Atras;
   public Insumos() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.insumos, container, false);

          Atras = (Button)vista.findViewById(R.id.Btn_Atras);
          Atras.setOnClickListener(this);

    return vista;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragment_Base();
        transaction.add(fragment_container,fragment).commit();
    }
}
