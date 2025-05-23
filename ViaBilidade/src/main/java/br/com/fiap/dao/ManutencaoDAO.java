package br.com.fiap.dao;

import br.com.fiap.beans.Manutencao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {

    public Connection minhaConexao;

    public ManutencaoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String insertManutencao(Manutencao manutencao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("insert into Manutencao (dt_inicio, dt_termino, setor_manutencao_id, problema_id)" +
                        "VALUES (?, ?, ?, ?)");
        stmt.setString(1, manutencao.getDt_inicio());
        stmt.setString(2, manutencao.getDt_termino());
        stmt.setInt(3, manutencao.getSetor_manutencao().getId());
        stmt.setString(4, manutencao.getProblema().getId());
        stmt.executeUpdate();
        stmt.close();
        return "Manutenção cadastrada";
    }

    public String updateManutencao(Manutencao manutencao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE manutencao SET setor_manutencao_id = ?, problema_id = ? WHERE id = ?");
        stmt.setInt(1, manutencao.getSetor_manutencao().getId());
        stmt.setString(2, manutencao.getProblema().getId());
        stmt.setString(3, manutencao.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Manutenção atualizada";
    }

    public String deleteManutencao(Manutencao manutencao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("DELETE FROM manutencao WHERE id = ?");
        stmt.setString(1, manutencao.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Manutenção deletada";
    }

    public List<Manutencao> selecionar() throws SQLException {
        List<Manutencao> listaManutencao = new ArrayList<Manutencao>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("SELECT * FROM manutencao");
        while(stmt.execute()){
            Manutencao manutencao = new Manutencao();
            manutencao.getDt_inicio();
            manutencao.getDt_termino();
            manutencao.getSetor_manutencao();
            manutencao.getProblema();
            listaManutencao.add(manutencao);
        }
        return listaManutencao;
    }
}
