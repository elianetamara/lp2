package prova2.controller;

import prova2.comparator.AcaoComparator;
import prova2.entities.Acao;

import java.util.*;

public class AcaoController {

    private HashMap<Integer, Acao> acoes;

    private DesafioController desafioController;

    public AcaoController() {
        this.acoes = new HashMap<>();
        this.desafioController = new DesafioController();
    }

    public void adicionaAcao(int indiceDesafio, String data, int codigo) throws IllegalAccessException {
        Acao a = desafioController.adicionaAcao(indiceDesafio, data, codigo);
        acoes.put(codigo, a);
    }

    public void atualizaProgressoAcao(int codigo) throws IllegalAccessException {
        Acao a = acoes.get(codigo);
        a.setProgresso(10);
        desafioController.findAndAtualizaDesafioByTitulo(a.getDesafio(), codigo);

    }

    public void atualizaProgressoAcao(int codigo, int progresso) throws IllegalAccessException {
        Acao a = acoes.get(codigo);
        a.setProgresso(progresso);
        desafioController.findAndAtualizaDesafioByTitulo(a.getDesafio(), codigo, progresso);

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
