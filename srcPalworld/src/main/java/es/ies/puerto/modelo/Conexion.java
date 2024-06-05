package es.ies.puerto.modelo;

import es.ies.puerto.config.AppConfig;
import es.ies.puerto.exception.PalworldException;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion extends AppConfig {
    private Connection con;

    private String url;

    public Conexion() throws PalworldException {
        super();
        this.url = "jdbc:sqlite:"+getUrlBd();
    }


    public Connection getConexion() throws PalworldException {
        try {
            this.con = DriverManager.getConnection(url);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new PalworldException("No se ha podido establecer la conexion",
                    exception);
        }
        return con;
    }
}
