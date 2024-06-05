package es.ies.puerto.repositories;


import es.ies.puerto.modelo.entities.Arma;

import java.util.List;

public class ArmaRepository  {
    private List<Arma> armas;


    public Arma findById(String id){
        Arma arma =new Arma(id);
        int indice = armas.indexOf(arma);
        if (indice>=0){
            return armas.get(indice);
        }
        return null;
    }
    public List<Arma> findAll(){return armas;}
    public boolean save(Arma arma){
        if (!armas.contains(arma)) {
            return armas.add(arma);
        }
        return false;
    }

    public boolean delete(String id){
        Arma arma= new Arma(id);
        return armas.remove(arma);
    }
}
