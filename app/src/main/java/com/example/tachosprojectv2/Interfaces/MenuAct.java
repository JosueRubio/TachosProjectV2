package com.example.tachosprojectv2.Interfaces;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.tachosprojectv2.Interfaces.Fragments.estado_disp;
import com.example.tachosprojectv2.Interfaces.Fragments.estado_ocup;
import com.example.tachosprojectv2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


public class MenuAct extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, estado_disp.OnFragmentInteractionListener,
        estado_ocup.OnFragmentInteractionListener {

    estado_disp fragDisponibilidad;
    estado_ocup fragOcupados;

    Button btnNuevoReg,btnOcupados, btnDisponibilidad, btnReservaciones, btnEventuales, btnIngresos, btnNotas,btnEstadisticas;
    FloatingActionButton fabRegistro;
    public static NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
         navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        fragDisponibilidad = new estado_disp();
        fragOcupados = new estado_ocup();
//        getSupportFragmentManager().beginTransaction().add(R.id.ll_disponibilidad,fragDisponibilidad).commit();


        fabRegistro = (FloatingActionButton) findViewById(R.id.fab_nuevo_reg);
        btnNuevoReg = (Button) findViewById(R.id.btn_nuevo_reg);
        btnReservaciones = (Button) findViewById(R.id.btn_reservaciones);
        btnOcupados = (Button) findViewById(R.id.btn_ocupados);

        fabRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                registroAct();
                tabRegAct();
            }
        });

        btnNuevoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                registroAct();
                Ingresar();

            }
        });

        btnReservaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabRegAct();
            }
        });

    }



    private void Ingresar() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
//        finish();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        getSupportFragmentManager().beginTransaction().add(R.id.ll_disponibilidad,fragDisponibilidad).commit();
        FragmentManager fragmentManager = getSupportFragmentManager();


        if (id == R.id.nav_disponibilidad) {
            fragmentManager.beginTransaction().replace(R.id.drawer_layout, new estado_disp()).addToBackStack(null).commit();
        } else if (id == R.id.nav_contabilidad) {

        } else if (id == R.id.nav_estadisticas) {

        } else if (id == R.id.nav_perfiles) {

        } else if (id == R.id.nav_notas) {

        } else if (id == R.id.nav_cerrarses) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void registroAct(){
        Intent registro = new Intent(MenuAct.this, RegistroAct.class);
        startActivity(registro);
    }

    private void tabRegAct(){
        Intent tabs = new Intent(MenuAct.this, TabRegistro.class);
        startActivity(tabs);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

