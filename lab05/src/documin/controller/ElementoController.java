package documin.controller;

import documin.entities.Documento;

import java.util.NoSuchElementException;

import static documin.validator.DocumentoValidator.*;

/**
 * A classe ElementoController fornece métodos para manipulação de elementos.
 * @author eliane - 122110693
 */
public class ElementoController {

    private DocumentoController documentoController;

    public ElementoController() {
        documentoController = new DocumentoController();
    }

    /**
     * Cria um elemento de texto em um documento.
     *
     * @param tituloDoc  O título do documento.
     * @param valor      O valor do texto.
     * @param prioridade A prioridade do texto.
     * @return A posição do elemento criado no documento.
     * @throws IllegalArgumentException se o título do documento ou a prioridade for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws IllegalStateException    se o documento estiver cheio.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPrioridade(prioridade);
        validaDocumentoCheio(doc);
        return doc.criarTexto(valor, prioridade);
    }

    /**
     * Cria um elemento de título em um documento.
     *
     * @param tituloDoc  O título do documento.
     * @param valor      O valor do título.
     * @param prioridade A prioridade do título.
     * @param nivel      O nível do título.
     * @param linkavel   Indica se o título é linkável.
     * @return A posição do elemento criado no documento.
     * @throws IllegalArgumentException se o título do documento ou a prioridade for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws IllegalStateException    se o documento estiver cheio.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPrioridade(prioridade);
        validaDocumentoCheio(doc);
        return doc.criarTitulo(valor, prioridade, nivel, linkavel);
    }

    /**
     * Cria um elemento de lista em um documento.
     *
     * @param tituloDoc    O título do documento.
     * @param valorLista   O valor da lista.
     * @param prioridade   A prioridade da lista.
     * @param separador    O separador da lista.
     * @param charLista    O caractere da lista.
     * @return A posição do elemento criado no documento.
     * @throws IllegalArgumentException se o título do documento ou a prioridade for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws IllegalStateException    se o documento estiver cheio.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPrioridade(prioridade);
        validaDocumentoCheio(doc);
        return doc.criarLista(valorLista, prioridade, separador, charLista);
    }

    /**
     * Cria um elemento de termos em um documento.
     *
     * @param tituloDoc    O título do documento.
     * @param valorTermos  O valor dos termos.
     * @param prioridade   A prioridade dos termos.
     * @param separador    O separador dos termos.
     * @param ordem        A ordem dos termos.
     * @return A posição do elemento criado no documento.
     * @throws IllegalArgumentException se o título do documento, a prioridade ou a ordem for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws IllegalStateException    se o documento estiver cheio.
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaOrdemTermos(ordem);
        validaPrioridade(prioridade);
        validaDocumentoCheio(doc);
        return doc.criarTermos(valorTermos, prioridade, separador, ordem);
    }

    /**
     * Apaga um elemento do documento.
     *
     * @param tituloDoc       O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     * @return true se o elemento foi apagado com sucesso, false caso contrário.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws NullPointerException se a posição do elemento for inválida.
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        return doc.excluirElemento(elementoPosicao);
    }

    /**
     * Move um elemento para cima no documento.
     *
     * @param tituloDoc       O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws NullPointerException se a posição do elemento for inválida.
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        doc.moverParaCima(elementoPosicao);
    }

    /**
     * Move um elemento para baixo no documento.
     *
     * @param tituloDoc       O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws NullPointerException se a posição do elemento for inválida.
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        doc.moverParaBaixo(elementoPosicao);
    }

    /**
     * Obtém a representação completa de um elemento do documento.
     *
     * @param tituloDoc       O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     * @return A representação completa do elemento.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws NullPointerException se a posição do elemento for inválida.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        return doc.getElemento(elementoPosicao).representacaoCompleta();
    }

    /**
     * Obtém a representação resumida de um elemento do documento.
     *
     * @param tituloDoc       O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     * @return A representação resumida do elemento.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     * @throws NullPointerException se a posição do elemento for inválida.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        validaTitulo(tituloDoc, documentoController.getDocumentos());
        Documento doc = documentoController.getDocumento(tituloDoc);
        validaPosicaoElemento(doc, elementoPosicao);
        return doc.getElemento(elementoPosicao).representacaoResumida();
    }
}
