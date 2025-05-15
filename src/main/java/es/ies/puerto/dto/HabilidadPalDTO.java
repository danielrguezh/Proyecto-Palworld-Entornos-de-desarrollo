package es.ies.puerto.dto;

import es.ies.puerto.modelo.entities.HabilidadPal;

import java.util.Objects;

public class HabilidadPalDTO {
    private String nombre;
    private String descripcion;
    private String palId;

    public HabilidadPalDTO() {
    }

    public HabilidadPalDTO(String nombre) {
        this.nombre = nombre;
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
        HabilidadPalDTO that = (HabilidadPalDTO) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "HabilidadPalDTO{" +
                "nombre='" + nombre + '\'' +
                ", descripcion=" + descripcion +
                ", palId='" + palId + '\'' +
                '}';
    }
}
