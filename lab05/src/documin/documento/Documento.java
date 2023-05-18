package documin.documento;

import documin.entities.Elemento;

import java.util.ArrayList;

public class Documento {

    private String titulo;

    private int tamanho;

    private ArrayList<Elemento> elementos;

    public Documento(String titulo) {
        this.titulo = titulo;
        this.elementos = new ArrayList<>();
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>(tamanho);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Documento documento = (Documento) o;

        return titulo.equals(documento.titulo);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode();
    }
}
