package es.ies.puerto.modelo.dao;


import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.HabilidadPal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class HabilidadPalDAO extends DaoAbstract<HabilidadPal> {
    
    @Override
    protected HabilidadPal mapRow(ResultSet rs) throws SQLException {
        String nombre = rs.getString("nombre");
        String danio = rs.getString("descripcion");
        String palId = rs.getString("pal_id");
        return new HabilidadPal(nombre,danio,palId);
    }
    public List<HabilidadPal> findAllHabilidadPal() {
        String query= "select * from HabilidadPal";
        return executeQuery(query);
    }

    public HabilidadPal findHabilidadPal(HabilidadPal habilidadPal) {
        String query = "select * from HabilidadPal where nombre= ? ";
        List<HabilidadPal> lista = executeQuery(query, habilidadPal.getNombre());
        if(lista.isEmpty()) {
             return null;
        }
        return lista.iterator().next();
    }

    public boolean crearHabilidadPal(HabilidadPal habilidadPal) {
        String sql = "INSERT INTO HabilidadPal (nombre, descripcion, pal_id) VALUES (?, ?, ?);";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {        
            sentencia.setString(1, habilidadPal.getNombre());
            sentencia.setString(2, habilidadPal.getDescripcion());
            sentencia.setString(3, habilidadPal.getPalId());
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

    public boolean updateHabilidadPal(HabilidadPal habilidadPal) {

        String query = "update HabilidadPal set descripcion = ? where nombre = ? ";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(query)) {
            sentencia.setString(1, habilidadPal.getDescripcion());
            sentencia.setString(2, habilidadPal.getNombre());
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

    public boolean deleteHabilidadPal(HabilidadPal habilidadPal) {
        String query = "delete FROM Habilidad where nombre = ?";
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(query)) {
            sentencia.setString(1, habilidadPal.getNombre());
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
