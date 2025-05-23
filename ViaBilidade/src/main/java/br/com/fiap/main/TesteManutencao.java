package br.com.fiap.main;

import br.com.fiap.beans.Manutencao;
import br.com.fiap.beans.Problema;
import br.com.fiap.beans.Setor_Manutencao;
import br.com.fiap.bo.ManutencaoBO;

public class TesteManutencao {
    public static void main(String[] args) {
        try {
            ManutencaoBO manutencaoBO = new ManutencaoBO();

            // Criando uma manutenção
            Manutencao manutencao = new Manutencao();
            manutencao.setDt_inicio("2025-05-21 08:00:00");
            manutencao.setDt_termino("2025-05-21 10:30:00");

            Setor_Manutencao setor = new Setor_Manutencao();
            setor.setId(1);
            manutencao.setSetor_manutencao(setor);

            Problema problema = new Problema();
            problema.setId(String.valueOf(1));
            manutencao.setProblema(problema);

            // Inserir
            System.out.println(manutencaoBO.inserirBO(manutencao));

            // Listar
            for (Manutencao m : manutencaoBO.selecionarBO()) {
                System.out.println(m);
            }

            // Atualizar
            manutencao.setId("1");  // ID correto
            manutencao.setDt_termino("2025-05-21 11:00:00");
            System.out.println(manutencaoBO.atualizarBO(manutencao));

            // Deletar
            System.out.println(manutencaoBO.deletarBO(manutencao));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
