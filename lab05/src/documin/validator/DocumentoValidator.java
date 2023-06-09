package documin.validator;

import documin.entities.Documento;

import java.util.*;

/**
 * A classe DocumentoValidator fornece métodos para validar documentos e seus atributos.
 * @author eliane - 122110693
 */
public class DocumentoValidator {

    /**
     * Valida o tamanho de um documento.
     *
     * @param tamanho O tamanho do documento.
     * @return true se o tamanho for válido.
     * @throws IllegalArgumentException se o tamanho for menor ou igual a zero.
     */
    public static boolean validaTamanhoDoc(int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("TAMANHO INVÁLIDO");
        }
        return true;
    }

    /**
     * Valida a prioridade de um documento.
     *
     * @param prioridade A prioridade do documento.
     * @throws IllegalArgumentException se a prioridade estiver fora do intervalo [1, 5].
     */
    public static void validaPrioridade(int prioridade) {
        if (prioridade < 1 || prioridade > 5) {
            throw new IllegalArgumentException("PRIORIDADE FORA DO ESCOPO!");
        }
    }

    /**
     * Valida o título de um documento.
     *
     * @param titulo O título do documento.
     * @param docs   O mapa de documentos existentes.
     * @throws IllegalArgumentException se o título for vazio.
     * @throws NoSuchElementException   se o documento não existir no mapa de documentos.
     */
    public static void validaTitulo(String titulo, HashMap<String, Documento> docs) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("TÍTULO INVÁLIDO");
        }
        if (!docs.containsKey(titulo)) {
            throw new NoSuchElementException("DOCUMENTO NÃO EXISTE");
        }
    }

    /**
     * Valida se o título de um documento é vazio.
     *
     * @param titulo O título do documento.
     * @return true se o título não for vazio.
     * @throws IllegalArgumentException se o título for vazio.
     */
    public static boolean validaTituloVazio(String titulo) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("TÍTULO INVÁLIDO");
        }
        return true;
    }

    /**
     * Valida se um documento não existe no mapa de documentos.
     *
     * @param titulo O título do documento.
     * @param docs   O mapa de documentos existentes.
     * @return true se o documento não existir.
     * @throws NoSuchElementException se o documento não existir no mapa de documentos.
     */
    public static boolean validaDocumentoInexistente(String titulo, HashMap<String, Documento> docs) {
        if (!docs.containsKey(titulo)) {
            throw new NoSuchElementException("DOCUMENTO NÃO EXISTE");
        } else {
            return true;
        }
    }

    /**
     * Valida se um documento está cheio.
     *
     * @param doc O documento a ser validado.
     * @throws ArrayIndexOutOfBoundsException se o documento estiver cheio.
     */
    public static void validaDocumentoCheio(Documento doc) {
        if (doc.getTamanho() != 0 && doc.contaElementos() == doc.getTamanho()) {
            throw new ArrayIndexOutOfBoundsException("DOCUMENTO JÁ ESTÁ CHEIO");
        }
    }

    /**
     * Valida se uma posição de elemento em um documento é válida.
     *
     * @param doc     O documento.
     * @param posicao A posição do elemento.
     * @throws IllegalArgumentException se não houver elemento na posição especificada.
     */
    public static void validaPosicaoElemento(Documento doc, int posicao) {
        if (doc.getElementosArray()[posicao] == null) {
            throw new NullPointerException("NÃO EXISTE ELEMENTO NA POSIÇÃO");
        }
    }

    /**
     * Valida se uma posição de visão é válida.
     *
     * @param visoes   A lista de visões.
     * @param visaoId  O ID da visão.
     * @throws IllegalArgumentException se não houver visão na posição especificada.
     */
    public static void validaPosicaoVisao(ArrayList visoes, int visaoId) {
        if (visoes.get(visaoId) == null) {
            throw new NullPointerException("NÃO EXISTE VISÃO NA POSIÇÃO");
        }
    }

    /**
     * Verifica se um documento já possui um atalho.
     *
     * @param tituloDoc             O título do documento.
     * @param tituloDocReferenciado O título do documento referenciado.
     * @param docs                  O mapa de documentos existentes.
     * @throws IllegalArgumentException se um dos títulos for vazio.
     * @throws NoSuchElementException   se um dos documentos não existir no mapa de documentos.
     * @throws IllegalStateException    se o documento já possuir um atalho.
     */
    public static void hasAtalho(String tituloDoc, String tituloDocReferenciado, HashMap<String, Documento> docs) {
        if (validaTituloDocumentoInexistente(tituloDoc, tituloDocReferenciado, docs)) {
            if (docs.get(tituloDoc).isAtalho()) {
                throw new IllegalStateException("JÁ POSSUI ATALHO");
            }
        }
    }

    /**
     * Valida se um título de documento existe no mapa de documentos.
     *
     * @param tituloDoc             O título do documento.
     * @param tituloDocReferenciado O título do documento referenciado.
     * @param docs                  O mapa de documentos existentes.
     * @return true se os títulos forem válidos.
     * @throws IllegalArgumentException se um dos títulos for vazio.
     * @throws NoSuchElementException   se um dos documentos não existir no mapa de documentos.
     */
    private static boolean validaTituloDocumentoInexistente(String tituloDoc, String tituloDocReferenciado, HashMap<String, Documento> docs) {
        if (tituloDoc.isBlank() || tituloDocReferenciado.isBlank()) {
            throw new IllegalArgumentException("UM DOS TÍTULOS INVÁLIDO");
        }
        if (!docs.containsKey(tituloDoc) || !docs.containsKey(tituloDocReferenciado)) {
            throw new NoSuchElementException("UM DOS DOCUMENTOS NÃO EXISTE");
        } else {
            return true;
        }
    }
}