package es.ies.puerto.repositories;

import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.modelo.entities.Material;

import java.util.List;

public class MaterialRespository {
    private List<Material> materiales;

    public Material findById(String id){
        Material material =new Material(id);
        int indice = materiales.indexOf(material);
        if (indice>=0){
            return materiales.get(indice);
        }
        return null;
    }
    public List<Material> findAll(){return materiales;}
    public boolean save(Material material){
        if (!materiales.contains(material)) {
            return materiales.add(material);
        }
        return false;
    }

    public boolean delete(String id){
        Material material= new Material(id);
        return materiales.remove(material);
    }
}
