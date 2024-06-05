package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.entities.Arma;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.List;

public class ArmaDAOTest {
    static ArmaDAO armaDAO;

    final String nombre="nombre";
    final int danio=55;
    final int cargador=7;

    final String personajeId="1";

    final String nombreUpdate="nombreUpdate";
    Arma arma;

    @BeforeAll
    public static void beforeAll() {
        try {
            armaDAO = new ArmaDAO();
        }catch (Exception exception) {
            Assertions.fail("Se ha producido un error:"+exception.getMessage());
        }
    }

    @BeforeEach
    public void beforeEach() {
        try {
            arma = new Arma(nombre, danio, cargador,personajeId);
            armaDAO.updateArma(arma);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    @Test
    public void findAllArmaTest() {
        try {
            List<Arma> lista = armaDAO.findAllArma();
            Assertions.assertNotNull(lista);
            Assertions.assertTrue(lista.size()>0);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void findArmaTest() {
        try {
            Arma armaFind = armaDAO.findArma(arma);
            Assertions.assertNotNull(armaFind);
            Assertions.assertEquals(arma, armaFind);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void updateArmaTest() {
        try {
            Arma armaFind = armaDAO.findArma(arma);
            Assertions.assertNotNull(armaFind);
            armaFind.setNombre(nombreUpdate);
            armaDAO.updateArma(armaFind);
            Arma armaFindUpdate = armaDAO.findArma(arma);
            Assertions.assertNotNull(armaFindUpdate);
            Assertions.assertEquals(armaFind, armaFindUpdate);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @AfterEach
    public void afterEach()  {
        try {
            armaDAO.deleteArma(arma);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }
}
