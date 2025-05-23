package br.com.fiap.main;

import br.com.fiap.beans.Funcionario;
import br.com.fiap.beans.Cargo;
import br.com.fiap.bo.FuncionarioBO;

public class TesteFuncionario {
    public static void main(String[] args) {
        try {
            FuncionarioBO funcionarioBO = new FuncionarioBO();

            // Criando um funcionário
            Funcionario funcionario = new Funcionario();
            funcionario.setNome("João Silva");
            funcionario.setMatricula("12345");
            funcionario.setCpf("11122233344");

            Cargo cargo = new Cargo();
            cargo.setId(1);
            funcionario.setCargo(cargo);

            // Inserir
            System.out.println(funcionarioBO.inserirBO(funcionario));

            // Listar
            for (Funcionario f : funcionarioBO.selecionarBO()) {
                System.out.println(f);
            }

            // Atualizar
            funcionario.setNome("João S.");
            System.out.println(funcionarioBO.atualizarBO(funcionario));

            // Deletar
            System.out.println(funcionarioBO.deletarBO(funcionario));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
