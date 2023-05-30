package documin.entities;

import java.util.ArrayList;

public class Documento {

    private String titulo;

    private int tamanho;

    private ArrayList<Elemento> elementos;

    public Documento(String titulo) {
        this.titulo = titulo;
        this.elementos = new ArrayList<>();
        this.tamanho = 0;
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>(tamanho);
    }

    public int contaElementos(){
        return elementos.size();
    }

    public Elemento[] getElementosArray() {
        return (Elemento[]) elementos.clone();
    }

    public int getTamanho() {
        return tamanho;
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

    public int criarTexto(String valor, int prioridade) {
        Elemento e = new Texto(prioridade, valor);
        elementos.add(e);
        return elementos.indexOf(e);
    }

    public int criarTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
        Elemento e = new Titulo(nivel, linkavel, prioridade, valor);
        elementos.add(e);
        return elementos.indexOf(e);
    }
}
