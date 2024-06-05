package es.ies.puerto.modelo.abstractas;



import es.ies.puerto.modelo.Conexion;
import es.ies.puerto.exception.PalworldException;

import java.sql.SQLException;
import java.sql.Statement;

public class DaoAbstract extends Conexion {
    public DaoAbstract() throws PalworldException {
        super();
    }

    public void actualizar(String query) throws PalworldException {
        Statement statement = null;
        try {
            statement = getConexion().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            throw new PalworldException(exception.getMessage(), exception);
        } finally {
            try {
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
    }
}
