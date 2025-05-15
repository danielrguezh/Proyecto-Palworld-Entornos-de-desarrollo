package es.ies.puerto.services;

import es.ies.puerto.modelo.entities.Arma;
import es.ies.puerto.modelo.entities.Personaje;
import es.ies.puerto.repositories.ArmaRepository;
import es.ies.puerto.repositories.PersonajeRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class PersonajeService {
    private PersonajeRepository personajeRepository;

    public void setPersonajeRepository(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public PersonajeService() {
        this.personajeRepository = new PersonajeRepository();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")String  id){
        Personaje personaje=personajeRepository.findById(id);
        if (personaje != null){
            return Response.ok(personaje).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    public Response findAll(){
        List<Personaje> personajes=personajeRepository.findAll();
        return Response.ok(personajes).build();
    }

    @POST
    public Response save(Personaje personaje){
        boolean resultado=personajeRepository.save(personaje);
        if (resultado){
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(String id){
        boolean deleted=personajeRepository.delete(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
