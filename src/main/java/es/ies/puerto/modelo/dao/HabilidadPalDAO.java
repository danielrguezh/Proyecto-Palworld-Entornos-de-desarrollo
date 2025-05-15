package es.ies.puerto.modelo.dao;

<<<<<<< HEAD
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
=======

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
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
        }
        return lista.iterator().next();
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
    }
}
