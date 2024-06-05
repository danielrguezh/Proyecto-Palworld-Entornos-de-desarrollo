package es.ies.puerto.modelo.dao;

import es.ies.puerto.exception.PalworldException;
import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Arma;
import es.ies.puerto.modelo.entities.HabilidadPal;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
public class HabilidadPalDAO extends DaoAbstract {
    public HabilidadPalDAO() throws PalworldException {
    }
    public Set<HabilidadPal> findAllHabilidadPal() throws PalworldException {
        String query;
        query  = "select h.nombre, h.descripcion, h.pal_id from HabilidadPal as h";
        return obtener(query);
    }

    public HabilidadPal findHabilidadPal(HabilidadPal habilidadPal) throws PalworldException {
        String query = "select h.nombre, h.descripcion, h.pal_id from HabilidadPal as h" +
                " where h.nombre='"+habilidadPal.getNombre()+"'";
        Set<HabilidadPal> lista = obtener(query);
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

    public boolean updateHabilidadPal(HabilidadPal habilidadPal) throws PalworldException {

        String query = "INSERT INTO HabilidadPal as h (nombre, descripcion)" +
                " VALUES ('"+habilidadPal.getNombre()+"','"+
                  habilidadPal.getDescripcion() + "')";
        HabilidadPal findHabilidadPal = findHabilidadPal(habilidadPal);
        if (findHabilidadPal!= null) {
            query = "update HabilidadPal set descripcion='"+habilidadPal.getDescripcion()+"' " +
                    "where nombre='"+habilidadPal.getNombre()+"'";
        }

        //Si existe actualiza
        //Si NO existe inserta
        actualizar(query);
        return false;
    }

    public void deleteHabilidadPal(HabilidadPal arma) throws PalworldException {
        String query = "delete FROM Habilidad as h" +
                " where h.nombre='"+arma.getNombre()+"'";
        actualizar(query);
    }

    private Set<HabilidadPal> obtener(String query) throws PalworldException {
        Set<HabilidadPal> lista = new HashSet<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = getConexion().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String  descripcion = rs.getString("descripcion");
                String palId = rs.getString("pal_id");

                HabilidadPal habilidadPal = new HabilidadPal(nombre,descripcion,palId);
                lista.add(habilidadPal);
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
