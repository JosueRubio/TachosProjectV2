package com.example.tachosprojectv2.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tachosprojectv2.R;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroAct extends AppCompatActivity {

    Button btnSigRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnSigRegistro = (Button) findViewById(R.id.btn_sig_registro);

        btnSigRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sigRegistroAct();
            }
        });
    }

    private void sigRegistroAct(){
        Intent registro2 = new Intent(RegistroAct.this, RegistroAct2.class);
        startActivity(registro2);
    }
}
