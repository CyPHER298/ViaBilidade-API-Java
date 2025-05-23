package br.com.fiap.main;

import br.com.fiap.beans.Pop;
import br.com.fiap.bo.PopBO;

public class TestePop {
    public static void main(String[] args) {
        try {
            PopBO popBO = new PopBO();

            // Cadastrar um POP
            Pop pop = new Pop("Procedimento X", "2025-05-21", "2025-05-21");
            System.out.println(popBO.inserirBO(pop));

            // Listar POPs
            for (Pop p : popBO.selecionarBO()) {
                System.out.println(p);
            }

            // Alterar um POP
            pop.setId("1");  // supondo que o ID seja "1"
            pop.setTitulo("Procedimento Alterado");
            System.out.println(popBO.atualizarBO(pop));

            // Excluir um POP
            System.out.println(popBO.deletarBO(pop));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
