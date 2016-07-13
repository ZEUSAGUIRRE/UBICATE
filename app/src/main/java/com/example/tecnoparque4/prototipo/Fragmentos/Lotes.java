package com.example.tecnoparque4.prototipo.Fragmentos;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.tecnoparque4.prototipo.R;
import com.example.tecnoparque4.prototipo.Sacam_admin;

import static com.example.tecnoparque4.prototipo.R.id.fragment_container;

public class Lotes extends Fragment implements View.OnClickListener {

    Button Atras ;
    Sacam_admin PP;
    public Lotes() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View Vista = inflater.inflate(R.layout.lotes, container, false);

        Atras = (Button)Vista.findViewById(R.id.Btn_Atras);
        Atras.setOnClickListener(this);


    return  Vista;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragment_Base();
        transaction.replace(fragment_container,fragment).commit();
    }
}
