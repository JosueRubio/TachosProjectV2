package com.example.tachosprojectv2.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tachosprojectv2.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoginAct extends AppCompatActivity {

    Button btnLogin;
    TextView tvLogEmail, tvLogPassword;

    //HOLA MUNDO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvLogEmail = (TextView) findViewById(R.id.edt_usuario);
        tvLogPassword = (TextView) findViewById(R.id.edt_contraseña);
        btnLogin = (Button) findViewById(R.id.btn_inSesion);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ingresar();
            }

        });


    }

    private void Ingresar() {
        Intent LogIn = new Intent(LoginAct.this, MenuAct.class);
        startActivity(LogIn);
    }
}
