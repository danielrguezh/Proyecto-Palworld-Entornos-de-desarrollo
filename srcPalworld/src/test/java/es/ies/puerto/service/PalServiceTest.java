package es.ies.puerto.service;


import es.ies.puerto.modelo.entities.Pal;
import es.ies.puerto.repositories.PalRepository;
import es.ies.puerto.services.PalService;
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

public class PalServiceTest {
    PalService palService;
    @Mock
    PalRepository palRepositoryMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        palService=new PalService();
        palService.setPalRepository(palRepositoryMock);
    }

    @Test
    void findByIdTest(){
        when(palRepositoryMock.findById(anyString())).thenReturn(new Pal());
        Response respuesta=palService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    void findByIdNotFoundTest(){
        when(palRepositoryMock.findById(anyString())).thenReturn(null);
        Response respuesta=palService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }

    @Test
    void findAllTest(){
        when(palRepositoryMock.findAll()).thenReturn(new ArrayList<>());
        Response respuesta = palService.findAll();
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    public void saveTest(){
        when(palRepositoryMock.save(any(Pal.class))).thenReturn(true);
        Response respuesta = palService.save(new Pal());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(201,respuesta.getStatus());
    }

    @Test
    void saveDuplicateTest() {
        when(palRepositoryMock.save(any(Pal.class))).thenReturn(false);
        Response respuesta = palService.save(new Pal());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(304,respuesta.getStatus());
    }
    @Test
    void deleteOneOkTest() {
        when(palRepositoryMock.delete(anyString())).thenReturn(true);
        Response respuesta = palService.delete("3");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(204,respuesta.getStatus());
    }

    @Test
    void deleteOneErrorTest() {
        when(palRepositoryMock.delete(anyString())).thenReturn(false);
        Response respuesta = palService.delete("1k");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }
}
