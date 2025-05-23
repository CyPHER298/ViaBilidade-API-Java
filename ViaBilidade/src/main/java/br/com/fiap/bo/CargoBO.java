package br.com.fiap.bo;

import br.com.fiap.beans.Cargo;
import br.com.fiap.dao.CargoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoBO {

    private CargoDAO cargoDAO;

    public CargoBO() throws ClassNotFoundException, SQLException {
        this.cargoDAO = new CargoDAO();
    }

    // Selecionar todos os cargos
    public List<Cargo> selecionarBO() {
        try {
            return cargoDAO.selecionar();
        } catch (SQLException e) {
            System.err.println("Erro ao selecionar cargos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Inserir cargo
    public String inserirBO(Cargo cargo) {
        if (cargo.getNm_cargo() == null || cargo.getNm_cargo().trim().isEmpty()) {
            return "Erro: O nome do cargo não pode ser vazio.";
        }
        if (cargo.getLvl_cargo() <= 0) {
            return "Erro: O nível do cargo deve ser maior que zero.";
        }
        try {
            return cargoDAO.inserirCargo(cargo);
        } catch (SQLException e) {
            return "Erro ao inserir cargo: " + e.getMessage();
        }
    }

    // Atualizar cargo
    public String atualizarBO(Cargo cargo) {
        if (cargo.getId() <= 0) {
            return "Erro: ID inválido para atualização.";
        }
        try {
            return cargoDAO.atualizarCargo(cargo);
        } catch (SQLException e) {
            return "Erro ao atualizar cargo: " + e.getMessage();
        }
    }

    // Deletar cargo
    public String deletarBO(Cargo cargo) {
        if (cargo.getNm_cargo() == null || cargo.getNm_cargo().trim().isEmpty()) {
            return "Erro: O nome do cargo é necessário para deletar.";
        }
        try {
            return cargoDAO.deletarCargo(cargo);
        } catch (SQLException e) {
            return "Erro ao deletar cargo: " + e.getMessage();
        }
    }
}
