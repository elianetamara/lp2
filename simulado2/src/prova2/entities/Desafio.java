package prova2.entities;

import prova2.comparator.AcaoComparator;

import java.util.HashMap;

import static prova2.validator.Validator.*;

public class Desafio {

    private String titulo;

    private String descricao;

    private int qtdExecucoes;

    private HashMap<Integer, Acao> acoes;

    public Desafio(String titulo, String descricao) {
        verificaTitulo(titulo);
        this.titulo = titulo;
        this.descricao = descricao;
        this.qtdExecucoes = 0;
        acoes = new HashMap<>();
    }

    public void increaseQtdExecucoes() {
        this.qtdExecucoes++;
    }

    public Acao getAcaoById(int codigo) throws IllegalAccessException {
        verificaAcaoExiste(acoes, codigo);
        return acoes.get(codigo);
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

    public Acao adicionaAcao(String data, int codigo) throws IllegalAccessException {
        verificaAcaoIgual(acoes, codigo);
        Acao a = new Acao(this, data, codigo);
        acoes.put(codigo, a);
        return a;
    }

    public Acao atualizaProgressoAcao(int codigo) throws IllegalAccessException {
        Acao a = getAcaoById(codigo);
        a.setProgresso(10);
        if(atingiuMaxProgresso(a)){
            increaseQtdExecucoes();
        }
        return a;
    }

    public Acao atualizaProgressoAcao(int codigo, int progresso) throws IllegalAccessException {
        Acao a = getAcaoById(codigo);
        a.setProgresso(progresso);
        if(atingiuMaxProgresso(a)){
            increaseQtdExecucoes();
        }
        return a;
    }

    private boolean atingiuMaxProgresso(Acao a){
        if(a.getProgresso() >= 100){
            return true;
        }
        return false;
    }

}
