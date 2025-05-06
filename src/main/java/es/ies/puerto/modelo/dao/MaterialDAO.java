package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.modelo.entities.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;

public class MaterialDAO extends DaoAbstract<Material> {
    
    @Override
    protected Material mapRow(ResultSet rs) throws SQLException {
        String nombre = rs.getString("nombre");
        int cantidad = rs.getInt("cantidad");
        String personajeId = rs.getString("personaje_id");
        return new Material(nombre,cantidad,personajeId);
    }

    public List<Material> findAllMaterial() {
        String query  = "select * from Material";
        return executeQuery(query);
    }

    public Material findMaterial(Material material) {
        String query = "select * from Material as where nombre = ?";
        List<Material> lista = executeQuery(query,material.getNombre());
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

    public boolean crearMaterial(Material material) {
        String sql = "INSERT INTO Material (nombre, cantidad, personaje_id) VALUES (?, ?, ?);";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {        
            sentencia.setString(1, material.getNombre());
            sentencia.setInt(2, material.getCantidad());
            sentencia.setString(3, material.getPersonajeId());
            sentencia.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { 
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean updateMaterial(Material material) {
        String query = "update Material set cantidad = ? where nombre = ? AND personaje_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(query)) {
            sentencia.setInt(1, material.getCantidad());
            sentencia.setString(2, material.getNombre());
            sentencia.setString(3, material.getPersonajeId());
            sentencia.executeUpdate();
            int filas = sentencia.executeUpdate();
            return filas == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean deleteMaterial(Material material) {
        String query = "delete FROM Material where nombre = ? AND personaje_id = ?";
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(query)) {
            sentencia.setString(1, material.getNombre());
            sentencia.setString(1, material.getPersonajeId());
            int filas = sentencia.executeUpdate();
            return filas == 1;
        } catch (SQLException e) {
            e.printStackTrace();
                return false;
        } finally {
             try {
                getConnection().close();;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
