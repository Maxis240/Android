package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class ActivityAbout extends AppCompatActivity {

    private EditText etNombre;
    private EditText etEmail;
    private EditText etMensaje;

    Button btnEditar;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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

        etNombre = (EditText) findViewById(R.id.etNombre);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etMensaje = (EditText) findViewById(R.id.etMensaje);
        btnEditar = findViewById(R.id.btnEditar);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                btnEnviar.setEnabled(true);
                etNombre.setFocusableInTouchMode(true);
                etNombre.setFocusable(true);
                etEmail.setFocusableInTouchMode(true);
                etEmail.setFocusable(true);
                etMensaje.setFocusableInTouchMode(true);
                etMensaje.setFocusable(true);
                etNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(etNombre.hasFocus()){
                            etNombre.setCursorVisible(true);
                            etNombre.setText(etNombre.getText());
                            etNombre.setSelection(etNombre.getText().length());
                        }
                        if(etEmail.hasFocus()){
                            etEmail.setCursorVisible(true);
                            etEmail.setText(etEmail.getText());
                            etEmail.setSelection(etEmail.getText().length());
                        }
                        if(etMensaje.hasFocus()){
                            etMensaje.setCursorVisible(true);
                            etMensaje.setText(etMensaje.getText());
                            etMensaje.setSelection(etMensaje.getText().length());
                        }
                    }
                });
            }
        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    /* generar archivo */
    public void generarArchivo(View view) {
        try{
            EditText edtNombre = (EditText) findViewById(R.id.etNombre);
            EditText edtEmail = (EditText) findViewById(R.id.etEmail);
            EditText edtMensaje = (EditText) findViewById(R.id.etMensaje);

            String nombre = edtNombre.getText().toString();
            String correo = edtEmail.getText().toString();
            String mensaje = edtMensaje.getText().toString();

            FileOutputStream outputStream = openFileOutput("MiArchivo.txt", Context.MODE_APPEND);
            outputStream.write(nombre.getBytes());
            outputStream.write(correo.getBytes());
            outputStream.write(mensaje.getBytes());
            outputStream.close();

            Toast.makeText(getApplicationContext(), "El archivo se ha creado", Toast.LENGTH_SHORT).show();
            edtNombre.setText("");
            edtEmail.setText("");
            edtMensaje.setText("");

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Hubo un error en la escritura del archivo", Toast.LENGTH_SHORT).show();
        }
    }
    /* guardar y mostrar preferencia */
    public void guardarPref(View view){
        SharedPreferences miPreferenciaCompartida = getSharedPreferences("MisDatosPersonales", Context.MODE_PRIVATE);

        /* declaro objeto editor */
        SharedPreferences.Editor editor = miPreferenciaCompartida.edit();

        EditText edtNombre = (EditText) findViewById(R.id.etNombre);
        EditText edtEmail = (EditText) findViewById(R.id.etEmail);
        EditText edtMensaje = (EditText) findViewById(R.id.etMensaje);

        String nombre = edtNombre.getText().toString();
        String correo = edtEmail.getText().toString();
        String mensaje = edtMensaje.getText().toString();

        editor.putString("nombre", nombre);
        editor.putString("correo", correo);
        editor.putString("mensaje", mensaje);

        editor.apply();

        Toast.makeText(getApplicationContext(), "Preferencia Guardada con éxito", Toast.LENGTH_SHORT).show();

        edtNombre.setText("");
        edtEmail.setText("");
        edtMensaje.setText("");
    }
    public void mostrarPref(View view){
        SharedPreferences miPreferenciaCompartida = getSharedPreferences("MisDatosPersonales", Context.MODE_PRIVATE);

        String nombre = miPreferenciaCompartida.getString("nombre", "No existe esa variable");
        String correo = miPreferenciaCompartida.getString("correo", "No existe esa variable");
        String mensaje = miPreferenciaCompartida.getString("mensaje", "No existe esa variable");

        TextView tvPreferenciaCompartida = (TextView) findViewById(R.id.tvPreferenciaCompartida);
        String preferencia = "\nNombre: " + nombre + "\nCorreo: " + correo + "\nMensaje: " + mensaje;
        tvPreferenciaCompartida.setText(preferencia);
    }
}