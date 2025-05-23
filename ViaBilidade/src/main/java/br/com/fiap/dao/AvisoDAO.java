package br.com.fiap.dao;

import br.com.fiap.beans.Aviso;
import br.com.fiap.beans.Setor_Manutencao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvisoDAO {

    public Connection minhaConexao;

    public AvisoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserirAviso(Aviso aviso) throws SQLException {
        String sql = "INSERT INTO aviso (id_aviso, titulo, msg, data, setor_manutencao_id) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, aviso.getId());
        stmt.setString(2, aviso.getTitulo());
        stmt.setString(3, aviso.getMsg());
        stmt.setString(4, aviso.getData());
        stmt.setInt(5, aviso.getSetor_manutencao().getId());

        stmt.executeUpdate();
        stmt.close();
        return "Aviso cadastrado com sucesso.";
    }

    // Deletar (por id)
    public String deletarAviso(String id) throws SQLException {
        String sql = "DELETE FROM aviso WHERE id = ?";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, id);

        int rows = stmt.executeUpdate();
        stmt.close();

        if (rows > 0) {
            return "Aviso removido com sucesso.";
        } else {
            return "Nenhum aviso encontrado com esse ID.";
        }
    }

    // Atualizar (por id)
    public String atualizarAviso(Aviso aviso) throws SQLException {
        String sql = "UPDATE aviso SET titulo = ?, msg = ?, data = ?, status = ?, setor_manutencao_id = ? WHERE id = ?";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, aviso.getTitulo());
        stmt.setString(2, aviso.getMsg());
        stmt.setString(3, aviso.getData());
        stmt.setString(4, aviso.getStatus());
        stmt.setInt(5, aviso.getSetor_manutencao().getId());
        stmt.setString(6, aviso.getId());

        int rows = stmt.executeUpdate();
        stmt.close();

        if (rows > 0) {
            return "Aviso atualizado com sucesso.";
        } else {
            return "Nenhum aviso encontrado com esse ID.";
        }
    }

    // Selecionar todos
    public ArrayList<Aviso> selecionar() throws SQLException {
        ArrayList<Aviso> listarAvisos = new ArrayList<>();
        String sql = "SELECT * FROM aviso";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Aviso aviso = new Aviso();
            aviso.setId(rs.getString("id"));
            aviso.setTitulo(rs.getString("titulo"));
            aviso.setMsg(rs.getString("msg"));
            aviso.setData(rs.getString("data"));
            aviso.setStatus(rs.getString("status"));

            // Evitar NullPointerException
            Setor_Manutencao setor = new Setor_Manutencao();
            setor.setId(rs.getInt("setor_manutencao_id"));
            aviso.setSetor_manutencao(setor);

            listarAvisos.add(aviso);
        }
        rs.close();
        stmt.close();

        return listarAvisos;
    }

    // Selecionar por ID
    public Aviso selecionarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM aviso WHERE id = ?";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, id);

        ResultSet rs = stmt.executeQuery();

        Aviso aviso = null;

        if (rs.next()) {
            aviso = new Aviso();
            aviso.setId(rs.getString("id"));
            aviso.setTitulo(rs.getString("titulo"));
            aviso.setMsg(rs.getString("msg"));
            aviso.setData(rs.getString("data"));
            aviso.setStatus(rs.getString("status"));

            Setor_Manutencao setor = new Setor_Manutencao();
            setor.setId(rs.getInt("setor_manutencao_id"));
            aviso.setSetor_manutencao(setor);
        }

        rs.close();
        stmt.close();

        return aviso;
    }
}
