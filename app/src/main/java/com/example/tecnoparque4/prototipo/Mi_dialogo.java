package com.example.tecnoparque4.prototipo;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Mi_dialogo extends DialogFragment implements View.OnClickListener {
    Button Aceptar,Cancelar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.mi_dialogo,null);



        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
