package com.example.tachosprojectv2.Interfaces;

import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tachosprojectv2.Interfaces.Fragments.TabRegistro3;
import com.example.tachosprojectv2.Interfaces.Fragments.tab_registro1;
import com.example.tachosprojectv2.Interfaces.Fragments.tab_registro2;
import com.example.tachosprojectv2.Interfaces.Fragments.tab_registro4;
import com.example.tachosprojectv2.Interfaces.Fragments.tab_registro5;
import com.example.tachosprojectv2.Interfaces.Fragments.tab_registro6;
import com.example.tachosprojectv2.R;
import com.example.tachosprojectv2.ui.main.SectionsPagerAdapter;

public class TabRegistro extends AppCompatActivity implements tab_registro1.OnFragmentInteractionListener, tab_registro2.OnFragmentInteractionListener,
    TabRegistro3.OnFragmentInteractionListener, tab_registro4.OnFragmentInteractionListener, tab_registro5.OnFragmentInteractionListener,
    tab_registro6.OnFragmentInteractionListener{

    ViewPager viewPager;
    private LinearLayout linearPuntos;
    private TextView[] puntosSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_registro);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        linearPuntos = (LinearLayout) findViewById(R.id.ll_puntos);
        agregarIndicadorPuntos(0);
        viewPager.addOnPageChangeListener(viewListener);

    }

    private void agregarIndicadorPuntos(int pos) {
        puntosSlide = new TextView[4];
        linearPuntos.removeAllViews();

        for (int i = 0; i < puntosSlide.length; i++){
            puntosSlide[i] = new TextView(this);
            puntosSlide[i].setText(Html.fromHtml("&#8226;"));
            puntosSlide[i].setTextSize(45);
            puntosSlide[i].setTextColor(getResources().getColor(R.color.colorBlancoTransparente));
            linearPuntos.addView(puntosSlide[i]);
        }

        if(puntosSlide.length > 0){
            puntosSlide[pos].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int pos) {
            agregarIndicadorPuntos(pos);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}