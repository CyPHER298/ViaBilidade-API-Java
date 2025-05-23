package br.com.fiap.main;

import br.com.fiap.beans.Problema;
import br.com.fiap.beans.Setor_Manutencao;
import br.com.fiap.bo.ProblemaBO;

public class TesteProblema {
    public static void main(String[] args) {
        try {
            ProblemaBO problemaBO = new ProblemaBO();

            // Criar um problema
            Problema p = new Problema();
            p.setDescricao("Falha no motor");
            p.setData("2025-05-21");
            Setor_Manutencao setor = new Setor_Manutencao();
            setor.setId(1);  // Exemplo de setor válido
            p.setSetor_manutencao(setor);

            // Cadastrar
            System.out.println(problemaBO.cadastrarProblema(p));

            // Listar
            for (Problema prob : problemaBO.listarProblemas()) {
                System.out.println(prob);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
