import java.util.Objects;

public class Cronica {

    private String titulo;

    private String autor;

    private String texto;

    private String dataCriacao;
    
    private int id;

    private int qtdLeituras;

    public Cronica(String autor, String titulo, String texto, String dataCriacao) {
        this.autor = autor;
        this.texto = texto;
        this.titulo = titulo;
        this.dataCriacao = dataCriacao;
        this.id = 0;
        qtdLeituras = 0;
    }

    public Cronica(String titulo, String texto, String dataCriacao) {
        this("Anônimo", titulo, texto, dataCriacao);
    }

    public int getQtdLeituras() {
        return qtdLeituras;
    }

    public void setQtdLeituras() {
        this.qtdLeituras++;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id+1;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cronica cronica = (Cronica) o;
        return titulo.equals(cronica.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    @Override
    public String toString() {
        return "Cronica #" + (id+1) + "\n" + titulo + "\n" + autor + "\n" + texto + "\n" + dataCriacao + "\n";
    }
}
