package es.ies.puerto.service;


import es.ies.puerto.modelo.entities.Personaje;
import es.ies.puerto.repositories.PersonajeRepository;

import es.ies.puerto.services.PersonajeService;
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

public class PersonajeServiceTest {
    PersonajeService personajeService;
    @Mock
    PersonajeRepository personajeRepositoryMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        personajeService=new PersonajeService();
        personajeService.setPersonajeRepository(personajeRepositoryMock);
    }

    @Test
    void findByIdTest(){
        when(personajeRepositoryMock.findById(anyString())).thenReturn(new Personaje());
        Response respuesta=personajeService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    void findByIdNotFoundTest(){
        when(personajeRepositoryMock.findById(anyString())).thenReturn(null);
        Response respuesta=personajeService.findById("1");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }

    @Test
    void findAllTest(){
        when(personajeRepositoryMock.findAll()).thenReturn(new ArrayList<>());
        Response respuesta = personajeService.findAll();
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(200,respuesta.getStatus());
    }

    @Test
    public void saveTest(){
        when(personajeRepositoryMock.save(any(Personaje.class))).thenReturn(true);
        Response respuesta = personajeService.save(new Personaje());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(201,respuesta.getStatus());
    }

    @Test
    void saveDuplicateTest() {
        when(personajeRepositoryMock.save(any(Personaje.class))).thenReturn(false);
        Response respuesta = personajeService.save(new Personaje());
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(304,respuesta.getStatus());
    }
    @Test
    void deleteOneOkTest() {
        when(personajeRepositoryMock.delete(anyString())).thenReturn(true);
        Response respuesta = personajeService.delete("3");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(204,respuesta.getStatus());
    }

    @Test
    void deleteOneErrorTest() {
        when(personajeRepositoryMock.delete(anyString())).thenReturn(false);
        Response respuesta = personajeService.delete("1k");
        Assertions.assertNotNull(respuesta);
        Assertions.assertEquals(404,respuesta.getStatus());
    }
}
