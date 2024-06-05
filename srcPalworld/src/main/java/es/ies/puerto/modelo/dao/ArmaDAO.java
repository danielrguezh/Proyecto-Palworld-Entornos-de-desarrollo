package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.abstractas.DaoAbstract;
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
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

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
    }
}
