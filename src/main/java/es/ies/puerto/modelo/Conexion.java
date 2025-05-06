package es.ies.puerto.modelo;

import es.ies.puerto.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection con;

    private String url;

    public Conexion() {
        this.url = "jdbc:sqlite:"+AppConfig.ConfigProperties.getUrlBd();
    }


    public Connection getConnection() {
        try {
            this.con = DriverManager.getConnection(url);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return con;
    }
}
