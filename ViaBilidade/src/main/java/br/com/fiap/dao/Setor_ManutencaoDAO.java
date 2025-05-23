package br.com.fiap.dao;

import br.com.fiap.beans.Setor_Manutencao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Setor_ManutencaoDAO {

    public Connection minhaConexao;

    public Setor_ManutencaoDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserirSetor(Setor_Manutencao setor) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO setor_manutencao (nm_setor) VALUES (?)"
        );
        stmt.setString(1, setor.getNome());
        stmt.executeUpdate();
        stmt.close();
        return "Setor de Manutenção cadastrado";
    }

    public String alterarSetor(Setor_Manutencao setor) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE setor_manutencao SET nm_setor = ? WHERE id_setor = ?"
        );
        stmt.setString(1, setor.getNome());
        stmt.setInt(2, setor.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Setor alterado";
    }

    public String excluirSetor(Setor_Manutencao setor) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM setor_manutencao WHERE id_setor = ?"
        );
        stmt.setInt(1, setor.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Setor excluido";
    }

    public List<Setor_Manutencao> selecionar() throws SQLException {
        List<Setor_Manutencao> listaSetor = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM setor_manutencao"
        );
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Setor_Manutencao setor = new Setor_Manutencao();
            setor.setId(rs.getInt("id_setor"));
            setor.setNome(rs.getString("nm_setor"));
            listaSetor.add(setor);
        }
        rs.close();
        stmt.close();
        return listaSetor;
    }
}
