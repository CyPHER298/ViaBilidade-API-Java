package br.com.fiap.dao;

import br.com.fiap.beans.Problema;
import br.com.fiap.beans.Setor_Manutencao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemaDAO {

    public Connection minhaConexao;

    public ProblemaDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserirProblema(Problema problema) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("insert into problema (descricao, dt_problema, setor_manutencao_id)" +
                        "values (?,?,?)");
        stmt.setString(1, problema.getDescricao());
        stmt.setString(2, problema.getData());
        stmt.setInt(3, problema.getSetor_manutencao().getId());
        stmt.executeUpdate();
        stmt.close();
        return "Problema cadastrado";
    }

    public String atualizarProblema(Problema problema) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE problema SET descricao = ? WHERE id_problema = ?");
        stmt.setString(1, problema.getDescricao());
        stmt.setString(2, problema.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Problema atualizado";
    }

    public String deletarProblema(Problema problema) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("DELETE FROM problema WHERE id_problema = ?");
        stmt.setString(1, problema.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Problema deletado";
    }

    public List<Problema> selecionar() throws SQLException, ClassNotFoundException {
        List<Problema> listaProblema = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM problema");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Problema problema = new Problema();
            problema.setId(rs.getString("id_problema"));
            problema.setDescricao(rs.getString("descricao"));
            problema.setData(rs.getString("dt_problema"));  // corrigido aqui

            // Cria e seta o Setor_Manutencao
            Setor_Manutencao setor = new Setor_Manutencao();
            setor.setId(rs.getInt("setor_manutencao_id"));
            problema.setSetor_manutencao(setor);

            listaProblema.add(problema);
        }
        rs.close();
        stmt.close();
        return listaProblema;
    }


}
