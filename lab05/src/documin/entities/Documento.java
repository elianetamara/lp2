package documin.entities;

import java.util.ArrayList;

/**
 * A classe Documento representa um documento que contém uma lista de elementos.
 * @author eliane - 122110693
 */
public class Documento {

    private String titulo;
    private int tamanho;
    private ArrayList<Elemento> elementos;
    private boolean atalho;

    /**
     * Constrói um novo documento com o título especificado.
     * A lista de elementos é inicializada como vazia e o tamanho é definido como 0.
     *
     * @param titulo o título do documento
     */
    public Documento(String titulo) {
        this.titulo = titulo;
        this.elementos = new ArrayList<>();
        this.tamanho = 0;
    }

    /**
     * Constrói um novo documento com o título e tamanho especificados.
     * A lista de elementos é inicializada com o tamanho especificado.
     *
     * @param titulo o título do documento
     * @param tamanho o tamanho da lista de elementos
     */
    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>(tamanho);
    }

    /**
     * Obtém a lista de elementos do documento como um array.
     *
     * @return um array contendo os elementos do documento
     */
    public Elemento[] getElementosArray() {
        return (Elemento[]) elementos.clone();
    }

    /**
     * Obtém o elemento na posição especificada.
     *
     * @param elementoPosicao a posição do elemento
     * @return o elemento na posição especificada
     */
    public Elemento getElemento(int elementoPosicao) {
        return elementos.get(elementoPosicao);
    }

    /**
     * Obtém a lista de elementos do documento.
     *
     * @return a lista de elementos do documento
     */
    public ArrayList<Elemento> getElementos() {
        return (ArrayList<Elemento>) elementos.clone();
    }

    /**
     * Verifica se o documento é um atalho.
     *
     * @return true se o documento é um atalho, false caso contrário
     */
    public boolean isAtalho() {
        return atalho;
    }

    /**
     * Define se o documento é um atalho.
     *
     * @param atalho true se o documento é um atalho, false caso contrário
     */
    public void setAtalho(boolean atalho) {
        this.atalho = atalho;
    }

    /**
     * Retorna o número de elementos no documento.
     *
     * @return o número de elementos no documento
     */
    public int contaElementos() {
        return elementos.size();
    }

    /**
     * Obtém o tamanho do documento.
     *
     * @return o tamanho do documento
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Compara este documento com outro objeto. Retorna true se os objetos são iguais
     * ou se possuem o mesmo título.
     *
     * @param o o objeto a ser comparado
     * @return true se os objetos são iguais ou se possuem o mesmo título, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return titulo.equals(documento.titulo);
    }

    /**
     * Retorna o hash code deste documento.
     *
     * @return o hash code do documento
     */
    @Override
    public int hashCode() {
        return titulo.hashCode();
    }

    /**
     * Cria um novo objeto Texto e o adiciona à lista de elementos do documento.
     *
     * @param valor o valor do texto
     * @param prioridade a prioridade do texto
     * @return a posição do novo elemento na lista de elementos
     */
    public int criarTexto(String valor, int prioridade) {
        Elemento e = new Texto(prioridade, valor);
        elementos.add(e);
        return elementos.indexOf(e);
    }

    /**
     * Cria um novo objeto Titulo e o adiciona à lista de elementos do documento.
     *
     * @param valor o valor do título
     * @param prioridade a prioridade do título
     * @param nivel o nível do título
     * @param linkavel true se o título é linkável, false caso contrário
     * @return a posição do novo elemento na lista de elementos
     */
    public int criarTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
        Elemento e = new Titulo(nivel, linkavel, prioridade, valor);
        elementos.add(e);
        return elementos.indexOf(e);
    }

    /**
     * Cria um novo objeto Lista e o adiciona à lista de elementos do documento.
     *
     * @param valorLista o valor da lista
     * @param prioridade a prioridade da lista
     * @param separador o separador da lista
     * @param charLista o caractere da lista
     * @return a posição do novo elemento na lista de elementos
     */
    public int criarLista(String valorLista, int prioridade, String separador, String charLista) {
        Elemento e = new Lista(prioridade, valorLista, charLista, separador);
        elementos.add(e);
        return elementos.indexOf(e);
    }

    /**
     * Cria um novo objeto Termos e o adiciona à lista de elementos do documento.
     *
     * @param valorTermos o valor dos termos
     * @param prioridade a prioridade dos termos
     * @param separador o separador dos termos
     * @param ordem a ordem dos termos
     * @return a posição do novo elemento na lista de elementos
     */
    public int criarTermos(String valorTermos, int prioridade, String separador, String ordem) {
        Elemento e = new Termos(prioridade, valorTermos, ordem, separador);
        elementos.add(e);
        return elementos.indexOf(e);
    }

    /**
     * Adiciona um elemento à lista de elementos do documento.
     *
     * @param e o elemento a ser adicionado
     */
    public void adicionaElemento(Elemento e) {
        elementos.add(e);
    }

    /**
     * Remove o elemento na posição especificada da lista de elementos do documento.
     *
     * @param elementoPosicao a posição do elemento a ser removido
     * @return true se o elemento foi removido com sucesso, false caso contrário
     */
    public boolean excluirElemento(int elementoPosicao) {
        elementos.remove(elementoPosicao);
        return true;
    }

    /**
     * Move o elemento na posição especificada uma posição para cima na lista de elementos.
     *
     * @param elementoPosicao a posição do elemento a ser movido
     */
    public void moverParaCima(int elementoPosicao) {
        if (elementoPosicao != 0) {
            Elemento e = elementos.get(elementoPosicao);
            Elemento e1 = elementos.get(elementoPosicao - 1);
            elementos.set(elementoPosicao - 1, e);
            elementos.set(elementoPosicao, e1);
        }
    }

    /**
     * Move o elemento na posição especificada uma posição para baixo na lista de elementos.
     *
     * @param elementoPosicao a posição do elemento a ser movido
     */
    public void moverParaBaixo(int elementoPosicao) {
        if (elementoPosicao != contaElementos()) {
            Elemento e = elementos.get(elementoPosicao);
            Elemento e1 = elementos.get(elementoPosicao + 1);
            elementos.set(elementoPosicao + 1, e);
            elementos.set(elementoPosicao, e1);
        }
    }

    /**
     * Calcula a média das prioridades de todos os elementos do documento.
     *
     * @return a média das prioridades dos elementos
     */
    public int calculaMediaPrioridade() {
        int sumPrioridades = 0;
        for (int i = 0; i < contaElementos(); i++) {
            Elemento e = getElementos().get(i);
            sumPrioridades += e.getPrioridade();
        }
        return sumPrioridades / contaElementos();
    }

}
