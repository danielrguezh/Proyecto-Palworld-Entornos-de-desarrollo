package es.ies.puerto.modelo.abstractas;



import es.ies.puerto.modelo.Conexion;
<<<<<<< HEAD
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
=======

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DaoAbstract<T> extends Conexion {
    /**
     * Mapea una fila del ResultSet a un objeto T
     * @param rs el ResultSet apuntando a la fila actual
     * @return una instancia de T con los datos de la fila
     * @throws SQLException si ocurre un error al leer del ResultSet
     */
    protected abstract T mapRow(ResultSet rs) throws SQLException;

    /**
     * Ejecuta una consulta SQL y mapea cada fila a T usando mapRow
     * @param sql a ejecutar
     * @param parametros parámetros opcionales para el PreparedStatement
     * @return lista de objetos T
     */
    public List<T> executeQuery(String sql, Object... parametros) {
        List<T> lista = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql)) {
            for (int i = 0; i < parametros.length; i++) {
                sentencia.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    T objeto = mapRow(resultado);
                    lista.add(objeto);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
        return lista;
    }
}

>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
