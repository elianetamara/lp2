package entities;

import static validator.Validator.*;

public class Desafio implements  DesafioInterface{

    private String titulo;

    private String descricao;

    private int qtdExecucoes;

    private int satisfacao;

    public Desafio(String titulo, String descricao) {
        verificaTitulo(titulo);
        this.titulo = titulo;
        this.descricao = descricao;
        this.qtdExecucoes = 0;
        this.satisfacao = 0;
    }

    public void setSatisfacao(int satisfacao) {
        this.satisfacao = satisfacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQtdExecucoes() {
        return qtdExecucoes;
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

    @Override
    public void calculoSatisfacao() {
        setSatisfacao(0);
    }
}
