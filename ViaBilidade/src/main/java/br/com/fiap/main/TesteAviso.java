package br.com.fiap.main;

import br.com.fiap.beans.Aviso;
import br.com.fiap.bo.AvisoBO;

public class TesteAviso {
    public static void main(String[] args) {
        try {
            AvisoBO avisoBO = new AvisoBO();

            // Criando um aviso novo
            Aviso aviso = new Aviso();
            aviso.setTitulo("Manutenção programada");
            aviso.setMsg("Sistema fora do ar das 22h às 23h");
            aviso.setData("2025-05-21");

            // Inserir aviso
            String msgInserir = avisoBO.inserirBO(aviso);
            System.out.println(msgInserir);

            // Listar avisos
            System.out.println("Lista de avisos:");
            for (Aviso a : avisoBO.selecionarBO()) {
                System.out.println(a);
            }

            // Buscar um aviso por ID
            Aviso avisoBuscado = avisoBO.selecionarPorIdBO("1");
            if (avisoBuscado != null) {
                System.out.println("Aviso encontrado: " + avisoBuscado);
            } else {
                System.out.println("Aviso não encontrado.");
            }

            // Atualizar um aviso
            if (avisoBuscado != null) {
                avisoBuscado.setMsg("Manutenção estendida até 00h");
                String msgAtualizar = avisoBO.atualizarBO(avisoBuscado);
                System.out.println(msgAtualizar);
            }

            // Deletar um aviso
            String msgDeletar = avisoBO.deletarBO("1");
            System.out.println(msgDeletar);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
