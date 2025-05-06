package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.abstractas.DaoAbstract;
import es.ies.puerto.modelo.entities.Pal;
import es.ies.puerto.modelo.entities.Personaje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

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
        String query = "select p.personaje_id, p.usuario from Personaje as p" +
                " where p.id='"+personaje.getPersonajeId()+"'";
        Set<Personaje> lista = obtener(query);
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

    public boolean updatePersonaje(Personaje personaje) {

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

    public boolean deletePersonaje(Personaje Personaje) {
        String query = "delete FROM Personaje as p" +
                " where p.personaje_id='"+Personaje.getPersonajeId()+"'";
        actualizar(query);
    }

    
}
