package es.ies.puerto.config;

import es.ies.puerto.exception.PalworldException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    String urlBd;
    public AppConfig() throws PalworldException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/app.properties")) {
            properties.load(fis);
            urlBd = (String) properties.get("urlBd");
        } catch (IOException e) {
            throw new PalworldException(e.getMessage(),e);
        }
    }

    public String getUrlBd() {
        return urlBd;
    }
}
