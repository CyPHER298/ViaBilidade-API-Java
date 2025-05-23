package br.com.fiap;

import br.com.fiap.beans.Pop;
import br.com.fiap.bo.PopBO;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;
import jakarta.ws.rs.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/pops")
public class PopResource {

    private PopBO popBO = new PopBO();

    public PopResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Pop> getPops() throws SQLException, ClassNotFoundException {
        return (ArrayList<Pop>) popBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirPop(Pop pop, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        popBO.inserirBO(pop);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(pop.getId());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterarPop(Pop pop, @PathParam("id") String id) throws SQLException, ClassNotFoundException {
        popBO.atualizarBO(pop);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarPop(Pop pop, @PathParam("id") String id) throws SQLException, ClassNotFoundException {
        popBO.deletarBO(pop);
        return Response.ok().build();
    }
}
