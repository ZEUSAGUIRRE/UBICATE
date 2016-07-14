package com.example.tecnoparque4.prototipo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tecnoparque4.prototipo.Base_Datos.DataBaseManager;


public class My_Dialogo extends DialogFragment {

    Button Btn_guardar_finca;
    EditText txt_finca;
    DataBaseManager manager = new DataBaseManager(getActivity());
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.my_dialogo,null);

        txt_finca = (EditText)vista.findViewById(R.id.txt_finca);
        Btn_guardar_finca = (Button)vista.findViewById(R.id.Btn_guardar_finca);
        Btn_guardar_finca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String dato = txt_finca.getText().toString();
               manager.INSERTAR("FINCA",dato,null,null,0,0);
                Toast.makeText(getActivity(),R.string.Datos_Guardados,Toast.LENGTH_SHORT).show();//"Datos Guardados Satisfactoriamente !!!"

//                if ( Guardado==true){
//                    try {
//                        My_Dialogo.this.finalize();
//                    } catch (Throwable throwable) {
//                        throwable.printStackTrace();
//                    }
//                    Toast.makeText(getActivity(),R.string.Datos_Guardados,Toast.LENGTH_SHORT).show();//"Datos Guardados Satisfactoriamente !!!"
//                }
            }
        });
        return vista;
    }
}
