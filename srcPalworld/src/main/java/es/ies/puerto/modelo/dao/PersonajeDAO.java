package es.ies.puerto.modelo.dao;

import es.ies.puerto.exception.PalworldException;
import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Personaje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class PersonajeDAO extends DaoAbstract {
    public PersonajeDAO() throws PalworldException {
    }

    public Set<Personaje> findAllPersonaje() throws PalworldException {
        String query;
        query  = "select p.personaje_id, p.usuario from Personaje as p";
        return obtener(query);
    }

    public Personaje findPersonaje(Personaje personaje) throws PalworldException {
        String query = "select p.personaje_id, p.usuario from Personaje as p" +
                " where p.id='"+personaje.getPersonajeId()+"'";
        Set<Personaje> lista = obtener(query);
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

    public boolean updatePersonaje(Personaje personaje) throws PalworldException {

        String query = "INSERT INTO Personaje as p (personaje_id, usuario)" +
                " VALUES ('"+personaje.getPersonajeId()+"'"+personaje.getUsuario()+"')";
        Personaje findPersonaje = findPersonaje(personaje);
        if (findPersonaje!= null) {
            query = "update Personaje set usuario='"+personaje.getUsuario()+"'" +
                    " where personaje_id='"+personaje.getPersonajeId()+"'";
        }

        //Si existe actualiza
        //Si NO existe inserta
        actualizar(query);
        return false;
    }

    public void deletePersonaje(Personaje Personaje) throws PalworldException {
        String query = "delete FROM Personaje as p" +
                " where p.personaje_id='"+Personaje.getPersonajeId()+"'";
        actualizar(query);
    }

    private Set<Personaje> obtener(String query) throws PalworldException {
        Set<Personaje> lista = new HashSet<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = getConexion().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String personajeId = rs.getString("personaje_id");
                String usuario = rs.getString("usuario");

                Personaje Personaje = new Personaje(personajeId,usuario,null, null,null);
                lista.add(Personaje);
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
