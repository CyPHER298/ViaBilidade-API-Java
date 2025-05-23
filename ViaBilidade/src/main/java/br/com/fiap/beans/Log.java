package br.com.fiap.beans;

public class Log {
        private int id; // será um valor para consulta, no qual o valor será automatizado
    private String tipo_acao;
    private String dt_hora;

    @Override
    public String toString() {
        return "Registro: " + id + "," + tipo_acao + "," + dt_hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_acao() {
        return tipo_acao;
    }

    public void setTipo_acao(String tipo_acao) {
        this.tipo_acao = tipo_acao;
    }

    public String getDt_hora() {
        return dt_hora;
    }

    public void setDt_hora(String dt_hora) {
        this.dt_hora = dt_hora;
    }

    public Log(String tipo_acao, String dt_hora) {
        this.tipo_acao = tipo_acao;
        this.dt_hora = dt_hora;
    }

    public Log() {
        super();
    }


}
