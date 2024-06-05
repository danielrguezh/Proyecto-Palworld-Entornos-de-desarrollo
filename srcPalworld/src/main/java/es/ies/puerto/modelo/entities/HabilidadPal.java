package es.ies.puerto.modelo.entities;

import java.io.Serializable;
import java.util.Objects;

public class HabilidadPal implements Serializable {
    private String nombre;
    private String descripcion;
    private String palId;

    public HabilidadPal() {
    }

    public HabilidadPal(String nombre) {
        this.nombre = nombre;
    }

    public HabilidadPal(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public HabilidadPal(String nombre, String descripcion, String palId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.palId = palId;
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

    public String getPalId() {
        return palId;
    }

    public void setPalId(String palId) {
        this.palId = palId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HabilidadPal that = (HabilidadPal) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "HabilidadPal{" +
                "nombre='" + nombre + '\'' +
                ", descripcion=" + descripcion +
                ", palId='" + palId + '\'' +
                '}';
    }
}
