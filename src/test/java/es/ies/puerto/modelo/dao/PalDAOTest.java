package es.ies.puerto.modelo.dao;


import es.ies.puerto.modelo.entities.Pal;
import org.junit.jupiter.api.*;

import java.util.List;

public class PalDAOTest {
    static PalDAO palDAO;
    final String palId="palId";
    final String nombre="nombre";
    final String elemento="elemento";
    final int hp=100;
    final int atk=75;
    final int def=55;

    final String nombreUpdate="nombreUpdate";
    Pal pal;

    @BeforeAll
    public static void beforeAll() {
        try {
            palDAO = new PalDAO();
        }catch (Exception exception) {
            Assertions.fail("Se ha producido un error:"+exception.getMessage());
        }
    }

    @BeforeEach
    public void beforeEach() {
        try {
            pal = new Pal(palId, nombre,elemento,null,hp,atk,def,"213f");
            palDAO.updatePal(pal);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    @Test
    public void findAllPalTest() {
        try {
            List<Pal> lista = palDAO.findAllPal();
            Assertions.assertNotNull(lista);
            Assertions.assertTrue(lista.size()>0);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void findPalTest() {
        try {
            Pal palFind = palDAO.findPal(pal);
            Assertions.assertNotNull(palFind);
            Assertions.assertEquals(pal, palFind);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void updatePalTest() {
        try {
            Pal palFind = palDAO.findPal(pal);
            Assertions.assertNotNull(palFind);
            palFind.setNombre(nombreUpdate);
            palDAO.updatePal(pal);
            Pal findFindUpdate = palDAO.findPal(pal);
            Assertions.assertNotNull(findFindUpdate);
            Assertions.assertEquals(palFind, findFindUpdate);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @AfterEach
    public void afterEach()  {
        try {
            palDAO.deletePal(pal);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }
}
