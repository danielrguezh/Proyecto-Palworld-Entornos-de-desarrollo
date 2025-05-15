package es.ies.puerto.mapper;


import es.ies.puerto.dto.HabilidadPalDTO;
import es.ies.puerto.dto.PalDTO;
import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.modelo.entities.Pal;

public class HabilidadPalMapper {
    public static HabilidadPalDTO habilidadPalToHabilidadPalDTO(HabilidadPal habilidadPal){
        if (habilidadPal == null){
            return null;
        }
        HabilidadPalDTO habilidadPalDTO = new HabilidadPalDTO();
        habilidadPalDTO.setNombre(habilidadPal.getNombre());
        habilidadPalDTO.setDescripcion(habilidadPal.getDescripcion());
        habilidadPalDTO.setPalId(habilidadPal.getPalId());

        return habilidadPalDTO;
    }

    public static HabilidadPal habilidadPalDTOToHabilidadPal(HabilidadPalDTO habilidadPalDTO) {
        if (habilidadPalDTO == null) {
            return null;
        }
        HabilidadPal habilidadPal = new HabilidadPal();
        habilidadPal.setNombre(habilidadPalDTO.getNombre());
        habilidadPal.setDescripcion(habilidadPalDTO.getDescripcion());
        habilidadPal.setPalId(habilidadPalDTO.getPalId());

        return habilidadPal;
    }
    public static PalDTO habilidadPalToPalDTO(HabilidadPal habilidadPal) {
        if (habilidadPal == null) {
            return null;
        }

        PalDTO palDTO = new PalDTO();
        palDTO.setPalId(habilidadPal.getPalId());
        palDTO.setHabilidad(habilidadPal);

        return palDTO;
    }

    public static HabilidadPal palDTOToHabilidadPal(PalDTO palDTO) {
        if (palDTO == null) {
            return null;
        }

        HabilidadPal habilidadPal = new HabilidadPal();
        habilidadPal.setNombre(palDTO.getHabilidad().getNombre());
        habilidadPal.setDescripcion(palDTO.getHabilidad().getDescripcion());
        habilidadPal.setPalId(palDTO.getPalId());

        return habilidadPal;
    }
}
