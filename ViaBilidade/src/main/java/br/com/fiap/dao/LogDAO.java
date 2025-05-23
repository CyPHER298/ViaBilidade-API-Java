package br.com.fiap.dao;

import br.com.fiap.beans.Log;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDAO {

    public Connection minhaConexao;

    public LogDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String insertLog (Log log) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("insert into logs (tipo_acao, dt_hora) values (?, ?)");
        stmt.setString(1, log.getTipo_acao());
        stmt.setString(2, log.getDt_hora());
        stmt.executeUpdate();
        stmt.close();
        return "Log cadastrado";
    }

    public String updateLog (Log log) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE logs SET tipo_acao = ?, dt_hora = ? WHERE id = ?");
        stmt.setString(1, log.getTipo_acao());
        stmt.setString(2, log.getDt_hora());
        stmt.setInt(3, log.getId());
        stmt.executeUpdate();
        stmt.close();

        return "Log atualizado";
    }

    public String deleteLog (Log log) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
            ("DELETE FROM logs WHERE id = ?");
        stmt.setInt(1, log.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Log deletado";
    }

    public List<Log> selecionar () throws SQLException, ClassNotFoundException {
        List<Log> listaLogs = new ArrayList<Log>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("SELECT * FROM logs");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Log log = new Log();
            log.setId(rs.getInt("id"));
            log.setTipo_acao(rs.getString("tipo_acao"));
            log.setDt_hora(rs.getString("dt_hora"));
            listaLogs.add(log);
        }
        return listaLogs;
    }

}
