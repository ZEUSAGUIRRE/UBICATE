package com.example.tecnoparque4.prototipo.Clases_Objetos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tecnoparque4.prototipo.R;
import java.util.ArrayList;

public class ArrayAdapterCl_Insumos extends ArrayAdapter<CL_Insumos> {

    Context cnt;
    ArrayList<CL_Insumos>datos;
    int resour;
    TextView text_1, text_2, text_3, text_4, text_5;

    @Override
    public View getView(int position, View conterView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View vista = conterView;
        if (null==conterView) {
            vista = inflater.inflate(R.layout.formato_lista, parent, false);
        }

        text_1 = (TextView)vista.findViewById(R.id.text_1);
        text_2 = (TextView)vista.findViewById(R.id.text_2);
        text_3 = (TextView)vista.findViewById(R.id.text_3);
        text_4 = (TextView)vista.findViewById(R.id.text_4);
        text_5 = (TextView)vista.findViewById(R.id.text_5);

        text_1.setText(datos.get(position).getTxt_Tipo_Insumo());
        text_2.setText(datos.get(position).getTxt_Nombre_Insumo());
        text_3.setText(String.valueOf(datos.get(position).getTxt_Can_Insumo()));
        text_4.setText(datos.get(position).getTxt_Presentacion());
        text_5.setText(String.valueOf(datos.get(position).getTxt_Precio_Insumo()));

        return vista;
    }

    public ArrayAdapterCl_Insumos(Context context,int resource, ArrayList<CL_Insumos> objects){
        super(context,resource,objects);
    this.cnt=context;
    this.datos=objects;
    this.resour=resource;
    }

}
