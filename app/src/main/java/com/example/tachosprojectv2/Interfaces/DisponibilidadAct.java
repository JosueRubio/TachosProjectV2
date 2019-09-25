package com.example.tachosprojectv2.Interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.tachosprojectv2.Interfaces.Fragments.estado_disp;
import com.example.tachosprojectv2.Interfaces.Fragments.estado_ocup;
import com.example.tachosprojectv2.R;

public class DisponibilidadAct extends AppCompatActivity implements estado_disp.OnFragmentInteractionListener,
        estado_ocup.OnFragmentInteractionListener{

    estado_disp fragDisponibilidad;
    estado_ocup fragOcupados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponibilidad);

        fragDisponibilidad = new estado_disp();
        fragOcupados = new estado_ocup();

        getSupportFragmentManager().beginTransaction().add(R.id.ll_disponibilidad,fragDisponibilidad).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
