package es.ies.puerto.mapper;


import es.ies.puerto.dto.MaterialDTO;
import es.ies.puerto.modelo.entities.Material;

public class MaterialMapper {
    public static MaterialDTO materialToMaterialDTO(Material material){
        if (material == null){
            return null;
        }
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setNombre(material.getNombre());
        materialDTO.setCantidad(material.getCantidad());
        materialDTO.setPersonajeId(material.getPersonajeId());

        return materialDTO;
    }

    public static Material materialDTOTOToMaterial(MaterialDTO materialDTO) {
        if (materialDTO == null) {
            return null;
        }
        Material material = new Material();
        material.setNombre(materialDTO.getNombre());
        material.setCantidad(materialDTO.getCantidad());
        material.setPersonajeId(materialDTO.getPersonajeId());

        return material;
    }
}
