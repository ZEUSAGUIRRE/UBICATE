package com.example.tecnoparque4.prototipo.Fragmentos;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tecnoparque4.prototipo.R;

public class Frag_Otros_Gastos extends Fragment {

    public Frag_Otros_Gastos() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View vista =  inflater.inflate(R.layout.frag__otros__gastos, container, false);
    return  vista;
    }
}
