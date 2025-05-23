package br.com.fiap;

import br.com.fiap.beans.Cargo;
import br.com.fiap.bo.CargoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/cargos")
public class CargoResource {
    private CargoBO cargoBO = new CargoBO();

    public CargoResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cargo> selectCargo() throws SQLException, ClassNotFoundException {
        return (ArrayList<Cargo>) cargoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirCargo(Cargo cargo, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        cargoBO.inserirBO(cargo);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(cargo.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarCargo(Cargo cargo, @PathParam("id") int id) throws SQLException, ClassNotFoundException {
        cargo.setId(id);
        cargoBO.atualizarBO(cargo);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarCargo(Cargo cargo, @PathParam("id") int id) throws SQLException, ClassNotFoundException {
        cargoBO.deletarBO(cargo);
        return Response.ok().build();
    }
}
