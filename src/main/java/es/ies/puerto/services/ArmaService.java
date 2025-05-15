package es.ies.puerto.services;


import es.ies.puerto.modelo.entities.Arma;
import es.ies.puerto.repositories.ArmaRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class ArmaService {
    private ArmaRepository armaRepository;

    public void setArmaRepository(ArmaRepository armaRepository) {
        this.armaRepository = armaRepository;
    }

    public ArmaService() {
        this.armaRepository = new ArmaRepository();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")String  id){
        Arma arma=armaRepository.findById(id);
        if (arma != null){
            return Response.ok(arma).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    public Response findAll(){
        List<Arma> armas=armaRepository.findAll();
        return Response.ok(armas).build();
    }

    @POST
    public Response save(Arma arma){
        boolean resultado=armaRepository.save(arma);
        if (resultado){
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(String id){
        boolean deleted=armaRepository.delete(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
