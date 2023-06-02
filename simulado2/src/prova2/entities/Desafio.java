package prova2.entities;

import static prova2.validator.Validator.*;

public class Desafio {

    private String titulo;

    private String descricao;

    private int qtdExecucoes;

    public Desafio(String titulo, String descricao) {
        verificaTitulo(titulo);
        this.titulo = titulo;
        this.descricao = descricao;
        this.qtdExecucoes = 0;

    }

    public void increaseQtdExecucoes() {
        this.qtdExecucoes++;
    }


    @Override
    public String toString() {
        return "Tìtulo: " + titulo + "\n" + qtdExecucoes + " execuções";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Desafio desafio = (Desafio) o;

        return titulo.equals(desafio.titulo);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode();
    }

}
