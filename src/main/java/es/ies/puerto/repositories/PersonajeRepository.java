package es.ies.puerto.repositories;



import es.ies.puerto.modelo.entities.Personaje;

import java.util.List;

public class PersonajeRepository {
    private List<Personaje> personajes;


    public Personaje findById(String id){
        Personaje arma =new Personaje(id);
        int indice = personajes.indexOf(arma);
        if (indice>=0){
            return personajes.get(indice);
        }
        return null;
    }
    public List<Personaje> findAll(){return personajes;}
    public boolean save(Personaje arma){
        if (!personajes.contains(arma)) {
            return personajes.add(arma);
        }
        return false;
    }

    public boolean delete(String id){
        Personaje arma= new Personaje(id);
        return personajes.remove(arma);
    }
}
