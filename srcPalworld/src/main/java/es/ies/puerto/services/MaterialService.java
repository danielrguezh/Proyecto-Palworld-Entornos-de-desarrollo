package es.ies.puerto.services;

import es.ies.puerto.modelo.entities.HabilidadPal;
import es.ies.puerto.modelo.entities.Material;
import es.ies.puerto.repositories.HabilidadPalRepository;
import es.ies.puerto.repositories.MaterialRespository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class MaterialService {
    private MaterialRespository materialRespository;

    public void setMaterialRepository(MaterialRespository materialRespository) {
        this.materialRespository = materialRespository;
    }

    public MaterialService() {
        this.materialRespository = new MaterialRespository();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")String  id){
        Material material=materialRespository.findById(id);
        if (material != null){
            return Response.ok(material).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    public Response findAll(){
        List<Material> materiales=materialRespository.findAll();
        return Response.ok(materiales).build();
    }

    @POST
    public Response save(Material material){
        boolean resultado= materialRespository.save(material);
        if (resultado){
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(String id){
        boolean deleted=materialRespository.delete(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
