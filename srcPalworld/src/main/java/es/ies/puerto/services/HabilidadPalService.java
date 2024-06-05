package es.ies.puerto.services;



import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.repositories.HabilidadPalRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class HabilidadPalService {
    private HabilidadPalRepository habilidadPalRepository;

    public void setHabilidadPalRepository(HabilidadPalRepository habilidadPalRepository) {
        this.habilidadPalRepository = habilidadPalRepository;
    }

    public HabilidadPalService() {
        this.habilidadPalRepository = new HabilidadPalRepository();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")String  id){
        HabilidadPal habilidadPal=habilidadPalRepository.findById(id);
        if (habilidadPal != null){
            return Response.ok(habilidadPal).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    public Response findAll(){
        List<HabilidadPal> habilidades=habilidadPalRepository.findAll();
        return Response.ok(habilidades).build();
    }

    @POST
    public Response save(HabilidadPal habilidadPal){
        boolean resultado=habilidadPalRepository.save(habilidadPal);
        if (resultado){
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(String id){
        boolean deleted=habilidadPalRepository.delete(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
