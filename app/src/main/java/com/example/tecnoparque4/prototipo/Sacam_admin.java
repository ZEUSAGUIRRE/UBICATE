package com.example.tecnoparque4.prototipo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tecnoparque4.prototipo.Fragmentos.Acerca_de;
import com.example.tecnoparque4.prototipo.Fragmentos.Actividades;
import com.example.tecnoparque4.prototipo.Fragmentos.Borrar;
import com.example.tecnoparque4.prototipo.Fragmentos.Calendario;
import com.example.tecnoparque4.prototipo.Fragmentos.Contrasena;
import com.example.tecnoparque4.prototipo.Fragmentos.Fragment_Base;
import com.example.tecnoparque4.prototipo.Fragmentos.Ganancias;
import com.example.tecnoparque4.prototipo.Fragmentos.Gastos;
import com.example.tecnoparque4.prototipo.Fragmentos.Inconvenientes;
import com.example.tecnoparque4.prototipo.Fragmentos.Recordatorios;

import java.util.concurrent.ExecutionException;


public class Sacam_admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Activity_Login EE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sacam_admin);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment_Base fragmentBase = new Fragment_Base();
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragmentBase).commit();

    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragment_Base();
        transaction.replace(R.id.fragment_container,fragment).commit();
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sacam_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
// -------------------------Opciones de SACAM-----------------------------------------
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment=null;

        int id = item.getItemId();

        if (id == R.id.Home ) {
            fragment = new Fragment_Base();

        } else  if (id == R.id.Actividades) {
                    fragment = new Actividades();

        } else if (id == R.id.Recordatorios) {
                    fragment = new Recordatorios();

        } else if (id == R.id.Inconvenientes) {
                    fragment = new Inconvenientes();

        } else if (id == R.id.Reporte_Gastos) {
                    fragment = new Gastos();

        } else if (id == R.id.Ganancias) {
                    fragment = new Ganancias();

        } else if (id == R.id.Cambiar_Contraseña) {
                    fragment = new Contrasena();

        }else if (id == R.id.Otra_Finca) {
                    Intent intent = new Intent(Sacam_admin.this,Fincas.class);
                    startActivity(intent);
                    Toast.makeText(this,"Cambiar Finca !!!",Toast.LENGTH_LONG).show();
        }else if (id == R.id.Borrar_todo) {
                    fragment = new Borrar();
        }else if (id == R.id.Cerrar_Sesion) {
            Intent intent = new Intent(Sacam_admin.this,Activity_Login.class);
            startActivity(intent);
        }else if (id == R.id.Acerca_de) {
                    fragment = new Acerca_de();
        }
        try {
            transaction.replace(R.id.fragment_container,fragment).commit();
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);

        }catch (Exception e){
         //   Toast.makeText(this,""+e,Toast.LENGTH_LONG).show();
        }
        return true;
    }

}
