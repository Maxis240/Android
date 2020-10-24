package com.example.mascotas;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileOutputStream;

public class DetalleFormulario extends AppCompatActivity {

    private EditText etNombre;
    private EditText etEmail;
    private EditText etMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        /* Ejemplo de clase, la clase utilizada en formulario es ActivityAbout.java */
        Bundle parametros = getIntent().getExtras();
        final
        String nombreform = parametros.getString(getResources().getString(R.string.nombreform));
        String emailform = parametros.getString(getResources().getString(R.string.emailform));
        String mensajeform = parametros.getString(getResources().getString(R.string.mensajeform));

        etNombre = (EditText) findViewById(R.id.etNombre);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etMensaje = (EditText) findViewById(R.id.etMensaje);

        etNombre.setText(nombreform);
        etEmail.setText(emailform);
        etMensaje.setText(mensajeform);
    }
}
