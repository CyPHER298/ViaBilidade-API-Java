package br.com.fiap.main;

import br.com.fiap.beans.Log;
import br.com.fiap.bo.LogBO;

public class TesteLog {
    public static void main(String[] args) {
        try {
            LogBO logBO = new LogBO();

            // Criando um log
            Log log = new Log();
            log.setTipo_acao("Inserção");
            log.setDt_hora("2025-05-21 14:30:00");

            // Inserir
            System.out.println(logBO.inserirBO(log));

            // Listar
            for (Log l : logBO.selecionarBO()) {
                System.out.println(l);
            }

            // Atualizar
            log.setId(1);  // Defina o ID correto
            log.setTipo_acao("Atualização");
            System.out.println(logBO.atualizarBO(log));

            // Deletar
            System.out.println(logBO.deletarBO(log));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
