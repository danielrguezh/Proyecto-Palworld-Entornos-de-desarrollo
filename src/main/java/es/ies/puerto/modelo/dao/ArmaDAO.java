package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.abstractas.DaoAbstract;
<<<<<<< HEAD
import es.ies.puerto.exception.PalworldException;
import es.ies.puerto.modelo.entities.Arma;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArmaDAO extends DaoAbstract {

    public ArmaDAO() throws PalworldException {
    }

    public List<Arma> findAllArma() throws PalworldException {
        String query;
        query  = "select a.nombre, a.daño, a.potencia, a.personaje_id from Arma as a";
        return obtener(query);
    }

    public Arma findArma(Arma arma) throws PalworldException {
        String query = "select a.nombre, a.daño, a.potencia, a.personaje_id from Arma as a" +
                " where a.nombre='"+arma.getNombre()+"'";
        List<Arma> lista = obtener(query);
=======
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
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

<<<<<<< HEAD
    public boolean updateArma(Arma arma) throws PalworldException {

        String query = "INSERT INTO Arma as a (nombre, daño, cargador)" +
                " VALUES ('"+arma.getNombre()+"','"+
                + arma.getDanio()+"','" +arma.getCargador() + "')";
        Arma findArma = findArma(arma);
        if (findArma!= null) {
            query = "update Arma set daño='"+arma.getDanio()+"',cargador='" +arma.getCargador()+"' "+

            "where nombre='"+arma.getNombre()+"'";
        }

        //Si existe actualiza
        //Si NO existe inserta
        actualizar(query);
        return false;
    }

    public void deleteArma(Arma arma) throws PalworldException {
        String query = "delete FROM Arma as a" +
                " where a.nombre='"+arma.getNombre()+"'";
        actualizar(query);
    }

    private List<Arma> obtener(String query) throws PalworldException {
        List<Arma> lista = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = getConexion().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int danio = rs.getInt("daño");
                int cargador = rs.getInt("cargador");
                String personajeId = rs.getString("personaje_id");

                Arma arma = new Arma(nombre,danio,cargador,personajeId);
                lista.add(arma);
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
=======
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
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
    }
}
