package com.umg;

/**
 * Created by alumno on 6/07/2017.
 */
public class Estudiante {
    private String Nombre;
    private int Edad;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public Estudiante(String nombre, int edad) {

        Nombre = nombre;
        Edad = edad;
    }
}
