package com.example.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.mascotas.POJO.Contacto;
import com.example.mascotas.R;

import java.util.ArrayList;

public class ConstructorContactos {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorContactos(Context context){
        this.context = context;
    }
    public ArrayList<Contacto> obtenerDatos(){

        /*ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.catty2, "Catty", "000111", 5));
        contactos.add(new Contacto(R.drawable.ronny2, "Ronny", "111000", 3));
        contactos.add(new Contacto(R.drawable.carla, "Carla", "222000", 8));
        contactos.add(new Contacto(R.drawable.reinaldo, "Reinald", "000222", 9));
        contactos.add(new Contacto(R.drawable.carlotta, "Carlotta", "333000", 10));
        contactos.add(new Contacto(R.drawable.ricardo, "Ricardo", "000333", 12));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }
    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Catty");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "000111");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.catty2);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Ronny");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "111000");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.ronny2);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Carla");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "222000");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.carla);

        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
