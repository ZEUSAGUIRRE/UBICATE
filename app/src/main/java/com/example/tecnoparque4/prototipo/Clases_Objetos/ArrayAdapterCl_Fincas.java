package com.example.tecnoparque4.prototipo.Clases_Objetos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.tecnoparque4.prototipo.R;

import java.util.ArrayList;

public class ArrayAdapterCl_Fincas extends ArrayAdapter<CL_Fincas> {

    Context cnt;
    ArrayList<CL_Fincas> datos;
    int resour;
    TextView text_1; //, text_2, text_3;
    @Override
    public View getView(int position, View conterView, ViewGroup parent){
      LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

      View vista = conterView;
        if (null==conterView) {
            vista = inflater.inflate(R.layout.lista_fincas, parent, false);
        }

        text_1 = (TextView)vista.findViewById(R.id.text_1_finca);
        //text_2 = (TextView)vista.findViewById(R.id.text_2_finca);
        //text_3 = (TextView)vista.findViewById(R.id.text_3_finca);

        text_1.setText(String.valueOf(datos.get(position).getDNI()));
        //text_2.setText(datos.get(position).getNOMBRE_FINCA());
        //text_3.setText(datos.get(position).getESTADO_FINCA());

        return  vista;
    }


    public ArrayAdapterCl_Fincas(Context context, int resource,ArrayList<CL_Fincas>objects) {
        super(context, resource,objects);
        this.cnt=context;
        this.datos=objects;
        this.resour=resource;

    }
}
