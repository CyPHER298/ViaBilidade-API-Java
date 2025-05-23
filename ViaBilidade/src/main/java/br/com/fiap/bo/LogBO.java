package br.com.fiap.bo;

import br.com.fiap.beans.Log;
import br.com.fiap.dao.LogDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogBO {

    private LogDAO logDAO;

    public LogBO() throws SQLException, ClassNotFoundException {
        this.logDAO = new LogDAO();
    }

    // Selecionar todos os logs
    public List<Log> selecionarBO() {
        try {
            return logDAO.selecionar();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erro ao selecionar logs: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Inserir log
    public String inserirBO(Log log) {
        if (log.getTipo_acao() == null || log.getTipo_acao().trim().isEmpty()) {
            return "Erro: O tipo da ação não pode ser vazio.";
        }
        if (log.getDt_hora() == null || log.getDt_hora().trim().isEmpty()) {
            return "Erro: A data e hora não podem ser vazias.";
        }
        try {
            return logDAO.insertLog(log);
        } catch (SQLException | ClassNotFoundException e) {
            return "Erro ao inserir log: " + e.getMessage();
        }
    }

    // Atualizar log
    public String atualizarBO(Log log) {
        if (log.getId() <= 0) {
            return "Erro: ID inválido para atualização.";
        }
        if (log.getTipo_acao() == null || log.getTipo_acao().trim().isEmpty()) {
            return "Erro: O tipo da ação não pode ser vazio.";
        }
        if (log.getDt_hora() == null || log.getDt_hora().trim().isEmpty()) {
            return "Erro: A data e hora não podem ser vazias.";
        }
        try {
            return logDAO.updateLog(log);
        } catch (SQLException | ClassNotFoundException e) {
            return "Erro ao atualizar log: " + e.getMessage();
        }
    }

    // Deletar log
    public String deletarBO(Log log) {
        if (log.getId() <= 0) {
            return "Erro: ID inválido para deletar log.";
        }
        try {
            return logDAO.deleteLog(log);
        } catch (SQLException | ClassNotFoundException e) {
            return "Erro ao deletar log: " + e.getMessage();
        }
    }
}
