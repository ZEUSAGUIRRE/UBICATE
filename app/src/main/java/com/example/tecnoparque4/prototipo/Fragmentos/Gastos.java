package com.example.tecnoparque4.prototipo.Fragmentos;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tecnoparque4.prototipo.R;

public class Gastos extends Fragment {

    public Gastos() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View Vista = inflater.inflate(R.layout.gastos, container, false);
    return  Vista;
    }

}
