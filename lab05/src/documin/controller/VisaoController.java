package documin.controller;

import documin.entities.*;

import java.util.ArrayList;

import static documin.validator.DocumentoValidator.validaPosicaoVisao;
import static documin.validator.DocumentoValidator.validaPrioridade;

public class VisaoController implements VisaoInterface {

    private ArrayList visoes;

    public VisaoController() {
        visoes = new ArrayList<>();
    }

    public ArrayList getVisoes() {
        return (ArrayList) visoes.clone();
    }

    public String[] getVisaoById(int visaoId){
        validaPosicaoVisao(visoes, visaoId);
        return (String[]) visoes.get(visaoId);
    }


    public void adicionaVisao(String[] v){
        visoes.add(v);
    }

    @Override
    public String[] visaoCompleta(Documento doc) {
        ArrayList<String> visao = new ArrayList<>();
        for (Elemento e: doc.getElementos()) {
            visao.add(e.representacaoCompleta());
        }
        return (String[]) visao.toArray();
    }

    @Override
    public String[] visaoResumida(Documento doc) {
        ArrayList<String> visao = new ArrayList<>();
        for (Elemento e: doc.getElementos()) {
            visao.add(e.representacaoResumida());
        }
        return (String[]) visao.toArray();
    }

    @Override
    public String[] visaoPrioritaria(int prioridade, Documento doc) {
        validaPrioridade(prioridade);
        ArrayList<String> visao = new ArrayList<>();
        for (Elemento e: doc.getElementos()) {
            if(e.getPrioridade() >= prioridade){
                visao.add(e.representacaoCompleta());
            }
        }
        return (String[]) visao.toArray();
    }

    @Override
    public String[] visaoTitulo(Documento doc) {
        ArrayList<String> visao = new ArrayList<>();
        for (Elemento e: doc.getElementos()) {
            if(e.isEhTitulo()){
                visao.add(e.representacaoResumida());
            }
        }
        return (String[]) visao.toArray();
    }
}
