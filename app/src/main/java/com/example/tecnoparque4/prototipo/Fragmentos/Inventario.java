package com.example.tecnoparque4.prototipo.Fragmentos;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.tecnoparque4.prototipo.Base_Datos.DataBaseManager;
import com.example.tecnoparque4.prototipo.Clases_Objetos.ArrayAdapterCl_Insumos;
import com.example.tecnoparque4.prototipo.Clases_Objetos.CL_Insumos;
import com.example.tecnoparque4.prototipo.R;

import java.util.ArrayList;

import static com.example.tecnoparque4.prototipo.R.id.fragment_container;
public class Inventario extends Fragment implements View.OnClickListener{

    ArrayAdapterCl_Insumos adaptador;
    Button Atras;
    ListView Lista;
    DataBaseManager manager;
    ArrayList<CL_Insumos> List;
    View vista;
    public Inventario() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     vista = inflater.inflate(R.layout.inventario, container, false);
//            Atras = (Button)vista.findViewById(R.id.Btn_Atras);
//            Atras.setOnClickListener(this);
            Lista = (ListView)vista.findViewById(R.id.listView_lista);
        LLenar_Lista();
    return  vista;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragment_Base();
        transaction.replace(fragment_container,fragment).commit();
    }

    private void LLenar_Lista(){
        manager= new DataBaseManager(getActivity());
        List= new ArrayList<CL_Insumos>();
        Lista = (ListView)vista.findViewById(R.id.listView_lista);
        List= manager.GetListaInsumos();
        adaptador = new ArrayAdapterCl_Insumos(getActivity(),R.layout.formato_lista,List);
        Lista.setAdapter(adaptador);
    }
}
