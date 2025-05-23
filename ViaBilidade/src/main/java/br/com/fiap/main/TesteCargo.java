package br.com.fiap.main;

import br.com.fiap.beans.Cargo;
import br.com.fiap.bo.CargoBO;

public class TesteCargo {
    public static void main(String[] args) {
        try {
            CargoBO cargoBO = new CargoBO();

            // Criando novo cargo
            Cargo cargo = new Cargo();
            cargo.setNm_cargo("Supervisor de Manutenção");
            cargo.setLvl_cargo(3);

            // Inserir
            System.out.println(cargoBO.inserirBO(cargo));

            // Listar
            for (Cargo c : cargoBO.selecionarBO()) {
                System.out.println(c);
            }

            // Atualizar
            cargo.setId(1);  // Defina o ID correto
            cargo.setNm_cargo("Supervisor Sênior");
            System.out.println(cargoBO.atualizarBO(cargo));

            // Deletar
            System.out.println(cargoBO.deletarBO(cargo));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
