package com.example.mascotas;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;


public class DetalleContacto extends AppCompatActivity {

    private ImageView imgFoto;
    private EditText etNombreCV;
    private EditText etTelefonoCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        Bundle parametros = getIntent().getExtras();
        int foto = parametros.getInt("foto");
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));

        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        etNombreCV = (EditText) findViewById(R.id.etNombreCV);
        etTelefonoCV = (EditText) findViewById(R.id.etTelefonoCV);

        imgFoto.setImageResource(foto);
        etNombreCV.setText(nombre);
        etTelefonoCV.setText(telefono);
    }

}

