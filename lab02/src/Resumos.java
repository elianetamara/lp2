package src;

public class Resumos {

    private String titulo;

    private String conteudo;

    public Resumos(){
        this.titulo = "";
        this.conteudo = "";

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
