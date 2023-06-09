package documin.system;

import documin.controller.*;

/**
 * Classe que representa a fachada do sistema.
 * @author eliane - 122110693
 */
public class Facade {

    private DocumentoController documentoController;
    private ElementoController elementoController;

    /**
     * Construtor da classe Facade.
     * Inicializa os controladores de documento e elemento.
     */
    public Facade() {
        this.documentoController = new DocumentoController();
        this.elementoController = new ElementoController(documentoController);
    }

    // Métodos de controle de documento

    /**
     * Cria um novo documento com o título especificado.
     *
     * @param titulo O título do documento.
     * @return {@code true} se o documento foi criado com sucesso, {@code false} caso contrário.
     */
    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }

    /**
     * Cria um novo documento com o título e tamanho máximo especificados.
     *
     * @param titulo O título do documento.
     * @param tamanhoMaximo O tamanho máximo do documento.
     * @return {@code true} se o documento foi criado com sucesso, {@code false} caso contrário.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        return this.documentoController.criarDocumento(titulo, tamanhoMaximo);
    }

    /**
     * Remove o documento com o título especificado.
     *
     * @param titulo O título do documento a ser removido.
     */
    public void removerDocumento(String titulo) {
        this.documentoController.removerDocumento(titulo);
    }

    /**
     * Conta o número de elementos no documento com o título especificado.
     *
     * @param titulo O título do documento.
     * @return O número de elementos no documento.
     */
    public int contarElementos(String titulo) {
        return this.documentoController.contarElementos(titulo);
    }

    /**
     * Exibe o documento com o título especificado.
     *
     * @param titulo O título do documento.
     * @return Um array de strings contendo a representação dos elementos do documento.
     */
    public String[] exibirDocumento(String titulo) {
        return this.documentoController.exibirDocumento(titulo);
    }

    // Métodos de controle de elementos

    /**
     * Cria um novo elemento de texto no documento com o título, valor e prioridade especificados.
     *
     * @param tituloDoc O título do documento.
     * @param valor O valor do elemento de texto.
     * @param prioridade A prioridade do elemento de texto.
     * @return O ID do elemento criado.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return this.elementoController.criarTexto(tituloDoc, valor, prioridade);
    }

    /**
     * Cria um novo elemento de título no documento com o título, valor, prioridade, nível e indicador de linkabilidade especificados.
     *
     * @param tituloDoc O título do documento.
     * @param valor O valor do elemento de título.
     * @param prioridade A prioridade do elemento de título.
     * @param nivel O nível do elemento de título.
     * @param linkavel Indica se o elemento de título é linkável.
     * @return O ID do elemento criado.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return this.elementoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }

    /**
     * Cria um novo elemento de lista no documento com o título, valor da lista, prioridade, separador e caractere especificados.
     *
     * @param tituloDoc O título do documento.
     * @param valorLista O valor da lista.
     * @param prioridade A prioridade do elemento de lista.
     * @param separador O separador utilizado na lista.
     * @param charLista O caractere utilizado na lista.
     * @return O ID do elemento criado.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return this.elementoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }

    /**
     * Cria um novo elemento de termos no documento com o título, valor dos termos, prioridade, separador e ordem especificados.
     *
     * @param tituloDoc O título do documento.
     * @param valorTermos O valor dos termos.
     * @param prioridade A prioridade do elemento de termos.
     * @param separador O separador utilizado nos termos.
     * @param ordem A ordem de classificação dos termos.
     * @return O ID do elemento criado.
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return this.elementoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }

    /**
     * Obtém a representação completa do elemento com a posição especificada no documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     * @return A representação completa do elemento.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return this.elementoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    /**
     * Obtém a representação resumida do elemento com a posição especificada no documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     * @return A representação resumida do elemento.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return this.elementoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    /**
     * Remove o elemento com a posição especificada no documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     * @return {@code true} se o elemento foi removido com sucesso, {@code false} caso contrário.
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return this.elementoController.apagarElemento(tituloDoc, elementoPosicao);
    }

    /**
     * Move o elemento com a posição especificada para cima no documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        this.elementoController.moverParaCima(tituloDoc, elementoPosicao);
    }

    /**
     * Move o elemento com a posição especificada para baixo no documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        this.elementoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }

    // Métodos adicionais

    /**
     * Cria um atalho para o documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param tituloDocReferenciado O título do documento a ser referenciado.
     * @return O ID do atalho criado.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    /**
     * Cria uma visão completa do documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @return O ID da visão criada.
     */
    public int criarVisaoCompleta(String tituloDoc) {
        return this.documentoController.criarVisaoCompleta(tituloDoc);
    }

    /**
     * Cria uma visão resumida do documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @return O ID da visão criada.
     */
    public int criarVisaoResumida(String tituloDoc) {
        return this.documentoController.criarVisaoResumida(tituloDoc);
    }

    /**
     * Cria uma visão prioritária do documento com o título e prioridade especificados.
     *
     * @param tituloDoc O título do documento.
     * @param prioridade A prioridade da visão.
     * @return O ID da visão criada.
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return this.documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }

    /**
     * Cria uma visão de títulos do documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @return O ID da visão criada.
     */
    public int criarVisaoTitulo(String tituloDoc) {
        return this.documentoController.criarVisaoTitulo(tituloDoc);
    }

    /**
     * Exibe a visão com o ID especificado.
     *
     * @param visaoId O ID da visão.
     * @return Um array de strings contendo a representação dos elementos da visão.
     */
    public String[] exibirVisao(int visaoId) {
        return this.documentoController.exibirVisao(visaoId);
    }
}
