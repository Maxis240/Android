package com.example.mascotas.fragment;

import com.example.mascotas.POJO.Contacto;
import com.example.mascotas.adapter.ContactoAdaptador;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
