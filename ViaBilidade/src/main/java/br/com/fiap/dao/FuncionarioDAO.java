package br.com.fiap.dao;

import br.com.fiap.beans.Cargo;
import br.com.fiap.beans.Funcionario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public Connection minhaConexao;

    public FuncionarioDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserirFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("insert into funcionario (matricula, nm_func, cpf, cargo_func) values (?, ?, ?, ?)");
        stmt.setString(1, funcionario.getMatricula());
        stmt.setString(2, funcionario.getNome());
        stmt.setString(3, funcionario.getCpf());
        return "Funcionario cadastrado";
    }

    public String atualizarFuncionario (Funcionario funcionario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE Funcionario SET matricula = ?, nm_func = ?, cargo_func = ? WHERE id = ?");
        stmt.setString(1, funcionario.getMatricula());
        stmt.setString(2, funcionario.getNome());
        stmt.setInt(3, funcionario.getCargo().getId());
        stmt.setString(4,funcionario.getCpf());

        stmt.execute();
        stmt.close();
        return "Funcionário atualizado.";
    }

    public String deletarFuncionario (Funcionario Funcionario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("DELETE FROM Funcionario WHERE cpf = ?");
        stmt.setString(1, Funcionario.getCpf());
        stmt.execute();
        stmt.close();
        return "Funcionario deletado.";
    }

    public List<Funcionario> selecionar() throws SQLException {
        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("SELECT * FROM Funcionario ORDER BY nm_func");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setMatricula(rs.getString("matricula"));
            funcionario.setNome(rs.getString("nm_func"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setCargo(new Cargo());
            funcionario.getCargo().setId(rs.getInt("cargo_func"));
            listaFuncionarios.add(funcionario);
        }
        return listaFuncionarios;
    }
}
