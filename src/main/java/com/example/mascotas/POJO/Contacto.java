package com.example.mascotas.POJO;

public class Contacto {
    protected int id;
    protected String nombre;
    protected String telefono;
    protected int foto;
    protected int likes;


    public Contacto(String nombre, String telefono, int foto, int likes){
        this.nombre=nombre;
        this.telefono=telefono;
        this.foto=foto;
        this.likes=likes;
    }

    public Contacto() { }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }

}
