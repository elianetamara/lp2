package documin.system;

import documin.controller.DocumentoController;
import documin.controller.ElementoController;

public class Facade{

    private DocumentoController documentoController;

    private ElementoController elementoController;

    public Facade() {
        this.documentoController = new DocumentoController();
        this.elementoController = new ElementoController();
    }

    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        return this.documentoController.criarDocumento(titulo, tamanhoMaximo);
    }

    public void removerDocumento(String titulo) {
        this.documentoController.removerDocumento(titulo);
    }

    public int contarElementos(String titulo) {
        return this.documentoController.contarElementos(titulo);
    }

    public String[] exibirDocumento(String titulo) {
        return this.documentoController.exibirDocumento(titulo);
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return this.elementoController.criarTexto(tituloDoc, valor, prioridade);
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return this.elementoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return this.elementoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return this.elementoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return this.elementoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return this.elementoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return this.elementoController.apagarElemento(tituloDoc, elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        this.elementoController.moverParaCima(tituloDoc, elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        this.elementoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    public int criarVisaoCompleta(String tituloDoc) {
        return this.documentoController.criarVisaoCompleta(tituloDoc);
    }

    public int criarVisaoResumida(String tituloDoc) {
        return this.documentoController.criarVisaoResumida(tituloDoc);
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return 0;
    }

    public int criarVisaoTitulo(String tituloDoc) {
        return 0;
    }

    public String[] exibirVisao(int visaoId) {
        return new String[0];
    }

}
