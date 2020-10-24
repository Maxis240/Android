package com.example.mascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.POJO.Contacto;
import com.example.mascotas.R;
import com.example.mascotas.adapter.ContactoAdaptador;
import com.example.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.example.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragmentrecyclerview, container, false);
        // capturo la view de nuestro RecyclerView
        rvContactos = v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }
    /*
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.catty2, "Catty", "000111", likes));
        contactos.add(new Contacto(R.drawable.ronny2, "Ronny", "111000", likes));
        contactos.add(new Contacto(R.drawable.carla, "Carla", "222000", likes));
        contactos.add(new Contacto(R.drawable.reinaldo, "Reinald", "000222", likes));
        contactos.add(new Contacto(R.drawable.carlotta, "Carlotta", "333000", likes));
        contactos.add(new Contacto(R.drawable.ricardo, "Ricardo", "000333", likes));
    }*/
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);
        // puedo cambiar glm por llm si quisiera un GridLaylout
        // GridLayoutManager glm = new GridLayoutManager(this, 2);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }

}

