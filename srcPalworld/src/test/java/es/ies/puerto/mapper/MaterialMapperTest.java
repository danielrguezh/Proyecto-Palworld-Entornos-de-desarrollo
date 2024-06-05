package es.ies.puerto.mapper;


import es.ies.puerto.dto.MaterialDTO;
import es.ies.puerto.modelo.entities.Material;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaterialMapperTest {
    Material material;
    Material materialMapper;
    MaterialDTO materialDTO;
    MaterialDTO materialDTOMapper;

    @BeforeEach
    public void beforeEach() {
        materialDTO = new MaterialDTO();;
        materialDTO.setNombre("NOMBRE TEST");
        materialDTO.setCantidad(40);
        materialDTO.setPersonajeId("ID TEST");


        material = new Material();
        material.setNombre("nombre test");
        material.setCantidad(55);
        material.setPersonajeId("id test");

    }

    @Test
    public void materialToMaterialDTOTest() {
        materialDTOMapper = MaterialMapper.materialToMaterialDTO(material);
        Assertions.assertEquals(material.getNombre(), materialDTOMapper.getNombre(), "Resultado inesperado");
        Assertions.assertEquals(material.getCantidad(), materialDTOMapper.getCantidad(), "Resultado inesperado");
        Assertions.assertEquals(material.getPersonajeId(), materialDTOMapper.getPersonajeId(), "Resultado inesperado");

    }

    @Test
    public void materialDTOTOToMaterialTest() {
        materialMapper = MaterialMapper.materialDTOTOToMaterial(materialDTO);
        Assertions.assertEquals(materialDTO.getNombre(), materialMapper.getNombre(), "Resultado inesperado");
        Assertions.assertEquals(materialDTO.getCantidad(), materialMapper.getCantidad(), "Resultado inesperado");
        Assertions.assertEquals(materialDTO.getPersonajeId(), materialMapper.getPersonajeId(), "Resultado inesperado");

    }
}
