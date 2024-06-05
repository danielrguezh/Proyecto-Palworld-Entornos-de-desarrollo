package es.ies.puerto.dto;

import es.ies.puerto.modelo.entities.Material;

import java.util.Objects;

public class MaterialDTO {
    private String nombre;
    private int cantidad;
    private String personajeId;

    public MaterialDTO() {
    }

    public MaterialDTO(String nombre) {
        this.nombre = nombre;
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
        MaterialDTO that = (MaterialDTO) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "MaterialDTO{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", personajeId='" + personajeId + '\'' +
                '}';
    }
}
