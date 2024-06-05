package es.ies.puerto.mapper;


import es.ies.puerto.dto.HabilidadPalDTO;
import es.ies.puerto.modelo.entities.HabilidadPal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HabilidadPalMapperTest {
    HabilidadPal habilidadPal;
    HabilidadPal habilidadPalMapper;
    HabilidadPalDTO habilidadPalDTO;
    HabilidadPalDTO habilidadPalDTOMapper;

    @BeforeEach
    public void beforeEach() {
        habilidadPalDTO = new HabilidadPalDTO();;
        habilidadPalDTO.setNombre("NOMBRE TEST");
        habilidadPalDTO.setDescripcion("DESC TEST");
        habilidadPalDTO.setPalId("ID TEST");


        habilidadPal = new HabilidadPal();
        habilidadPal.setNombre("nombre test");
        habilidadPal.setDescripcion("desc test");
        habilidadPal.setPalId("id test");

    }

    @Test
    public void habilidadPalToHabilidadPalDTOTest() {
        habilidadPalDTOMapper = HabilidadPalMapper.habilidadPalToHabilidadPalDTO(habilidadPal);
        Assertions.assertEquals(habilidadPal.getNombre(), habilidadPalDTOMapper.getNombre(), "Resultado inesperado");
        Assertions.assertEquals(habilidadPal.getDescripcion(), habilidadPalDTOMapper.getDescripcion(), "Resultado inesperado");
        Assertions.assertEquals(habilidadPal.getPalId(), habilidadPalDTOMapper.getPalId(), "Resultado inesperado");

    }

    @Test
    public void habilidadPalDTOToHabilidadPalTest() {
        habilidadPalMapper = HabilidadPalMapper.habilidadPalDTOToHabilidadPal(habilidadPalDTO);
        Assertions.assertEquals(habilidadPalDTO.getNombre(), habilidadPalMapper.getNombre(), "Resultado inesperado");
        Assertions.assertEquals(habilidadPalDTO.getDescripcion(), habilidadPalMapper.getDescripcion(), "Resultado inesperado");
        Assertions.assertEquals(habilidadPalDTO.getPalId(), habilidadPalMapper.getPalId(), "Resultado inesperado");

    }
}
