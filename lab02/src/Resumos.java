package src;

/**
 * Representação de um resumo
 *
 * @author Eliane Tamara - 122110693
 */

public class Resumos {

    /**
     *  Título do resumo
     */
    private String titulo;

    /**
     *  Conteúdo do resumo
     */
    private String conteudo;

    /**
     * Constrói um resumo om seus valores vazios.
     *
     */
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
