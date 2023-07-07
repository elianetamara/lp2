package controller;

import comparator.AcaoComparator;
import entities.*;

import java.util.*;

import static validator.Validator.*;

public class MDMVController {

    private ArrayList<Desafio> desafios;

    private HashMap<Integer, Acao> acoes;

    public MDMVController(){
        desafios = new ArrayList<>();
        this.acoes = new HashMap<>();
    }

    public Desafio getDesafioById(int indice) throws IllegalAccessException {
        verificaDesafioExiste(desafios, indice);
        return desafios.get(indice);
    }

    public int adicionaDesafioPessoal(String titulo, String descricao) throws IllegalAccessException {
        Desafio d = new DesafioPessoal(titulo, descricao);
        verificaDesafioIgual(desafios, d);
        desafios.add(d);
        return desafios.indexOf(d);
    }

    public int adicionaDesafioMaterial(String titulo, String descricao, int investimento) throws IllegalAccessException {
        Desafio d = new DesafioMaterial(titulo, descricao, investimento);
        verificaDesafioIgual(desafios, d);
        desafios.add(d);
        return desafios.indexOf(d);
    }

    public int adicionaDesafioSocial(String titulo, String descricao, int qtdPessoas) throws IllegalAccessException {
        Desafio d = new DesafioSocial(titulo, descricao, qtdPessoas);
        verificaDesafioIgual(desafios, d);
        desafios.add(d);
        return desafios.indexOf(d);
    }

    public String exibirDesafio(int indice) throws IllegalAccessException {
        return getDesafioById(indice).toString();
    }

    public void findAndAtualizaDesafioByTitulo(Desafio desafio) {
        for (Desafio d : desafios) {
            if (d.equals(desafio)) {
                d.increaseQtdExecucoes();
                d.calculoSatisfacao();
                break;
            }
        }
    }

    public void adicionaAcao(int indiceDesafio, String data, int codigo) throws IllegalAccessException {
        verificaAcaoIgual(acoes, codigo);
        Acao a = new Acao(getDesafioById(indiceDesafio), data, codigo);
        acoes.put(codigo, a);
    }

    public void atualizaProgressoAcao(int codigo){
        Acao a = acoes.get(codigo);
        a.setProgresso(10);
        if(a.atingiuMaxProgresso()){
            findAndAtualizaDesafioByTitulo(a.getDesafio());
        }
    }

    public void atualizaProgressoAcao(int codigo, int progresso){
        Acao a = acoes.get(codigo);
        a.setProgresso(progresso);
        if(a.atingiuMaxProgresso()){
            findAndAtualizaDesafioByTitulo(a.getDesafio());
        }
    }

    public String listarAcaoOrdemProgresso(){
        String saida = "";
        ArrayList<Acao> acoesRetorno = (ArrayList<Acao>) acoes.values();
        Collections.sort(acoesRetorno, new AcaoComparator());
        for (Acao a: acoesRetorno) {
            saida += a.toString()+ "\n";
        }
        return saida;
    }
}
