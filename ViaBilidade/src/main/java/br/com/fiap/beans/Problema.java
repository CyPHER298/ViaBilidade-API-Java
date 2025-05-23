package br.com.fiap.beans;

public class Problema {
    private String id; //será automatizado conforme o aviso foi aplicado
    private String descricao;
    private String data;
    private Setor_Manutencao setor_manutencao;

    @Override
    public String toString() {
        return "Problema: " +
                descricao + "\n" +
                "Data do Início: " + data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Setor_Manutencao getSetor_manutencao() {
        return setor_manutencao;
    }

    public void setSetor_manutencao(Setor_Manutencao setor_manutencao) {
        this.setor_manutencao = setor_manutencao;
    }

    public Problema(String id, String descricao, String data) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
    }

    public Problema(){
        super();
    }
}
