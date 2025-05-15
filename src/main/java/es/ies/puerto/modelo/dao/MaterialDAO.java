package es.ies.puerto.modelo.dao;

<<<<<<< HEAD
import es.ies.puerto.exception.PalworldException;
import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Material;

=======
import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.modelo.entities.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
<<<<<<< HEAD
import java.util.Set;

public class MaterialDAO extends DaoAbstract {
    public MaterialDAO() throws PalworldException {
    }

    public Set<Material> findAllMaterial() throws PalworldException {
        String query;
        query  = "select m.nombre, m.cantidad, m.personae_i from Material as m";
        return obtener(query);
    }

    public Material findMaterial(Material material) throws PalworldException {
        String query = "select m.nombre, m.cantidad, m.personae_i from Material as m" +
                " where m.nombre='"+material.getNombre()+"'";
        Set<Material> lista = obtener(query);
=======
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
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

<<<<<<< HEAD
    public boolean updateMaterial(Material material) throws PalworldException {

        String query = "INSERT INTO Material as m (nombre, cantidad)" +
                " VALUES ('"+material.getNombre()+"','"+
                material.getCantidad() + "')";
        Material findMaterial = findMaterial(material);
        if (findMaterial!= null) {
            query = "update Material set cantidad='"+material.getCantidad()+"' " +
                    "where nombre='"+material.getNombre()+"'";
        }

        //Si existe actualiza
        //Si NO existe inserta
        actualizar(query);
        return false;
    }

    public void deleteMaterial(Material material) throws PalworldException {
        String query = "delete FROM Material as m" +
                " where m.nombre='"+material.getNombre()+"'";
        actualizar(query);
    }

    private Set<Material> obtener(String query) throws PalworldException {
        Set<Material> lista = new HashSet<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = getConexion().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int  cantidad = rs.getInt("cantidad");
                String personajeId = rs.getString("personaje_id");

                Material material = new Material(nombre,cantidad,personajeId);
                lista.add(material);
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
    
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
}
