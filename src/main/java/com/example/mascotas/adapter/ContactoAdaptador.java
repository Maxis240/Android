package com.example.mascotas.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.POJO.Contacto;
import com.example.mascotas.DetalleContacto;
import com.example.mascotas.R;
import com.example.mascotas.db.ConstructorContactos;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity ){
        this.contactos = contactos;
        this.activity = activity;
    }

    //Inflar el layout y lo pasará al viewholder para que él obtenga los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,
                parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.etNombreCV.setText(contacto.getNombre());
        contactoViewHolder.etTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes())+ "\b Likes");

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("foto", contacto.getFoto());
                activity.startActivity(intent);
                activity.finish();
            }
        });
        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a "+contacto.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);

                contactoViewHolder.tvLikes.setText(Integer.toString(constructorContactos.obtenerLikesContacto(contacto)));
            }
        });
    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private EditText etNombreCV;
        private EditText etTelefonoCV;
        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            etNombreCV = (EditText) itemView.findViewById(R.id.etNombreCV);
            etTelefonoCV = (EditText) itemView.findViewById(R.id.etTelefonoCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}
