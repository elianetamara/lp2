package documin.controller;

import documin.entities.*;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static documin.validator.DocumentoValidator.*;

/**
 * A classe DocumentoController fornece métodos para manipulação de documentos.
 * @author eliane - 122110693
 */
public class DocumentoController {

    private HashMap<String, Documento> documentos;
    private VisaoController visaoController;

    /**
     * Construtor da classe DocumentoController.
     * Inicializa o mapa de documentos e o controlador de visão.
     */
    public DocumentoController() {
        documentos = new HashMap<>();
        visaoController = new VisaoController();
    }

    /**
     * Obtém um documento pelo seu título.
     *
     * @param tituloDoc O título do documento.
     * @return O objeto Documento correspondente.
     * @throws IllegalArgumentException se o título do documento for inválido.
     */
    public Documento getDocumento(String tituloDoc) {
        validaTitulo(tituloDoc, getDocumentos());
        return documentos.get(tituloDoc);
    }

    /**
     * Obtém o mapa de documentos.
     *
     * @return O mapa de documentos.
     */
    public HashMap<String, Documento> getDocumentos() {
        return documentos;
    }

    /**
     * Cria um novo documento sem tamanho máximo.
     *
     * @param titulo O título do documento.
     * @return true se o documento for criado com sucesso, false caso contrário.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento já existir.
     */
    public boolean criarDocumento(String titulo) {
        if (validaTituloVazio(titulo) && !validaDocumentoInexistente(titulo, documentos)) {
            documentos.put(titulo, new Documento(titulo));
            return true;
        }
        return false;
    }

    /**
     * Cria um novo documento com tamanho máximo especificado.
     *
     * @param titulo       O título do documento.
     * @param tamanhoMaximo O tamanho máximo do documento.
     * @return true se o documento for criado com sucesso, false caso contrário.
     * @throws IllegalArgumentException se o título do documento ou o tamanho máximo forem inválidos.
     * @throws NoSuchElementException   se o documento já existir.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        if (validaTituloVazio(titulo) && validaTamanhoDoc(tamanhoMaximo) && !validaDocumentoInexistente(titulo, documentos)) {
            documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
            return true;
        }
        return false;
    }

    /**
     * Remove um documento pelo seu título.
     *
     * @param titulo O título do documento a ser removido.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     */
    public void removerDocumento(String titulo) {
        validaTitulo(titulo, documentos);
        documentos.remove(titulo);
    }

    /**
     * Conta o número de elementos em um documento pelo seu título.
     *
     * @param titulo O título do documento.
     * @return O número de elementos no documento.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     */
    public int contarElementos(String titulo) {
        validaTitulo(titulo, documentos);
        return documentos.get(titulo).contaElementos();
    }

    /**
     * Exibe um documento pelo seu título.
     *
     * @param titulo O título do documento.
     * @return Um array de strings representando o conteúdo do documento.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     */
    public String[] exibirDocumento(String titulo) {
        validaTitulo(titulo, documentos);
        Documento d = documentos.get(titulo);
        String[] doc = new String[d.contaElementos()];
        for (int i = 0; i < d.contaElementos(); i++) {
            doc[i] = d.getElementosArray()[i].representacaoResumida();
        }

        return doc;
    }

    /**
     * Cria um atalho para um documento referenciado pelo seu título.
     *
     * @param tituloDoc             O título do documento.
     * @param tituloDocReferenciado O título do documento referenciado.
     * @return O índice do atalho criado no documento referenciado.
     * @throws IllegalArgumentException se um dos títulos for vazio.
     * @throws NoSuchElementException   se um dos documentos não existir.
     * @throws IllegalStateException    se o documento já possuir um atalho.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        hasAtalho(tituloDoc, tituloDocReferenciado, documentos);
        Documento doc = documentos.get(tituloDoc);
        Documento docRef = documentos.get(tituloDocReferenciado);
        Atalho a = new Atalho(docRef.calculaMediaPrioridade(), tituloDocReferenciado, docRef.getElementos());
        doc.adicionaElemento(a);
        doc.setAtalho(true);
        docRef.setAtalho(true);

        return docRef.getElementos().indexOf(a);
    }

    /**
     * Cria uma visão completa para um documento pelo seu título.
     *
     * @param tituloDoc O título do documento.
     * @return O ID da visão completa criada.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     */
    public int criarVisaoCompleta(String tituloDoc) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String[] visaoCompleta = visaoController.visaoCompleta(doc);
        visaoController.adicionaVisao(visaoCompleta);
        return visaoController.getVisoes().indexOf(visaoCompleta);
    }

    /**
     * Cria uma visão resumida para um documento pelo seu título.
     *
     * @param tituloDoc O título do documento.
     * @return O ID da visão resumida criada.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     */
    public int criarVisaoResumida(String tituloDoc) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String[] visaoResumida = visaoController.visaoResumida(doc);
        visaoController.adicionaVisao(visaoResumida);
        return visaoController.getVisoes().indexOf(visaoResumida);
    }

    /**
     * Cria uma visão prioritária para um documento pelo seu título e prioridade.
     *
     * @param tituloDoc  O título do documento.
     * @param prioridade A prioridade da visão prioritária.
     * @return O ID da visão prioritária criada.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String[] visaoPrioritaria = visaoController.visaoPrioritaria(prioridade, doc);
        visaoController.adicionaVisao(visaoPrioritaria);
        return visaoController.getVisoes().indexOf(visaoPrioritaria);
    }

    /**
     * Cria uma visão pelo título do documento.
     *
     * @param tituloDoc O título do documento.
     * @return O ID da visão criada.
     * @throws IllegalArgumentException se o título do documento for inválido.
     * @throws NoSuchElementException   se o documento não existir.
     */
    public int criarVisaoTitulo(String tituloDoc) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String[] visaoTitulo = visaoController.visaoTitulo(doc);
        visaoController.adicionaVisao(visaoTitulo);
        return visaoController.getVisoes().indexOf(visaoTitulo);
    }

    /**
     * Exibe uma visão pelo seu ID.
     *
     * @param visaoId O ID da visão.
     * @return Um array de strings representando a visão.
     */
    public String[] exibirVisao(int visaoId) {
        return visaoController.getVisaoById(visaoId);
    }
}