package com.example.tecnoparque4.prototipo.Fragmentos;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tecnoparque4.prototipo.R;

public class Frag_Maquinaria extends Fragment {

    public Frag_Maquinaria() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista =  inflater.inflate(R.layout.frag__maquinaria, container, false);
    return vista;
    }

}
