package es.ies.puerto.service;


import es.ies.puerto.modelo.entities.Arma;
import es.ies.puerto.repositories.ArmaRepository;
import es.ies.puerto.services.ArmaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ArmaServiceTest {
    ArmaService armaService;
    @Mock
    ArmaRepository armaRepositoryMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        armaService=new ArmaService();
        armaService.setArmaRepository(armaRepositoryMock);
    }

    @Test
    void findByIdTest(){
        when(armaRepositoryMock.findById(anyString())).thenReturn(new Arma());
        Response respuesta=armaService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    void findByIdNotFoundTest(){
        when(armaRepositoryMock.findById(anyString())).thenReturn(null);
        Response respuesta=armaService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }

    @Test
    void findAllTest(){
        when(armaRepositoryMock.findAll()).thenReturn(new ArrayList<>());
        Response respuesta = armaService.findAll();
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    public void saveTest(){
        when(armaRepositoryMock.save(any(Arma.class))).thenReturn(true);
        Response respuesta = armaService.save(new Arma());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(201,respuesta.getStatus());
    }

    @Test
    void saveDuplicateTest() {
        when(armaRepositoryMock.save(any(Arma.class))).thenReturn(false);
        Response respuesta = armaService.save(new Arma());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(304,respuesta.getStatus());
    }
    @Test
    void deleteOneOkTest() {
        when(armaRepositoryMock.delete(anyString())).thenReturn(true);
        Response respuesta = armaService.delete("3");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(204,respuesta.getStatus());
    }

    @Test
    void deleteOneErrorTest() {
        when(armaRepositoryMock.delete(anyString())).thenReturn(false);
        Response respuesta = armaService.delete("1k");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }
}
