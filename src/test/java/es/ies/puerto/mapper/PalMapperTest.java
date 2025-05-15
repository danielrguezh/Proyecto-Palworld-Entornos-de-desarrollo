package es.ies.puerto.mapper;


import es.ies.puerto.dto.PalDTO;
import es.ies.puerto.modelo.entities.Pal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalMapperTest {
    Pal pal;
    Pal palMapper;
    PalDTO palDTO;
    PalDTO palDTOMapper;

    @BeforeEach
    public void beforeEach() {
        palDTO = new PalDTO();
        palDTO.setPalId("PAL ID");
        palDTO.setNombre("NOMBRE");
        palDTO.setElemento("ELEMENTO");
        palDTO.setHabilidad(null);
        palDTO.setHp(111);
        palDTO.setAtk(75);
        palDTO.setDef(75);
        palDTO.setPersonajeId("PERSONAJE");


        pal = new Pal();
        pal.setPalId("PAL ID");
        pal.setNombre("NOMBRE");;
        pal.setElemento("ELEMENTO");;
        pal.setHabilidad(null);;
        pal.setHp(111);
        pal.setAtk(75);
        pal.setDef(75);
        pal.setPersonajeId("PERSONAJE");



    }

    @Test
    public void palToPalDTOTest() {
        palDTOMapper = PalMapper.palToPalDTO(pal);
        Assertions.assertEquals(pal.getPalId(), palDTOMapper.getPalId(), "Resultado inesperado");
        Assertions.assertEquals(pal.getNombre(), palDTOMapper.getNombre(), "Resultado inesperado");
        Assertions.assertEquals(pal.getElemento(), palDTOMapper.getElemento(), "Resultado inesperado");
        Assertions.assertEquals(pal.getHabilidad(), palDTOMapper.getHabilidad(), "Resultado inesperado");
        Assertions.assertEquals(pal.getHp(), palDTOMapper.getHp(), "Resultado inesperado");
        Assertions.assertEquals(pal.getAtk(), palDTOMapper.getAtk(), "Resultado inesperado");
        Assertions.assertEquals(pal.getDef(), palDTOMapper.getDef(), "Resultado inesperado");
        Assertions.assertEquals(pal.getPersonajeId(), palDTOMapper.getPersonajeId(), "Resultado inesperado");

    }

    @Test
    public void palDTOToPalTest() {
        palMapper = PalMapper.palDTOToPal(palDTO);
        Assertions.assertEquals(palDTO.getPalId(), palMapper.getPalId(), "Resultado inesperado");
        Assertions.assertEquals(palDTO.getNombre(), palMapper.getNombre(), "Resultado inesperado");
        Assertions.assertEquals(palDTO.getElemento(), palMapper.getElemento(), "Resultado inesperado");
        Assertions.assertEquals(palDTO.getHabilidad(), palMapper.getHabilidad(), "Resultado inesperado");
        Assertions.assertEquals(palDTO.getHp(), palMapper.getHp(), "Resultado inesperado");
        Assertions.assertEquals(palDTO.getAtk(), palMapper.getAtk(), "Resultado inesperado");
        Assertions.assertEquals(palDTO.getDef(), palMapper.getDef(), "Resultado inesperado");
        Assertions.assertEquals(palDTO.getPersonajeId(), palMapper.getPersonajeId(), "Resultado inesperado");

    }
}
