package br.com.fiap;

import br.com.fiap.beans.Setor_Manutencao;
import br.com.fiap.bo.Setor_ManutencaoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/setoresManutencao")
public class SetorManutencaoResource {

    private Setor_ManutencaoBO setorManutencaoBO = new Setor_ManutencaoBO();

    public SetorManutencaoResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Setor_Manutencao> getSetorManutencao() throws Exception, SQLException {
        return (ArrayList<Setor_Manutencao>) setorManutencaoBO.listarSetores();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirSetorManutencao(Setor_Manutencao setorManutencao, @Context UriInfo uriInfo) throws Exception, SQLException {
        setorManutencaoBO.cadastrarSetor(setorManutencao);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(setorManutencao.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarSetorManutencao(Setor_Manutencao setorManutencao, @PathParam("id") int id) throws Exception, SQLException {
        setorManutencaoBO.alterarSetor(setorManutencao);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarSetorManutencao(Setor_Manutencao setorManutencao, @PathParam("id") int id) throws Exception, SQLException {
        setorManutencaoBO.excluirSetor(setorManutencao);
        return Response.ok().build();
    }

}
