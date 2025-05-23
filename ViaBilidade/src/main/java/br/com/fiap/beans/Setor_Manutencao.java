package br.com.fiap.beans;

public class Setor_Manutencao {
    private int id; // a declaração dele será automatica, será feito como um fator de busca
    private String nome; // o nome será melhor utilizado mais para frente com mais processos

    @Override
    public String toString() {
        return "Setor: " +
                nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor_Manutencao(int id)
    {
        this.id=id;
    }

    public Setor_Manutencao() {
        super();
    }
}
