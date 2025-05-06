package es.ies.puerto.modelo.dao;



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
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

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

    

    
}
