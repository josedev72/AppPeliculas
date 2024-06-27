package org.example.model;

public class Directores {
    private int id_director;
    private String nombre;
    private String apellido;
    private int edad;
    private String nacionalidad;

    public Directores() {
    }

    public Directores(int id_director, String nombre, String apellido, int edad, String nacionalidad) {
        this.id_director = id_director;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }
}
