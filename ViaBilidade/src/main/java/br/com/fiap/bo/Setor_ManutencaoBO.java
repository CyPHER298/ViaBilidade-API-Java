package br.com.fiap.bo;

import br.com.fiap.beans.Setor_Manutencao;
import br.com.fiap.dao.Setor_ManutencaoDAO;

import java.sql.SQLException;
import java.util.List;

public class Setor_ManutencaoBO {

    private Setor_ManutencaoDAO setorDao;

    public Setor_ManutencaoBO() throws ClassNotFoundException, SQLException {
        this.setorDao = new Setor_ManutencaoDAO();
    }

    // Método para validar e inserir setor
    public String cadastrarSetor(Setor_Manutencao setor) throws SQLException {
        if (setor.getNome() == null || setor.getNome().trim().isEmpty()) {
            return "Erro: O nome do setor não pode ser vazio.";
        }
        return setorDao.inserirSetor(setor);
    }

    // Método para validar e alterar setor
    public String alterarSetor(Setor_Manutencao setor) throws SQLException {
        if (setor.getId() <= 0) {
            return "Erro: ID inválido para alteração.";
        }
        if (setor.getNome() == null || setor.getNome().trim().isEmpty()) {
            return "Erro: O nome do setor não pode ser vazio.";
        }
        return setorDao.alterarSetor(setor);
    }

    // Método para validar e excluir setor
    public String excluirSetor(Setor_Manutencao setor) throws SQLException {
        if (setor.getId() <= 0) {
            return "Erro: ID inválido para exclusão.";
        }
        return setorDao.excluirSetor(setor);
    }

    // Método para listar todos setores
    public List<Setor_Manutencao> listarSetores() throws SQLException {
        return setorDao.selecionar();
    }
}
