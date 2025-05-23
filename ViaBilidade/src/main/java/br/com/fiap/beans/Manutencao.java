package br.com.fiap.beans;

public class Manutencao {
    private String id;
    private String dt_inicio;
    private String dt_termino;
    private Setor_Manutencao setor_manutencao;
    private Problema problema;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(String dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public String getDt_termino() {
        return dt_termino;
    }

    public void setDt_termino(String dt_termino) {
        this.dt_termino = dt_termino;
    }

    public Setor_Manutencao getSetor_manutencao() {
        return setor_manutencao;
    }

    public void setSetor_manutencao(Setor_Manutencao setor_manutencao) {
        this.setor_manutencao = setor_manutencao;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public Manutencao(String id, String dt_inicio, String dt_termino) {
        this.id = id;
        this.dt_inicio = dt_inicio;
        this.dt_termino = dt_termino;
    }

    public Manutencao() {
        super();
    }

    @Override
    public String toString() {
        return "Manutencao" + "\n" +
                "Data de inicio da manutencao: " + dt_inicio +"\n" +
                "Data de termino da manutenção: " + dt_termino +"\n";
    }
}
