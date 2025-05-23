package br.com.fiap.main;

import br.com.fiap.beans.Setor_Manutencao;
import br.com.fiap.bo.Setor_ManutencaoBO;

import java.util.List;

public class TesteSetor {
    public static void main(String[] args) {
        try {
            Setor_ManutencaoBO bo = new Setor_ManutencaoBO();

            Setor_Manutencao novoSetor = new Setor_Manutencao();
            novoSetor.setNome("Elétrica");
            System.out.println(bo.cadastrarSetor(novoSetor));

            List<Setor_Manutencao> setores = bo.listarSetores();
            for (Setor_Manutencao s : setores) {
                System.out.println(s.getId() + " - " + s.getNome());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
