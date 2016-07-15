package com.example.tecnoparque4.prototipo.Fragmentos;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tecnoparque4.prototipo.R;
import static com.example.tecnoparque4.prototipo.R.id.fragment_container;

public class Fragment_Base extends Fragment implements View.OnClickListener {

    LinearLayout Lotes,Insumos,Inventario;
    TextView Nombre_Finca;
    public Fragment_Base() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment__base, container, false);

        Lotes = ( LinearLayout)vista.findViewById(R.id.Layout_lotes);
        Insumos = ( LinearLayout)vista.findViewById(R.id.Layout_insumos);
        Inventario = ( LinearLayout)vista.findViewById(R.id.Layout_Inventario);
        Nombre_Finca =(TextView)vista.findViewById(R.id.txt_nombre_finca);

        Lotes.setOnClickListener(this);
        Insumos.setOnClickListener(this);
        Inventario.setOnClickListener(this);

        return vista;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment=null;

        switch (v.getId()){
            case R.id.Layout_lotes:
                fragment = new Lotes();
                transaction.replace(fragment_container,fragment).commit();
                break;
            case R.id.Layout_insumos:
                fragment = new Insumos();
                transaction.replace(fragment_container,fragment).commit();
                break;
            case R.id.Layout_Inventario:
                fragment = new Inventario();
                transaction.replace(fragment_container,fragment).commit();
                break;
        }
    }

}
