package documin.controller;

import documin.entities.Documento;
import static documin.validator.DocumentoValidator.*;


public class ElementoController {

    private DocumentoController documentoController;

    ElementoController() {
        documentoController = new DocumentoController();
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaListaElemen(doc)){
            return doc.criarTexto(valor, prioridade);
        }else {
            return 0;
        }
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaListaElemen(doc)){
            return doc.criarTitulo(valor, prioridade, nivel, linkavel);
        }else {
            return 0;
        }
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaListaElemen(doc)){
            return doc.criarLista(valorLista, prioridade, separador, charLista);
        }else {
            return 0;
        }
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaListaElemen(doc)){
            return doc.criarTermos(valorTermos, prioridade, separador, ordem);
        }else {
            return 0;
        }
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaPosicaoLista(doc, elementoPosicao)){
            return doc.excluirElemento(elementoPosicao);
        }else {
            return false;
        }
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaPosicaoLista(doc, elementoPosicao)){
            doc.moverParaCima(elementoPosicao);
        }
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaPosicaoLista(doc, elementoPosicao)){
            doc.moverParaBaixo(elementoPosicao);
        }
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaPosicaoLista(doc, elementoPosicao)){

        }
        return tituloDoc;
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return tituloDoc;
    }
}