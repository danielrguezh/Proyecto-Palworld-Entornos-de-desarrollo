package es.ies.puerto.repositories;


import es.ies.puerto.modelo.entities.Pal;

import java.util.List;

public class PalRepository {
    private List<Pal> pals;

    public Pal findById(String id){
        Pal pal =new Pal(id);
        int indice = pals.indexOf(pal);
        if (indice>=0){
            return pals.get(indice);
        }
        return null;
    }
    public List<Pal> findAll(){return pals;}
    public boolean save(Pal pal){
        if (!pals.contains(pal)) {
            return pals.add(pal);
        }
        return false;
    }

    public boolean delete(String id){
        Pal pal= new Pal(id);
        return pals.remove(pal);
    }
}
