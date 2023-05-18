package documin;

public interface FacadeInterface {

    boolean criarDocumento(String titulo);

    boolean criarDocumento(String titulo, int tamanhoMaximo);

    void removerDocumento(String titulo);

    int contarElementos(String titulo);

    String[] exibirDocumento(String titulo);

    int criarTexto(String tituloDoc, String valor, int prioridade);

    int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel);

    int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista);

    int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem);

    String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao);

    String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao);

    boolean apagarElemento(String tituloDoc, int elementoPosicao);

    void moverParaCima(String tituloDoc, int elementoPosicao);

    void moverParaBaixo(String tituloDoc, int elementoPosicao);

    int criarAtalho(String tituloDoc, String tituloDocReferenciado);

    int criarVisaoCompleta(String tituloDoc);

    int criarVisaoResumida(String tituloDoc);

    int criarVisaoPrioritaria(String tituloDoc, int prioridade);

    int criarVisaoTitulo(String tituloDoc);

    String[] exibirVisao(int visaoId);


}
