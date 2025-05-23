package br.com.fiap.beans;

public class Pop {

    private String id; // id será um processo automático de acordo com setor apropriado
    private String titulo;
    private String dt_criacao;
    private String dt_atualizacao;

    public Pop(){
        super();
    }

    public Pop(String titulo, String dt_criacao, String dt_atualizacao) {
        this.titulo = titulo;
        this.dt_criacao = dt_criacao;
        this.dt_atualizacao = dt_atualizacao;
    }

    @Override
    public String toString() {
        return "POP: " + titulo + ", " + dt_criacao + ", " + dt_atualizacao + "\n" +
                "Segue de acordo com a documentação <caminho direcionando para o documento> ";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public String getDt_atualizacao() {
        return dt_atualizacao;
    }

    public void setDt_atualizacao(String dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
}
