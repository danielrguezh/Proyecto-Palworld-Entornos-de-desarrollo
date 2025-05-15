package es.ies.puerto.mapper;

import es.ies.puerto.dto.ArmaDTO;
import es.ies.puerto.modelo.entities.Arma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArmaMapperTest {
    Arma arma;
    Arma armaMapper;
    ArmaDTO armaDTO;
    ArmaDTO armaDTOMapper;

    @BeforeEach
    public void beforeEach() {
        armaDTO = new ArmaDTO();;
        armaDTO.setNombre("NOMBRE_TEST_dto");
        armaDTO.setDanio(50);
        armaDTO.setCargador(7);
        armaDTO.setPersonajeId("hola");

        arma = new Arma();;
        arma.setNombre("NOMBRE_TEST");
        arma.setDanio(55);
        arma.setCargador(8);
        arma.setPersonajeId("holi");

    }

    @Test
    public void armaToArmaDTOTest() {
        armaDTOMapper = ArmaMapper.armaToArmaDTO(arma);
        Assertions.assertEquals(arma.getNombre(), armaDTOMapper.getNombre(), "Resultado inesperado");
        Assertions.assertEquals(arma.getDanio(), armaDTOMapper.getDanio(), "Resultado inesperado");
        Assertions.assertEquals(arma.getCargador(), armaDTOMapper.getCargador(), "Resultado inesperado");
        Assertions.assertEquals(arma.getPersonajeId(), armaDTOMapper.getPersonajeId(), "Resultado inesperado");

    }

    @Test
    public void armaDTOToArmaTest() {
        armaMapper = ArmaMapper.armaDTOToArma(armaDTO);
        Assertions.assertEquals(armaDTO.getNombre(), armaMapper.getNombre(), "Resultado inesperado");
        Assertions.assertEquals(armaDTO.getDanio(), armaMapper.getDanio(), "Resultado inesperado");
        Assertions.assertEquals(armaDTO.getCargador(), armaMapper.getCargador(), "Resultado inesperado");
        Assertions.assertEquals(armaDTO.getPersonajeId(), armaMapper.getPersonajeId(), "Resultado inesperado");

    }
}

