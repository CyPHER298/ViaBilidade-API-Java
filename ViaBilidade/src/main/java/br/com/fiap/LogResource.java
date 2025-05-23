package br.com.fiap;

import br.com.fiap.beans.Log;
import br.com.fiap.bo.LogBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/logs")
public class LogResource {

    private LogBO logBO = new LogBO();

    public LogResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Log> selecLogs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Log>) logBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirLog(Log log, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        logBO.inserirBO(log);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(log.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterarLog(Log log, @PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
        logBO.atualizarBO(log);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarLog(Log log, @PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
        logBO.deletarBO(log);
        return Response.ok().build();
    }


}
