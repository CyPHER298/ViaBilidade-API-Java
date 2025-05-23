package br.com.fiap.dao;

import br.com.fiap.beans.Aviso;
import br.com.fiap.beans.Cargo;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {

    public Connection minhaConexao;

    public CargoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    //String titulo, String msg, String data, String status
    public String inserirCargo (Cargo cargo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("insert into cargo (nm_cargo, lvl_cargo) values (?,?)");
        stmt.setString(1, cargo.getNm_cargo());
        stmt.setInt(2, cargo.getLvl_cargo());
        return "Cargo cadastrado.";
    }

    public String atualizarCargo (Cargo cargo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE Cargo SET nm_cargo = ?, lvl_cargo = ? WHERE id = ?");
        stmt.setString(1, cargo.getNm_cargo());
        stmt.setInt(2, cargo.getLvl_cargo());
        stmt.setInt(3, cargo.getId());

        stmt.execute();
        stmt.close();
        return "Cargo atualizado.";
    }

    public String deletarCargo (Cargo cargo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("DELETE FROM cargo WHERE nm_cargo = ?");
        stmt.setString(1, cargo.getNm_cargo());
        stmt.execute();
        stmt.close();
        return "Cargo deletado.";
    }

    public List<Cargo> selecionar () throws SQLException {
        List<Cargo> listaCargos = new ArrayList<Cargo>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("SELECT * FROM cargo ORDER BY lvl_cargo");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cargo cargo = new Cargo();
            cargo.setNm_cargo(rs.getString("nm_cargo"));
            cargo.setLvl_cargo(rs.getInt("lvl_cargo"));
            listaCargos.add(cargo);
        }
        return listaCargos;
    }
}
