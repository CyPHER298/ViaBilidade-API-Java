package br.com.fiap.bo;

import br.com.fiap.beans.Pop;
import br.com.fiap.dao.PopDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PopBO {

    private PopDAO popDAO;

    public PopBO() throws SQLException, ClassNotFoundException {
        this.popDAO = new PopDAO();
    }

    public List<Pop> selecionarBO() {
        try {
            return popDAO.selecionar();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erro ao selecionar POPs: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public String inserirBO(Pop pop) {
        if (pop.getTitulo() == null || pop.getTitulo().trim().isEmpty()) {
            return "Erro: O título do POP não pode estar vazio.";
        }
        if (pop.getDt_criacao() == null || pop.getDt_criacao().trim().isEmpty()) {
            return "Erro: A data de criação não pode estar vazia.";
        }
        if (pop.getDt_atualizacao() == null || pop.getDt_atualizacao().trim().isEmpty()) {
            return "Erro: A data de atualização não pode estar vazia.";
        }
        try {
            return popDAO.inserirPop(pop);
        } catch (SQLException | ClassNotFoundException e) {
            return "Erro ao inserir POP: " + e.getMessage();
        }
    }

    public String atualizarBO(Pop pop) {
        if (pop.getId() == null || pop.getId().trim().isEmpty()) {
            return "Erro: ID inválido para atualização do POP.";
        }
        if (pop.getTitulo() == null || pop.getTitulo().trim().isEmpty()) {
            return "Erro: O título do POP não pode estar vazio.";
        }
        try {
            return popDAO.alterarPop(pop);
        } catch (SQLException | ClassNotFoundException e) {
            return "Erro ao atualizar POP: " + e.getMessage();
        }
    }

    public String deletarBO(Pop pop) {
        if (pop.getId() == null || pop.getId().trim().isEmpty()) {
            return "Erro: ID inválido para deletar POP.";
        }
        try {
            return popDAO.excluirPop(pop);
        } catch (SQLException | ClassNotFoundException e) {
            return "Erro ao deletar POP: " + e.getMessage();
        }
    }
}
