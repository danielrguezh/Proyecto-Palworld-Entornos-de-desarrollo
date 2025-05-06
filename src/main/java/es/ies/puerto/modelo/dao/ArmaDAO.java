package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Arma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArmaDAO extends DaoAbstract<Arma> {

    @Override
    protected Arma mapRow(ResultSet rs) throws SQLException {
        String nombre = rs.getString("nombre");
        int danio = rs.getInt("danio");
        int cargador = rs.getInt("cargador");
        String personajeId = rs.getString("personaje_id");
        return new Arma(nombre,danio,cargador,personajeId);
    }
    


    public List<Arma> findAllArma() {
        String query  = "select * from Arma";
        return executeQuery(query);
    }

    public Arma findArma(Arma arma) {
        String query = "select * from Arma where nombre = ? ";
        List<Arma> lista = executeQuery(query, arma.getNombre());
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

    /**
     * Metodo para crear un arma
     * @param arma a crear
     * @return true/false
     */
    public boolean crearArma(Arma arma) {
        String sql = "INSERT INTO Arma (nombre, danio, cargador, personaje_id) VALUES (?, ?, ?, ?);";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {        
            sentencia.setString(1, arma.getNombre());
            sentencia.setInt(2, arma.getDanio());
            sentencia.setInt(3, arma.getCargador());
            sentencia.setString(4,arma.getPersonajeId());
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

    public boolean updateArma(Arma arma){

        String query = "update Arma set danio = ? , cargador = ? where nombre= ? ";

        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(query)) {
            sentencia.setInt(1, arma.getDanio());
            sentencia.setInt(2, arma.getCargador());
            sentencia.setString(3, arma.getNombre());
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

    public boolean deleteArma(Arma arma) {
        String query = "delete FROM Arma as a where a.nombre= ? ";
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(query)) {
            sentencia.setString(1, arma.getNombre());
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
