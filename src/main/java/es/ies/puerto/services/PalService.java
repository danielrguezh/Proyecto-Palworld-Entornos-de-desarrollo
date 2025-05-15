package es.ies.puerto.services;



import es.ies.puerto.modelo.entities.Pal;
import es.ies.puerto.repositories.PalRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class PalService {
    private PalRepository palRepository;

    public void setPalRepository(PalRepository palRepository) {
        this.palRepository = palRepository;
    }

    public PalService() {
        this.palRepository = new PalRepository();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")String  id){
        Pal pal=palRepository.findById(id);
        if (pal != null){
            return Response.ok(Response.accepted()).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    public Response findAll(){
        List<Pal> pals=palRepository.findAll();
        return Response.ok(pals).build();
    }

    @POST
    public Response save(Pal pal){
        boolean resultado=palRepository.save(pal);
        if (resultado){
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(String id){
        boolean deleted=palRepository.delete(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
