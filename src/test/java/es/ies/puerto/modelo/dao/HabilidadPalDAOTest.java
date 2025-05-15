package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.entities.HabilidadPal;
import org.junit.jupiter.api.*;

import java.util.Set;

public class HabilidadPalDAOTest {
    static HabilidadPalDAO habilidadPalDAO;
    final String nombre="nombre";
    final String descripcion="descripcion";
    final String descripcionUpdate="descripcionUpdate";
    HabilidadPal habilidadPal;

    @BeforeAll
    public static void beforeAll() {
        try {
            habilidadPalDAO = new HabilidadPalDAO();
        }catch (Exception exception) {
            Assertions.fail("Se ha producido un error:"+exception.getMessage());
        }
    }

    @BeforeEach
    public void beforeEach() {
        try {
            habilidadPal = new HabilidadPal(nombre,descripcion,"1");
            habilidadPalDAO.updateHabilidadPal(habilidadPal);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    @Test
    public void findAllHabilidadPalTest() {
        try {
            Set<HabilidadPal> lista = habilidadPalDAO.findAllHabilidadPal();
            Assertions.assertNotNull(lista);
            Assertions.assertTrue(lista.size()>0);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void findHabilidadPalTest() {
        try {
            HabilidadPal habilidadPalFind = habilidadPalDAO.findHabilidadPal(habilidadPal);
            Assertions.assertNotNull(habilidadPalFind);
            Assertions.assertEquals(habilidadPal, habilidadPalFind);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void updateHabilidadPalTest() {
        try {
            HabilidadPal habilidadPalFind = habilidadPalDAO.findHabilidadPal(habilidadPal);
            Assertions.assertNotNull(habilidadPalFind);
            habilidadPalFind.setDescripcion(descripcionUpdate);
            habilidadPalDAO.updateHabilidadPal(habilidadPalFind);
            HabilidadPal habilidadPalFindUpdate = habilidadPalDAO.findHabilidadPal(habilidadPal);
            Assertions.assertNotNull(habilidadPalFindUpdate);
            Assertions.assertEquals(habilidadPalFind, habilidadPalFindUpdate);
            Assertions.assertEquals(habilidadPalFind.getDescripcion(), habilidadPalFindUpdate.getDescripcion());

        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @AfterEach
    public void afterEach()  {
        try {
            habilidadPalDAO.deleteHabilidadPal(habilidadPal);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }
}
