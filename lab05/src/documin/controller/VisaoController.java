package documin.controller;

import documin.entities.*;
import documin.interfaces.VisaoInterface;

import java.util.ArrayList;

import static documin.validator.DocumentoValidator.*;

/**
 * A classe VisãoController fornece métodos para manipulação das visões.
 * @author eliane - 122110693
 */
public class VisaoController implements VisaoInterface {

    private ArrayList visoes;

    public VisaoController() {
        visoes = new ArrayList<>();
    }

    /**
     * Obtém a lista de visões.
     *
     * @return a lista de visões
     */
    public ArrayList getVisoes() {
        return (ArrayList) visoes.clone();
    }

    /**
     * Obtém a visão pelo ID.
     *
     * @param visaoId o ID da visão a ser obtida
     * @return a visão correspondente ao ID
     * @throws NullPointerException se o ID da visão for inválido
     */
    public String[] getVisaoById(int visaoId) {
        validaPosicaoVisao(visoes, visaoId);
        return (String[]) visoes.get(visaoId);
    }

    /**
     * Adiciona uma visão à lista de visões.
     *
     * @param v a visão a ser adicionada
     */
    public void adicionaVisao(String[] v) {
        visoes.add(v);
    }

    /**
     * Retorna a representação completa da visão do documento.
     *
     * @param doc o documento
     * @return um array de strings representando a visão completa do documento
     */
    @Override
    public String[] visaoCompleta(Documento doc) {
        ArrayList<String> visao = new ArrayList<>();
        for (Elemento e : doc.getElementos()) {
            visao.add(e.representacaoCompleta());
        }
        return (String[]) visao.toArray();
    }

    /**
     * Retorna a representação resumida da visão do documento.
     *
     * @param doc o documento
     * @return um array de strings representando a visão resumida do documento
     */
    @Override
    public String[] visaoResumida(Documento doc) {
        ArrayList<String> visao = new ArrayList<>();
        for (Elemento e : doc.getElementos()) {
            visao.add(e.representacaoResumida());
        }
        return (String[]) visao.toArray();
    }

    /**
     * Retorna a visão prioritária do documento com base na prioridade especificada.
     *
     * @param prioridade a prioridade mínima dos elementos a serem incluídos na visão
     * @param doc o documento
     * @return um array de strings representando a visão prioritária do documento
     * @throws IllegalArgumentException se a prioridade for inválida
     */
    @Override
    public String[] visaoPrioritaria(int prioridade, Documento doc) {
        validaPrioridade(prioridade);
        ArrayList<String> visao = new ArrayList<>();
        for (Elemento e : doc.getElementos()) {
            if (e.getPrioridade() >= prioridade) {
                visao.add(e.representacaoCompleta());
            }
        }
        return (String[]) visao.toArray();
    }

    /**
     * Retorna a visão contendo apenas os elementos que são títulos do documento.
     *
     * @param doc o documento
     * @return um array de strings representando a visão contendo apenas os títulos do documento
     */
    @Override
    public String[] visaoTitulo(Documento doc) {
        ArrayList<String> visao = new ArrayList<>();
        for (Elemento e : doc.getElementos()) {
            if (e.isEhTitulo()) {
                visao.add(e.representacaoResumida());
            }
        }
        return (String[]) visao.toArray();
    }
}