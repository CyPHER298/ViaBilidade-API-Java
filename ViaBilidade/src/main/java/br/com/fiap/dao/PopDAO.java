package br.com.fiap.dao;

import br.com.fiap.beans.Pop;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PopDAO {

    public Connection minhaConexao;

    public PopDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }
    // String titulo, String dt_criacao, String dt_atualizacao
    public String inserirPop(Pop pop) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("insert into pop (titulo, dt_criacao, dt_atualizacao) values (?,?,?)");
        stmt.setString(1,pop.getTitulo());
        stmt.setString(2,pop.getDt_criacao());
        stmt.setString(3,pop.getDt_atualizacao());

        stmt.executeUpdate();
        stmt.close();
        return "POP cadastrado";
    }

    public String alterarPop(Pop pop) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE Pop SET titulo = ? WHERE id = ?");
        stmt.setString(1,pop.getTitulo());
        stmt.setString(2,pop.getId());
        stmt.executeUpdate();
        stmt.close();
        return "POP alterado";
    }

    public String excluirPop(Pop pop) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("DELETE FROM pop WHERE id = ?");
        stmt.setString(1,pop.getId());

        stmt.executeUpdate();
        stmt.close();
        return "POP excluido";
    }

    public List<Pop> selecionar() throws SQLException, ClassNotFoundException {
        List<Pop> listaPops = new ArrayList<Pop>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("SELECT * FROM pop");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Pop pop = new Pop();
            pop.setId(rs.getString("id"));
            pop.setTitulo(rs.getString("titulo"));
            pop.setDt_criacao(rs.getString("dt_criacao"));
            pop.setDt_atualizacao(rs.getString("dt_atualizacao"));
            listaPops.add(pop);
        }
        return listaPops;
    }

}
