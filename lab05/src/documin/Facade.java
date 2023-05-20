package documin;

import documin.documento.DocumentoController;

public class Facade{

    private DocumentoController documentoController;

    public Facade() {
        this.documentoController = new DocumentoController();
    }

    public boolean criarDocumento(String titulo) {
        // // exemplo de chamada a ser implementado
        return this.documentoController.criarDocumento(titulo);

    }

    @Override
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        return false;
    }

    @Override
    public void removerDocumento(String titulo) {

    }

    @Override
    public int contarElementos(String titulo) {
        return 0;
    }

    @Override
    public String[] exibirDocumento(String titulo) {
        return new String[0];
    }

    @Override
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return 0;
    }

    @Override
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return 0;
    }

    @Override
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return 0;
    }

    @Override
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return 0;
    }

    @Override
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return null;
    }

    @Override
    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return null;
    }

    @Override
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return false;
    }

    @Override
    public void moverParaCima(String tituloDoc, int elementoPosicao) {

    }

    @Override
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {

    }

    @Override
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return 0;
    }

    @Override
    public int criarVisaoCompleta(String tituloDoc) {
        return 0;
    }

    @Override
    public int criarVisaoResumida(String tituloDoc) {
        return 0;
    }

    @Override
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return 0;
    }

    @Override
    public int criarVisaoTitulo(String tituloDoc) {
        return 0;
    }

    @Override
    public String[] exibirVisao(int visaoId) {
        return new String[0];
    }

}
