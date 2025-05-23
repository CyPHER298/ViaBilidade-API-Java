package br.com.fiap;

import br.com.fiap.beans.Problema;
import br.com.fiap.bo.ProblemaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/problemas")
public class ProblemaResource {

    private ProblemaBO problemaBO = new ProblemaBO();

    public ProblemaResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Problema> selectProblemas() throws Exception, SQLException {
        return (ArrayList<Problema>) problemaBO.listarProblemas();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirProblema(Problema problema, @Context UriInfo uriInfo) throws Exception, SQLException {
        problemaBO.cadastrarProblema(problema);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(problema.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarProblema(Problema problema, @PathParam("id") String id ) throws Exception, SQLException {
        problemaBO.atualizarProblema(problema);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarProblema(Problema problema, @PathParam("id") String id) throws Exception, SQLException {
        problemaBO.deletarProblema(problema);
        return Response.ok().build();
    }
}
