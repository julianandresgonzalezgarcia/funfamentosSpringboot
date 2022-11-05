package com.practica.practica.Configuration;

public class ImplementacionDelNombre implements BeanNombrePropiedad{

    private String nombre;
    private  String apellido;

    public ImplementacionDelNombre(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }


    @Override
    public String funcion() {
        return nombre+" "+apellido;
    }
}
