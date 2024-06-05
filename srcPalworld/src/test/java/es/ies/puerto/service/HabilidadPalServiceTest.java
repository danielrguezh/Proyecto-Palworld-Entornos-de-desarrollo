package es.ies.puerto.service;


import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.repositories.HabilidadPalRepository;
import es.ies.puerto.services.HabilidadPalService;
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

public class HabilidadPalServiceTest {
    HabilidadPalService habilidadPalService;
    @Mock
    HabilidadPalRepository habilidadPalRepositoryMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        habilidadPalService=new HabilidadPalService();
        habilidadPalService.setHabilidadPalRepository(habilidadPalRepositoryMock);
    }

    @Test
    void findByIdTest(){
        when(habilidadPalRepositoryMock.findById(anyString())).thenReturn(new HabilidadPal());
        Response respuesta=habilidadPalService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    void findByIdNotFoundTest(){
        when(habilidadPalRepositoryMock.findById(anyString())).thenReturn(null);
        Response respuesta=habilidadPalService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }

    @Test
    void findAllTest(){
        when(habilidadPalRepositoryMock.findAll()).thenReturn(new ArrayList<>());
        Response respuesta = habilidadPalService.findAll();
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    public void saveTest(){
        when(habilidadPalRepositoryMock.save(any(HabilidadPal.class))).thenReturn(true);
        Response respuesta = habilidadPalService.save(new HabilidadPal());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(201,respuesta.getStatus());
    }

    @Test
    void saveDuplicateTest() {
        when(habilidadPalRepositoryMock.save(any(HabilidadPal.class))).thenReturn(false);
        Response respuesta = habilidadPalService.save(new HabilidadPal());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(304,respuesta.getStatus());
    }
    @Test
    void deleteOneOkTest() {
        when(habilidadPalRepositoryMock.delete(anyString())).thenReturn(true);
        Response respuesta = habilidadPalService.delete("3");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(204,respuesta.getStatus());
    }

    @Test
    void deleteOneErrorTest() {
        when(habilidadPalRepositoryMock.delete(anyString())).thenReturn(false);
        Response respuesta = habilidadPalService.delete("1k");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }
}
