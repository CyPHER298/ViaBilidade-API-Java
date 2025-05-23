package br.com.fiap;

import br.com.fiap.beans.Aviso;
import br.com.fiap.bo.AvisoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/avisos")
public class AvisoResource {

    private AvisoBO avisoBO = new AvisoBO();

    public AvisoResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Aviso> selectAviso() throws SQLException, ClassNotFoundException {
        return (ArrayList<Aviso>) avisoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirAviso(Aviso aviso, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        avisoBO.inserirBO(aviso);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(aviso.getId());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarAviso(Aviso aviso, @PathParam("id") String id) throws SQLException, ClassNotFoundException {
        aviso.setId(id);  // Garantir que o aviso tenha o ID correto.
        avisoBO.atualizarBO(aviso);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarAviso(@PathParam("id") String id) throws SQLException, ClassNotFoundException {
        avisoBO.deletarBO(id);
        return Response.ok().build();
    }
}
