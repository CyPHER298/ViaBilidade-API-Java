package br.com.fiap.beans;

public class Aviso {
    private String id; // será uma variável para consulta e será armazenado até que o Aviso tenha sido visto ou o problema seja resolvido.
    private String status;
    private String titulo;
    private String msg;
    private String data;
    private Setor_Manutencao setor_manutencao;

    @Override
    public String toString() {
        return "Aviso!!!" + "\n" +
                "Titulo: " + titulo + "\n" +
                "Mensagem: " + msg + "\n" +
                "Data do aviso: " + data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Setor_Manutencao getSetor_manutencao() {
        return setor_manutencao;
    }

    public void setSetor_manutencao(Setor_Manutencao setor_manutencao) {
        this.setor_manutencao = setor_manutencao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aviso(String titulo, String msg, String data, String status) {
        this.titulo = titulo;
        this.msg = msg;
        this.data = data;
        this.status = status;
    }


    public Aviso() {
        super();
    }

}
