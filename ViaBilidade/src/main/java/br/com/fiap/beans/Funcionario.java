package br.com.fiap.beans;

public class Funcionario {

    private String matricula;
    private String nome;
    private String cpf; // variável de consulta, logo que seu valor é sensível
    private Cargo cargo;

    @Override
    public String toString() {
        return "Perfil do Funcionario..." + "\n" +
                "Nome Completo: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Cargo: " + cargo;
    }

    public Funcionario() {
        super();
    }

    public Funcionario(String cpf, String nome, String matricula) {
        this.cpf = cpf;
        this.nome = nome;
        this.matricula = matricula;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
