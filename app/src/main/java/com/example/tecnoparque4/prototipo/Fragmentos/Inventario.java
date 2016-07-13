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
import com.example.tecnoparque4.prototipo.R;
import static com.example.tecnoparque4.prototipo.R.id.fragment_container;
public class Inventario extends Fragment implements View.OnClickListener{

    Button Atras;
    ListView Lista;
    public Inventario() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View vista = inflater.inflate(R.layout.inventario, container, false);
//            Atras = (Button)vista.findViewById(R.id.Btn_Atras);
//            Atras.setOnClickListener(this);
            Lista = (ListView)vista.findViewById(R.id.listView_lista);
            Llenar_lista();
    return  vista;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragment_Base();
        transaction.replace(fragment_container,fragment).commit();
    }


    private void Llenar_lista(){
        DataBaseManager manager= new DataBaseManager(getActivity());
        Cursor cursor = manager.MOSTRAR();
        String[] from = new String[] {
                manager.Tipo_Insumo,
                manager.Nombre_Insumo,
                manager.Can_Insumo,
                manager.Presen_Insumo,
                manager.Precio_Insumo };
        int[] to = new int[] {
                R.id.text_1,
                R.id.text_2,
                R.id.text_3,
                R.id.text_4,
                R.id.text_5 };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(),R.layout.formato_lista,cursor,from,to);
        Lista.setAdapter(adapter);
   }
}
