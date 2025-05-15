package es.ies.puerto.service;

import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.modelo.entities.Material;
import es.ies.puerto.repositories.HabilidadPalRepository;
import es.ies.puerto.repositories.MaterialRespository;
import es.ies.puerto.services.HabilidadPalService;
import es.ies.puerto.services.MaterialService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class MaterialServiceTest {
    MaterialService materialService;
    @Mock
    MaterialRespository materialRespositoryMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        materialService=new MaterialService();
        materialService.setMaterialRepository(materialRespositoryMock);
    }

    @Test
    void findByIdTest(){
        when(materialRespositoryMock.findById(anyString())).thenReturn(new Material());
        Response respuesta=materialService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    void findByIdNotFoundTest(){
        when(materialRespositoryMock.findById(anyString())).thenReturn(null);
        Response respuesta=materialService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }

    @Test
    void findAllTest(){
        when(materialRespositoryMock.findAll()).thenReturn(new ArrayList<>());
        Response respuesta = materialService.findAll();
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    public void saveTest(){
        when(materialRespositoryMock.save(any(Material.class))).thenReturn(true);
        Response respuesta = materialService.save(new Material());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(201,respuesta.getStatus());
    }

    @Test
    void saveDuplicateTest() {
        when(materialRespositoryMock.save(any(Material.class))).thenReturn(false);
        Response respuesta = materialService.save(new Material());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(304,respuesta.getStatus());
    }
    @Test
    void deleteOneOkTest() {
        when(materialRespositoryMock.delete(anyString())).thenReturn(true);
        Response respuesta = materialService.delete("3");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(204,respuesta.getStatus());
    }

    @Test
    void deleteOneErrorTest() {
        when(materialRespositoryMock.delete(anyString())).thenReturn(false);
        Response respuesta = materialService.delete("1k");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404, respuesta.getStatus());
    }
}
