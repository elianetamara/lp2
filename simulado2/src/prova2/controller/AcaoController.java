package controller;

import comparator.AcaoComparator;
import entities.Acao;
import controller.DesafioController;

import java.util.*;

import static validator.Validator.verificaAcaoIgual;

public class AcaoController {

    private HashMap<Integer, Acao> acoes;

    private DesafioController desafioController;

    public AcaoController() {
        this.acoes = new HashMap<>();
        this.desafioController = new DesafioController();
    }

    public void adicionaAcao(int indiceDesafio, String data, int codigo) throws IllegalAccessException {
        verificaAcaoIgual(acoes, codigo);
        Acao a = new Acao(desafioController.getDesafioById(indiceDesafio), data, codigo);
        acoes.put(codigo, a);
    }

    public void atualizaProgressoAcao(int codigo){
        Acao a = acoes.get(codigo);
        a.setProgresso(10);
        if(a.atingiuMaxProgresso()){
            desafioController.findAndAtualizaDesafioByTitulo(a.getDesafio());
        }
    }

    public void atualizaProgressoAcao(int codigo, int progresso){
        Acao a = acoes.get(codigo);
        a.setProgresso(progresso);
        if(a.atingiuMaxProgresso()){
            desafioController.findAndAtualizaDesafioByTitulo(a.getDesafio());
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
