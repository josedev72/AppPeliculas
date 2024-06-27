package org.example.model;

public class Movies {
    private int id_movie;
    private String nombre;
    private String descripcion;
    private String genero;
    private int calificacion;
    private int anio;
    private int estrellas;
    private String director;

    public Movies() {
    }

    public Movies(int id_movie, String nombre, String descripcion, String genero, int calificacion, int anio, int estrellas, String director) {
        this.id_movie = id_movie;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
        this.calificacion = calificacion;
        this.anio = anio;
        this.estrellas = estrellas;
        this.director = director;
    }
}
