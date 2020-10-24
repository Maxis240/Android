package com.example.mascotas.POJO;

public class Contacto2 {
    protected String nombreform;
    protected String emailform;
    protected String mensajeform;

    public Contacto2(String nombre, String email, String mensaje ){
        this.nombreform=nombre;
        this.emailform=email;
        this.mensajeform=mensaje;
    }

    public String getNombre() {
        return nombreform;
    }

    public void setNombre(String nombre) {
        this.nombreform = nombre;
    }

    public String getEmail() {
        return emailform;
    }

    public void setEmail(String email) {
        this.emailform = email;
    }

    public String getMensaje() {
        return mensajeform;
    }

    public void setMensaje(String mensaje) {
        this.mensajeform = mensaje;
    }

}
