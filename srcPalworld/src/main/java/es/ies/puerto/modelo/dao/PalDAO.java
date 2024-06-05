package es.ies.puerto.modelo.dao;

import es.ies.puerto.dto.PalDTO;
import es.ies.puerto.exception.PalworldException;
import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Pal;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalDAO extends DaoAbstract {

    public PalDAO() throws PalworldException {
    }

    public List<Pal> findAllPal() throws PalworldException {
        String query;
        query  = "select p.pal_id, p.nombre, p.elemento, p.hp, p.atk, p.def, p.personaje_id from Pal as p";
        return obtener(query);
    }

    public Pal findPal(Pal pal) throws PalworldException {
        String query = "select p.pal_id, p.nombre, p.elemento, p.hp, p.atk, p.def, p.personaje_id from Pal as p" +
                " where p.pal_id='"+pal.getPalId()+"'";
        List<Pal> lista = obtener(query);
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

    public boolean updatePal(Pal pal) throws PalworldException {

        String query = "INSERT INTO Pal as p (pal_id, nombre, elemento, hp, atk, def)" +
                " VALUES ('"+pal.getPalId()+"','"+pal.getNombre()+"','"
                + pal.getAtk()+"','" +pal.getDef() + "')";
        Pal findPal = findPal(pal);
        if (findPal!= null) {
            query = "update Pal set pal_id='"+pal.getPalId()+"' " +
                    ",nombre='"+pal.getNombre()+"' " +",elemento='"+pal.getElemento()+"' " +
                    ",hp='"+pal.getHp()+"' " +",atk='"+pal.getAtk()+"' " +",def='"+pal.getDef()+"' " +
                    "where pal_id='"+pal.getPalId()+"'";
        }

        //Si existe actualiza
        //Si NO existe inserta
        actualizar(query);
        return false;
    }

    public void deletePal(Pal pal) throws PalworldException {
        String query = "delete FROM Pal as p" +
                " where p.nombre='"+pal.getNombre()+"'";
        actualizar(query);
    }

    private List<Pal> obtener(String query) throws PalworldException {
        List<Pal> lista = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = getConexion().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String palId = rs.getString("pal_id");
                String nombre = rs.getString("nombre");
                String elemento = rs.getString("elemento");
                int hp = rs.getInt("hp");
                int atk = rs.getInt("atk");
                int def = rs.getInt("def");
                String personajeId = rs.getString("personaje_id");

                Pal pal = new Pal(palId,nombre,elemento,null,hp,atk,def,personajeId);
                lista.add(pal);
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
