package es.ies.puerto.dto;


import java.util.Objects;

public class ArmaDTO {

    private String nombre;

    private int danio;

    private int cargador;

    private String personajeId;

    public ArmaDTO() {
    }

    public ArmaDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getCargador() {
        return cargador;
    }

    public void setCargador(int cargador) {
        this.cargador = cargador;
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
        ArmaDTO armaDTO = (ArmaDTO) o;
        return Objects.equals(nombre, armaDTO.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "ArmaDTO{" +
                "nombre='" + nombre + '\'' +
                ", danio=" + danio +
                ", cargador=" + cargador +
                ", personajeId='" + personajeId + '\'' +
                '}';
    }
}
