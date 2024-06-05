package es.ies.puerto.mapper;

import es.ies.puerto.dto.PersonajeDTO;
import es.ies.puerto.modelo.entities.Personaje;

public class PersonajeMapper {
    public static PersonajeDTO personajeToPersonajeDTO(Personaje personaje){
        if (personaje == null){
            return null;
        }
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setPersonajeId(personaje.getPersonajeId());
        personajeDTO.setUsuario(personaje.getUsuario());
        personajeDTO.setArmas(personaje.getArmas());
        personajeDTO.setPals(personaje.getPals());
        personajeDTO.setMateriales(personaje.getMateriales());

        return personajeDTO;
    }

    public static Personaje personajeDTOToPersonaje(PersonajeDTO personajeDTO){
        if (personajeDTO == null){
            return null;
        }

        Personaje personaje = new Personaje();
        personaje.setPersonajeId(personajeDTO.getPersonajeId());
        personaje.setUsuario(personajeDTO.getUsuario());
        personaje.setArmas(personajeDTO.getArmas());
        personaje.setPals(personajeDTO.getPals());
        personaje.setMateriales(personajeDTO.getMateriales());

        return personaje;
    }
}
