package es.ies.puerto.modelo.dao;

<<<<<<< HEAD
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
=======


import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Pal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 

public class PalDAO extends DaoAbstract<Pal> {

    @Override
    protected Pal mapRow(ResultSet rs) throws SQLException {
        String palId = rs.getString("pal_id");
        String nombre = rs.getString("nombre");
        String elemento = rs.getString("elemento");
        int hp = rs.getInt("hp");
        int atk = rs.getInt("atk");
        int def = rs.getInt("def");
        String personajeId = rs.getString("personaje_id");
        return new Pal(palId, nombre, elemento, null, hp, atk, def, personajeId);
    }

    public List<Pal> findAllPal() {
        String query;
        query  = "select * from Pal";
        return executeQuery(query);
    }

    public Pal findPal(Pal pal) {
        String query = "select * from Pal where pal_id = ?";
        List<Pal> lista = executeQuery(query,pal.getPalId());
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

<<<<<<< HEAD
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
=======
    public boolean updatePal(Pal pal) {

        String query =  "update Pal set hp = ? ,atk = ?, def =?, personaje_id = ? where pal_id = ?";
        

         try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(query)) {
            sentencia.setInt(1, pal.getHp());
            sentencia.setInt(2, pal.getAtk());
            sentencia.setInt(3, pal.getDef());
            sentencia.setString(4, pal.getPersonajeId());
            sentencia.setString(5, pal.getPalId());
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

    public boolean deletePal(Pal pal) {
        String query = "delete FROM Pal where pal_id = ?";
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(query)) {
            sentencia.setString(1, pal.getPalId());
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

    

    
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
}
