package com.example.turismo;

import java.io.Serializable;

public class Actividad_Turistica implements Serializable {

    String nombre;
    String descripcion;
    String actividad;

    public Actividad_Turistica(String nombre, String descripcion, String actividad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividad = actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
}
