package es.ies.puerto.modelo.dao;

<<<<<<< HEAD
import es.ies.puerto.exception.PalworldException;
import es.ies.puerto.modelo.abstractas.DaoAbstract;
=======
import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Pal;
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
import es.ies.puerto.modelo.entities.Personaje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
public class PersonajeDAO extends DaoAbstract {
    public PersonajeDAO() throws PalworldException {
    }

    public Set<Personaje> findAllPersonaje() throws PalworldException {
        String query;
        query  = "select p.personaje_id, p.usuario from Personaje as p";
        return obtener(query);
    }

    public Personaje findPersonaje(Personaje personaje) throws PalworldException {
=======
public class PersonajeDAO extends DaoAbstract<Personaje> {

    @Override
    protected Personaje mapRow(ResultSet rs) throws SQLException {
        String personajeId = rs.getString("personaje_id");
        String usuario = rs.getString("usuario");
        return new Personaje(personajeId, usuario, null, null, null);
    }
    public Set<Personaje> findAllPersonaje() {
        String query;
        query  = "select personaje_id, usuario from Personaje";
        return obtener(query);
    }

    public Personaje findPersonaje(Personaje personaje)  {
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
        String query = "select p.personaje_id, p.usuario from Personaje as p" +
                " where p.id='"+personaje.getPersonajeId()+"'";
        Set<Personaje> lista = obtener(query);
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

<<<<<<< HEAD
    public boolean updatePersonaje(Personaje personaje) throws PalworldException {
=======
    public boolean updatePersonaje(Personaje personaje) {
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881

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

<<<<<<< HEAD
    public void deletePersonaje(Personaje Personaje) throws PalworldException {
=======
    public boolean deletePersonaje(Personaje Personaje) {
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
        String query = "delete FROM Personaje as p" +
                " where p.personaje_id='"+Personaje.getPersonajeId()+"'";
        actualizar(query);
    }

<<<<<<< HEAD
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
=======
    
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
}
