package es.ies.puerto.modelo.dao;

import es.ies.puerto.exception.PalworldException;
import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class MaterialDAO extends DaoAbstract {
    public MaterialDAO() throws PalworldException {
    }

    public Set<Material> findAllMaterial() throws PalworldException {
        String query;
        query  = "select m.nombre, m.cantidad, m.personae_i from Material as m";
        return obtener(query);
    }

    public Material findMaterial(Material material) throws PalworldException {
        String query = "select m.nombre, m.cantidad, m.personae_i from Material as m" +
                " where m.nombre='"+material.getNombre()+"'";
        Set<Material> lista = obtener(query);
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

    public boolean updateMaterial(Material material) throws PalworldException {

        String query = "INSERT INTO Material as m (nombre, cantidad)" +
                " VALUES ('"+material.getNombre()+"','"+
                material.getCantidad() + "')";
        Material findMaterial = findMaterial(material);
        if (findMaterial!= null) {
            query = "update Material set cantidad='"+material.getCantidad()+"' " +
                    "where nombre='"+material.getNombre()+"'";
        }

        //Si existe actualiza
        //Si NO existe inserta
        actualizar(query);
        return false;
    }

    public void deleteMaterial(Material material) throws PalworldException {
        String query = "delete FROM Material as m" +
                " where m.nombre='"+material.getNombre()+"'";
        actualizar(query);
    }

    private Set<Material> obtener(String query) throws PalworldException {
        Set<Material> lista = new HashSet<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = getConexion().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int  cantidad = rs.getInt("cantidad");
                String personajeId = rs.getString("personaje_id");

                Material material = new Material(nombre,cantidad,personajeId);
                lista.add(material);
            }
        } catch (SQLException exception) {
            throw new PalworldException(exception.getMessage(), exception);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                if (!getConexion().isClosed()) {
                    getConexion().close();
                }
            } catch (SQLException e) {
                throw new PalworldException(e.getMessage(), e);
            }
        }
        return lista;
    }
}
