package documin.system;

import documin.documento.DocumentoController;

public class Facade{

    private DocumentoController documentoController;

    public Facade() {
        this.documentoController = new DocumentoController();
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
        return 0;
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return 0;
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return 0;
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return 0;
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return null;
    }

    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return null;
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return false;
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {

    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {

    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return 0;
    }

    public int criarVisaoCompleta(String tituloDoc) {
        return 0;
    }

    public int criarVisaoResumida(String tituloDoc) {
        return 0;
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
