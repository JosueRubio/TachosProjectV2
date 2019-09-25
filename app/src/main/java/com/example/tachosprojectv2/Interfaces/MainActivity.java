package com.example.tachosprojectv2.Interfaces;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tachosprojectv2.Clases.AdapterDisponibilidad;
import com.example.tachosprojectv2.Model.ModeloControl;
import com.example.tachosprojectv2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterDisponibilidad.OnItemClickListener {


    private ValueEventListener mDBListener;

    private ArrayList<ModeloControl> mUploads;
    DatabaseReference myRef;
    RecyclerView recyclerViewExterior;
    private AdapterDisponibilidad mAdapter;
    //ELEMENTOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewExterior = findViewById(R.id.rec_disponibilidad);


        //Instanciar firebaseReference
        myRef = FirebaseDatabase.getInstance().getReference("espacios");
        mUploads = new ArrayList<>();

        //ADAPTER & RECYCLER AQUI SE ACOMODAN LAS COLUMNAS
        mAdapter = new AdapterDisponibilidad(this, mUploads);
        recyclerViewExterior.setHasFixedSize(true);
        recyclerViewExterior.setLayoutManager(new LinearLayoutManager(this));

        mAdapter.setOnItemClickListener(this);
        getDisponibles();

    }
//
    public void getDisponibles(){
        myRef
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mUploads.clear();
                        for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                            //CON MANEJO DE HILOS
                            ModeloControl upload = postSnapshot.getValue(ModeloControl.class);
                            mUploads.add(upload);
                            mAdapter.notifyDataSetChanged();

                        }//FIN DEL FOR
                        recyclerViewExterior.setAdapter(mAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

    }

    public void msj(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(int position) {

    }
}
