package es.ies.puerto.modelo.entities;


import java.io.Serializable;
import java.util.Objects;


public class Arma implements Serializable {
    private String nombre;
    private int danio;
    private int cargador;
    private String personajeId;

    public Arma() {
    }

    public Arma(String nombre) {
        this.nombre = nombre;
    }

    public Arma(String nombre, int danio, int cargador) {
        this.nombre = nombre;
        this.danio = danio;
        this.cargador = cargador;
    }

    public Arma(String nombre, int danio, int cargador, String personajeId) {
        this.nombre = nombre;
        this.danio = danio;
        this.cargador = cargador;
        this.personajeId = personajeId;
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
        Arma arma = (Arma) o;
        return Objects.equals(nombre, arma.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nombre='" + nombre + '\'' +
                ", danio=" + danio +
                ", cargador=" + cargador +
                ", personajeId='" + personajeId + '\'' +
                '}';
    }
}
