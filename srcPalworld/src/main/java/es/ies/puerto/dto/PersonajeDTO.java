package es.ies.puerto.dto;

import es.ies.puerto.modelo.entities.Arma;
import es.ies.puerto.modelo.entities.Material;
import es.ies.puerto.modelo.entities.Pal;

import java.util.*;

public class PersonajeDTO {
    private String personajeId;
    private String usuario;
    private List<Arma> armas;
    private List<Pal> pals;
    private Set<Material> materiales;


    public PersonajeDTO() {
    }

    public PersonajeDTO(String personajeId) {
        this.personajeId = personajeId;
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
        PersonajeDTO personajeDTO = (PersonajeDTO) o;
        return Objects.equals(personajeId, personajeDTO.personajeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personajeId);
    }

    @Override
    public String toString() {
        return "PersonajeDTO{" +
                "personajeId='" + personajeId + '\'' +
                ", usuario='" + usuario + '\'' +
                ", armas=" + armas +
                ", pals=" + pals +
                ", materiales=" + materiales +
                '}';
    }
}
