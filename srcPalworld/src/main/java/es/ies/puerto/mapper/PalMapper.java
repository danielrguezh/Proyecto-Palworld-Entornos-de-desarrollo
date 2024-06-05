package es.ies.puerto.mapper;


import es.ies.puerto.dto.PalDTO;
import es.ies.puerto.modelo.entities.Pal;

public class PalMapper {
    public static PalDTO palToPalDTO(Pal pal){
        if (pal == null){
            return null;
        }
        PalDTO palDTO = new PalDTO();
        palDTO.setPalId(pal.getPalId());
        palDTO.setNombre(pal.getNombre());
        palDTO.setElemento(pal.getElemento());
        palDTO.setHabilidad(pal.getHabilidad());
        palDTO.setHp(pal.getHp());
        palDTO.setAtk(pal.getAtk());
        palDTO.setDef(pal.getDef());
        palDTO.setPersonajeId(pal.getPersonajeId());

        return palDTO;
    }

    public static Pal palDTOToPal(PalDTO palDTO) {
        if (palDTO == null){
            return null;
        }
        Pal pal = new Pal();
        pal.setPalId(palDTO.getPalId());
        pal.setNombre(palDTO.getNombre());
        pal.setElemento(palDTO.getElemento());
        pal.setHabilidad(palDTO.getHabilidad());
        pal.setHp(palDTO.getHp());
        pal.setAtk(palDTO.getAtk());
        pal.setDef(palDTO.getDef());
        pal.setPersonajeId(palDTO.getPersonajeId());

        return pal;
    }
}
