package documin.controller;

import documin.entities.Documento;
import documin.entities.Elemento;

import static documin.validator.DocumentoValidator.*;


public class ElementoController {

    private DocumentoController documentoController;

    public ElementoController() {
        documentoController = new DocumentoController();
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPrioridade(prioridade);
        validaDocumentoCheio(doc);
        return doc.criarTexto(valor, prioridade);

    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPrioridade(prioridade);
        validaDocumentoCheio(doc);
        return doc.criarTitulo(valor, prioridade, nivel, linkavel);
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPrioridade(prioridade);
        validaDocumentoCheio(doc);
        return doc.criarLista(valorLista, prioridade, separador, charLista);
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPrioridade(prioridade);
        validaDocumentoCheio(doc);
        return doc.criarTermos(valorTermos, prioridade, separador, ordem);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        return doc.excluirElemento(elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        doc.moverParaCima(elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        doc.moverParaBaixo(elementoPosicao);
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        return doc.getElemento(elementoPosicao).representacaoCompleta();
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        return doc.getElemento(elementoPosicao).representacaoResumida();
    }
}
