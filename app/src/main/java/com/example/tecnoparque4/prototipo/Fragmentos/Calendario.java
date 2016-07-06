package com.example.tecnoparque4.prototipo.Fragmentos;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tecnoparque4.prototipo.R;

public class Calendario extends Fragment {

    public Calendario() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.calendario, container, false);
    }
}
