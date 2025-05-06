package es.ies.puerto.modelo.dao;

import es.ies.puerto.modelo.entities.Arma;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * HAY QUE REINICIAR LA BASE DE DATOS ANTES DE EJECUTAR LOS TEST YA QUE LOS DATOS SE ALMACENAN
 */
class ArmaDAOTest {
    private ArmaDAO armaDAO;
    private List<Arma> armasCreadas; // Para llevar control

    @BeforeEach
    void setUp() {
        armaDAO = new ArmaDAO();
        armasCreadas = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        for (Arma arma : armasCreadas) {
            armaDAO.deleteArma(arma);
        }
    }

    @Test
    void crearArmaTest() {
        Arma arma = new Arma("AK-47", 30, 20, "pers1");
        assertTrue(armaDAO.crearArma(arma));
        armasCreadas.add(arma); // Registrar para limpiar luego
        assertFalse(armaDAO.crearArma(arma));
    }

    @Test
    void obtenerTodasLasArmasTest() {
        Arma arma1 = new Arma("M4", 25, 30, "pers2");
        Arma arma2 = new Arma("Pistola", 10, 15, "pers3");
        armaDAO.crearArma(arma1);
        armaDAO.crearArma(arma2);
        armasCreadas.add(arma1);
        armasCreadas.add(arma2);

        List<Arma> armas = armaDAO.findAllArma();
        assertTrue(armas.size() >= 2);
    }

    @Test
    void buscarArmaPorNombreTest() {
        Arma arma = new Arma("Sniper", 80, 5, "pers4");
        armaDAO.crearArma(arma);
        armasCreadas.add(arma);

        Arma encontrada = armaDAO.findArma(new Arma("Sniper", 0, 0, null));
        assertNotNull(encontrada);
        assertEquals(arma.getNombre(), encontrada.getNombre());

        assertNull(armaDAO.findArma(new Arma("NoExiste", 0, 0, null)));
    }

    @Test
    void actualizarArmaTest() {
        Arma arma = new Arma("Escopeta", 50, 2, "pers5");
        armaDAO.crearArma(arma);
        armasCreadas.add(arma);

        arma.setDanio(60);
        arma.setCargador(4);
        assertTrue(armaDAO.updateArma(arma));

        Arma actualizada = armaDAO.findArma(arma);
        assertEquals(60, actualizada.getDanio());
        assertEquals(4, actualizada.getCargador());
    }

    @Test
    void eliminarArmaTest() {
        Arma arma = new Arma("Borrar", 15, 10, "pers6");
        armaDAO.crearArma(arma);
        assertTrue(armaDAO.deleteArma(arma)); // Ya se borra aquí, no lo añadas a la lista

        assertNull(armaDAO.findArma(arma));
        assertFalse(armaDAO.deleteArma(new Arma("Inexistente", 0, 0, null)));
    }
}