package br.com.fiap.bo;

import br.com.fiap.beans.Aviso;
import br.com.fiap.dao.AvisoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AvisoBO {

    private AvisoDAO avisoDAO;

    public AvisoBO() throws ClassNotFoundException, SQLException {
        this.avisoDAO = new AvisoDAO();
    }

    // Selecionar todos
    public ArrayList<Aviso> selecionarBO() {
        try {
            return avisoDAO.selecionar();
        } catch (SQLException e) {
            System.err.println("Erro ao selecionar avisos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Selecionar por ID
    public Aviso selecionarPorIdBO(String id) {
        try {
            return avisoDAO.selecionarPorId(id);
        } catch (SQLException e) {
            System.err.println("Erro ao buscar aviso por ID: " + e.getMessage());
            return null;
        }
    }

    // Inserir
    public String inserirBO(Aviso aviso) {
        // Exemplo de regra de negócio:
        if (aviso.getTitulo() == null || aviso.getTitulo().isEmpty()) {
            return "Erro: Título do aviso não pode ser vazio.";
        }
        try {
            return avisoDAO.inserirAviso(aviso);
        } catch (SQLException e) {
            return "Erro ao inserir aviso: " + e.getMessage();
        }
    }

    // Atualizar
    public String atualizarBO(Aviso aviso) {
        // Exemplo de regra de negócio:
        if (aviso.getId() == null || aviso.getId().isEmpty()) {
            return "Erro: ID do aviso é obrigatório para atualização.";
        }
        try {
            return avisoDAO.atualizarAviso(aviso);
        } catch (SQLException e) {
            return "Erro ao atualizar aviso: " + e.getMessage();
        }
    }

    // Deletar
    public String deletarBO(String id) {
        if (id == null || id.isEmpty()) {
            return "Erro: ID do aviso é obrigatório para exclusão.";
        }
        try {
            return avisoDAO.deletarAviso(id);
        } catch (SQLException e) {
            return "Erro ao deletar aviso: " + e.getMessage();
        }
    }
}
