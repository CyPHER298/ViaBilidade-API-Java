package br.com.fiap.bo;

import br.com.fiap.beans.Funcionario;
import br.com.fiap.dao.FuncionarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioBO {

    private FuncionarioDAO funcionarioDAO;

    public FuncionarioBO() throws SQLException, ClassNotFoundException {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    // Selecionar todos os funcionários
    public List<Funcionario> selecionarBO() {
        try {
            return funcionarioDAO.selecionar();
        } catch (SQLException e) {
            System.err.println("Erro ao selecionar funcionários: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Inserir funcionário
    public String inserirBO(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
            return "Erro: O nome do funcionário não pode ser vazio.";
        }
        if (funcionario.getMatricula() == null || funcionario.getMatricula().trim().isEmpty()) {
            return "Erro: A matrícula do funcionário não pode ser vazia.";
        }
        if (funcionario.getCpf() == null || funcionario.getCpf().trim().isEmpty()) {
            return "Erro: O CPF do funcionário não pode ser vazio.";
        }
        try {
            return funcionarioDAO.inserirFuncionario(funcionario);
        } catch (SQLException | ClassNotFoundException e) {
            return "Erro ao inserir funcionário: " + e.getMessage();
        }
    }

    // Atualizar funcionário
    public String atualizarBO(Funcionario funcionario) {
        if (funcionario.getCpf() == null || funcionario.getCpf().trim().isEmpty()) {
            return "Erro: CPF obrigatório para atualização.";
        }
        if (funcionario.getCargo() == null || funcionario.getCargo().getId() <= 0) {
            return "Erro: Cargo inválido para o funcionário.";
        }
        try {
            return funcionarioDAO.atualizarFuncionario(funcionario);
        } catch (SQLException e) {
            return "Erro ao atualizar funcionário: " + e.getMessage();
        }
    }

    // Deletar funcionário
    public String deletarBO(Funcionario funcionario) {
        if (funcionario.getCpf() == null || funcionario.getCpf().trim().isEmpty()) {
            return "Erro: CPF obrigatório para deletar funcionário.";
        }
        try {
            return funcionarioDAO.deletarFuncionario(funcionario);
        } catch (SQLException e) {
            return "Erro ao deletar funcionário: " + e.getMessage();
        }
    }
}
