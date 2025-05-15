package es.ies.puerto.config;

<<<<<<< HEAD
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
=======

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class AppConfig {
    public static class ConfigProperties {

        private static final String PATH_FILE = "src/main/resources/app.properties";
        private static final Properties properties = new Properties();
        
        static {
            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(PATH_FILE), StandardCharsets.UTF_8)) {  
                properties.load(reader); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static String getUrlBd() {
            return properties.getProperty("urlBd");
        }
    }
>>>>>>> b865901311f364fc8bec01eb825d877c70aee881
}
