package br.com.fiap.bo;

import br.com.fiap.beans.Manutencao;
import br.com.fiap.dao.ManutencaoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoBO {

    private ManutencaoDAO manutencaoDAO;

    public ManutencaoBO() throws SQLException, ClassNotFoundException {
        this.manutencaoDAO = new ManutencaoDAO();
    }

    // Selecionar todas as manutenções
    public List<Manutencao> selecionarBO() {
        try {
            return manutencaoDAO.selecionar();
        } catch (SQLException e) {
            System.err.println("Erro ao selecionar manutenções: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Inserir manutenção
    public String inserirBO(Manutencao manutencao) {
        if (manutencao.getDt_inicio() == null || manutencao.getDt_inicio().trim().isEmpty()) {
            return "Erro: A data de início não pode ser vazia.";
        }
        if (manutencao.getDt_termino() == null || manutencao.getDt_termino().trim().isEmpty()) {
            return "Erro: A data de término não pode ser vazia.";
        }
        if (manutencao.getSetor_manutencao() == null) {
            return "Erro: O setor de manutenção deve ser informado.";
        }
        if (manutencao.getProblema() == null) {
            return "Erro: O problema associado deve ser informado.";
        }
        try {
            return manutencaoDAO.insertManutencao(manutencao);
        } catch (SQLException e) {
            return "Erro ao inserir manutenção: " + e.getMessage();
        }
    }

    // Atualizar manutenção
    public String atualizarBO(Manutencao manutencao) {
        if (manutencao.getId() == null || manutencao.getId().trim().isEmpty()) {
            return "Erro: ID inválido para atualização.";
        }
        if (manutencao.getSetor_manutencao() == null) {
            return "Erro: O setor de manutenção deve ser informado.";
        }
        if (manutencao.getProblema() == null) {
            return "Erro: O problema associado deve ser informado.";
        }
        try {
            return manutencaoDAO.updateManutencao(manutencao);
        } catch (SQLException e) {
            return "Erro ao atualizar manutenção: " + e.getMessage();
        }
    }

    // Deletar manutenção
    public String deletarBO(Manutencao manutencao) {
        if (manutencao.getId() == null || manutencao.getId().trim().isEmpty()) {
            return "Erro: ID inválido para deletar manutenção.";
        }
        try {
            return manutencaoDAO.deleteManutencao(manutencao);
        } catch (SQLException e) {
            return "Erro ao deletar manutenção: " + e.getMessage();
        }
    }
}
