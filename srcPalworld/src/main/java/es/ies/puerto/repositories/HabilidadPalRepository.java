package es.ies.puerto.repositories;


import es.ies.puerto.modelo.entities.HabilidadPal;

import java.util.ArrayList;
import java.util.List;

public class HabilidadPalRepository {
    private List<HabilidadPal> habilidades;

    public HabilidadPal findById(String id){
        HabilidadPal habilidadPal =new HabilidadPal(id);
        int indice = habilidades.indexOf(habilidadPal);
        if (indice>=0){
            return habilidades.get(indice);
        }
        return null;
    }
    public List<HabilidadPal> findAll(){return habilidades;}
    public boolean save(HabilidadPal habilidadPal){
        if (!habilidades.contains(habilidadPal)) {
            return habilidades.add(habilidadPal);
        }
        return false;
    }

    public boolean delete(String id){
        HabilidadPal habilidadPal= new HabilidadPal(id);
        return habilidades.remove(habilidadPal);
    }
}
