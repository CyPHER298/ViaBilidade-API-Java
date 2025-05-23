package br.com.fiap;

import br.com.fiap.beans.Funcionario;
import br.com.fiap.bo.FuncionarioBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/funcionarios")
public class FuncionarioResource {

    private FuncionarioBO funcionarioBO = new FuncionarioBO();

    public FuncionarioResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Funcionario> selectFuncionarios() throws SQLException , ClassNotFoundException {
        return (ArrayList<Funcionario>) funcionarioBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirFuncionario(Funcionario funcionario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        funcionarioBO.inserirBO(funcionario);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(funcionario.getCpf());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarFuncionario(Funcionario funcionario, @PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
        funcionarioBO.atualizarBO(funcionario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes
    public Response deletarFuncionario(Funcionario funcionario, @PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
        funcionarioBO.deletarBO(funcionario);
        return Response.ok().build();
    }
}
