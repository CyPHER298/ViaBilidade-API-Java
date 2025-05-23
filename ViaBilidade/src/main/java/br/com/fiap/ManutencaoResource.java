package br.com.fiap;

import br.com.fiap.beans.Manutencao;
import br.com.fiap.bo.ManutencaoBO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/manutencoes")
public class ManutencaoResource {

    private ManutencaoBO manutencaoBO = new ManutencaoBO();

    public ManutencaoResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Manutencao> listaManutencao() throws SQLException, ClassNotFoundException {
        return (ArrayList<Manutencao>) manutencaoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirManutencao(Manutencao manutencao, @Context UriInfo uriInfo) throws SQLException {
        manutencaoBO.inserirBO(manutencao);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(manutencao.getId());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterarManutencao(Manutencao manutencao, @PathParam("id") Integer id) throws SQLException {
        manutencaoBO.atualizarBO(manutencao);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes
    public Response excluirManutencao(Manutencao manutencao, @PathParam("id") Integer id) throws SQLException {
        manutencaoBO.deletarBO(manutencao);
        return Response.ok().build();
    }

}
