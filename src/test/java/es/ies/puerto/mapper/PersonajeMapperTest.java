package es.ies.puerto.mapper;


import es.ies.puerto.dto.PersonajeDTO;
import es.ies.puerto.modelo.entities.Personaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonajeMapperTest {
    Personaje personaje;
    Personaje personajeMapper;
    PersonajeDTO personajeDTO;
    PersonajeDTO personajeDTOMapper;

    @BeforeEach
    public void beforeEach() {
        personajeDTO = new PersonajeDTO();
        personajeDTO.setPersonajeId("ID");
        personajeDTO.setUsuario("USUARIO");
        personajeDTO.setArmas(null);
        personajeDTO.setPals(null);
        personajeDTO.setMateriales(null);


        personaje = new Personaje();
        personaje.setPersonajeId("id");
        personaje.setUsuario("usuario");
        personaje.setArmas(null);
        personaje.setPals(null);
        personaje.setMateriales(null);

    }

    @Test
    public void personajeToPersonajeDTOTest() {
        personajeDTOMapper = PersonajeMapper.personajeToPersonajeDTO(personaje);
        Assertions.assertEquals(personaje.getPersonajeId(), personajeDTOMapper.getPersonajeId(), "Resultado inesperado");
        Assertions.assertEquals(personaje.getUsuario(), personajeDTOMapper.getUsuario(), "Resultado inesperado");
        Assertions.assertEquals(personaje.getArmas(), personajeDTOMapper.getArmas(), "Resultado inesperado");
        Assertions.assertEquals(personaje.getPals(), personajeDTOMapper.getPals(), "Resultado inesperado");
        Assertions.assertEquals(personaje.getMateriales(), personajeDTOMapper.getMateriales(), "Resultado inesperado");

    }

    @Test
    public void palDTOToPalTest() {
        personajeMapper = PersonajeMapper.personajeDTOToPersonaje(personajeDTO);
        Assertions.assertEquals(personajeDTO.getPersonajeId(), personajeMapper.getPersonajeId(), "Resultado inesperado");
        Assertions.assertEquals(personajeDTO.getUsuario(), personajeMapper.getUsuario(), "Resultado inesperado");
        Assertions.assertEquals(personajeDTO.getArmas(), personajeMapper.getArmas(), "Resultado inesperado");
        Assertions.assertEquals(personajeDTO.getPals(), personajeMapper.getPals(), "Resultado inesperado");
        Assertions.assertEquals(personajeDTO.getMateriales(), personajeMapper.getMateriales(), "Resultado inesperado");

    }
}
