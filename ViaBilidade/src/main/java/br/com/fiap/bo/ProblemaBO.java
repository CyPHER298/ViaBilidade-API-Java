package br.com.fiap.bo;

import br.com.fiap.beans.Problema;
import br.com.fiap.dao.ProblemaDAO;

import java.sql.SQLException;
import java.util.List;

public class ProblemaBO {

    private ProblemaDAO dao;

    public ProblemaBO() throws SQLException, ClassNotFoundException {
        dao = new ProblemaDAO();
    }

    // Método para validar dados do Problema antes de inserir
    private void validarProblema(Problema problema) throws Exception {
        if (problema.getDescricao() == null || problema.getDescricao().trim().isEmpty()) {
            throw new Exception("Descrição do problema é obrigatória.");
        }
        if (problema.getData() == null || problema.getData().trim().isEmpty()) {
            throw new Exception("Data do problema é obrigatória.");
        }
        if (problema.getSetor_manutencao() == null || problema.getSetor_manutencao().getId() <= 0) {
            throw new Exception("Setor de manutenção inválido.");
        }
    }

    public String cadastrarProblema(Problema problema) throws Exception {
        try {
            validarProblema(problema);
            return dao.inserirProblema(problema);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao cadastrar problema: " + e.getMessage());
        }
    }

    public String atualizarProblema(Problema problema) throws Exception {
        try {
            validarProblema(problema);
            if (problema.getId() == null || problema.getId().trim().isEmpty()) {
                throw new Exception("ID do problema é obrigatório para atualização.");
            }
            return dao.atualizarProblema(problema);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao atualizar problema: " + e.getMessage());
        }
    }

    public String deletarProblema(Problema problema) throws Exception {
        try {
            if (problema.getId() == null || problema.getId().trim().isEmpty()) {
                throw new Exception("ID do problema é obrigatório para exclusão.");
            }
            return dao.deletarProblema(problema);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao deletar problema: " + e.getMessage());
        }
    }

    public List<Problema> listarProblemas() throws Exception {
        try {
            return dao.selecionar();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao listar problemas: " + e.getMessage());
        }
    }
}
