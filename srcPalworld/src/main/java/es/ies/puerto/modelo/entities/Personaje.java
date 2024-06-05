package es.ies.puerto.modelo.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.*;


public class Personaje implements Serializable {
    private String personajeId;
    private String usuario;

    private List<Arma> armas;

    private List<Pal> pals;

    private Set<Material> materiales;


    public Personaje() {
        this.armas=new ArrayList<>();
        this.pals=new ArrayList<>();
        this.materiales=new HashSet<>();
    }

    public Personaje(String personajeId) {
        this.personajeId = personajeId;
    }

    public Personaje(String personajeId, String usuario, List<Arma> armas, List<Pal> pals, Set<Material> materiales) {
        this.personajeId = personajeId;
        this.usuario=usuario;
        this.armas = armas;
        this.pals = pals;
        this.materiales = materiales;
    }

    public String getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(String personajeId) {
        this.personajeId = personajeId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    public List<Pal> getPals() {
        return pals;
    }


    public void setPals(List<Pal> pals) {
        this.pals = pals;
    }

    public Set<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(Set<Material> materiales) {
        this.materiales = materiales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(personajeId, personaje.personajeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personajeId);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "personajeId='" + personajeId + '\'' +
                ", usuario='" + usuario + '\'' +
                ", armas=" + armas +
                ", pals=" + pals +
                ", materiales=" + materiales +
                '}';
    }
}