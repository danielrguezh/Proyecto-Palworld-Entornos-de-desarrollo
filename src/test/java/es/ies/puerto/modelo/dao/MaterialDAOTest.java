package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.modelo.entities.Material;
import org.junit.jupiter.api.*;

import java.util.Set;

public class MaterialDAOTest {
    static MaterialDAO materialDAO;
    final String nombre="nombre";
    final int cantidad=33;
    final int cantidadUpdate=55;
    Material material;

    @BeforeAll
    public static void beforeAll() {
        try {
            materialDAO = new MaterialDAO();
        }catch (Exception exception) {
            Assertions.fail("Se ha producido un error:"+exception.getMessage());
        }
    }

    @BeforeEach
    public void beforeEach() {
        try {
            material = new Material(nombre,cantidad,"1");
            materialDAO.updateMaterial(material);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    @Test
    public void findAllMaterialTest() {
        try {
            Set<Material> lista = materialDAO.findAllMaterial();
            Assertions.assertNotNull(lista);
            Assertions.assertTrue(lista.size()>0);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void findMaterialTest() {
        try {
            Material materialFind = materialDAO.findMaterial(material);
            Assertions.assertNotNull(materialFind);
            Assertions.assertEquals(material, materialFind);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void updateMaterialTest() {
        try {
            Material materialFind = materialDAO.findMaterial(material);
            Assertions.assertNotNull(materialFind);
            materialFind.setCantidad(cantidadUpdate);
            materialDAO.updateMaterial(materialFind);
            Material materialFindUpdate = materialDAO.findMaterial(material);
            Assertions.assertNotNull(materialFindUpdate);
            Assertions.assertEquals(materialFind, materialFindUpdate);
            Assertions.assertEquals(materialFind.getCantidad(), materialFindUpdate.getCantidad());

        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @AfterEach
    public void afterEach()  {
        try {
            materialDAO.deleteMaterial(material);
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }
}
