package es.ies.puerto.mapper;

import es.ies.puerto.dto.ArmaDTO;
import es.ies.puerto.dto.PersonajeDTO;
import es.ies.puerto.modelo.entities.Arma;

public class ArmaMapper {
    public static ArmaDTO armaToArmaDTO(Arma arma){
        if (arma == null){
            return null;
        }
        ArmaDTO armaDTO = new ArmaDTO();
        armaDTO.setNombre(arma.getNombre());
        armaDTO.setDanio(arma.getDanio());
        armaDTO.setCargador(arma.getCargador());
        armaDTO.setPersonajeId(arma.getPersonajeId());

        return armaDTO;
    }

    public static Arma armaDTOToArma(ArmaDTO armaDTO){
        if (armaDTO == null){
            return null;
        }
        Arma arma = new Arma();
        arma.setNombre(armaDTO.getNombre());
        arma.setDanio(armaDTO.getDanio());
        arma.setCargador(armaDTO.getCargador());
        arma.setPersonajeId(armaDTO.getPersonajeId());
        return arma;
    }
}
