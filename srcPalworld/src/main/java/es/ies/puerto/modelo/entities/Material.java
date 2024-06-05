package es.ies.puerto.modelo.entities;

import java.io.Serializable;
import java.util.Objects;

public class Material implements Serializable {
        private String nombre;
        private int cantidad;
        private String personajeId;

    public Material() {
    }

    public Material(String nombre) {
        this.nombre = nombre;
    }

    public Material(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Material(String nombre, int cantidad, String personajeId) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.personajeId = personajeId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(String personajeId) {
        this.personajeId = personajeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material that = (Material) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Material{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", personajeId='" + personajeId + '\'' +
                '}';
    }
}
