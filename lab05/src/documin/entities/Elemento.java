package documin.entities;

import documin.interfaces.ElementoInterface;

/**
 * A classe Elemento representa um elemento com uma determinada prioridade e valor.
 * Implementa a interface ElementoInterface.
 * @author eliane - 122110693
 */
public class Elemento implements ElementoInterface {

    private int prioridade;
    private String valor;
    private boolean ehTitulo;

    /**
     * Constrói um novo elemento com a prioridade e valor especificados.
     * O campo ehTitulo é definido como falso por padrão.
     *
     * @param prioridade a prioridade do elemento
     * @param valor o valor do elemento
     */
    public Elemento(int prioridade, String valor) {
        this.prioridade = prioridade;
        this.valor = valor;
        this.ehTitulo = false;
    }

    /**
     * Constrói um novo elemento com a prioridade, valor e indicação de título especificados.
     *
     * @param prioridade a prioridade do elemento
     * @param valor o valor do elemento
     * @param ehTitulo indica se o elemento é um título ou não
     */
    public Elemento(int prioridade, String valor, boolean ehTitulo) {
        this.prioridade = prioridade;
        this.valor = valor;
        this.ehTitulo = ehTitulo;
    }

    /**
     * Obtém a prioridade do elemento.
     *
     * @return a prioridade do elemento
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * Obtém o valor do elemento.
     *
     * @return o valor do elemento
     */
    public String getValor() {
        return valor;
    }

    /**
     * Verifica se o elemento é um título.
     *
     * @return true se o elemento é um título, false caso contrário
     */
    public boolean isEhTitulo() {
        return ehTitulo;
    }

    /**
     * Compara este elemento com outro objeto. Retorna true se os objetos são iguais
     * ou se possuem o mesmo valor.
     *
     * @param o o objeto a ser comparado
     * @return true se os objetos são iguais ou se possuem o mesmo valor, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elemento elemento = (Elemento) o;
        return valor.equals(elemento.valor);
    }

    /**
     * Retorna o hash code deste elemento.
     *
     * @return o hash code deste elemento
     */
    @Override
    public int hashCode() {
        return valor.hashCode();
    }

    /**
     * Retorna a representação completa deste elemento.
     *
     * @return a representação completa deste elemento
     */
    @Override
    public String representacaoCompleta() {
        return getValor();
    }

    /**
     * Retorna a representação resumida deste elemento.
     *
     * @return a representação resumida deste elemento
     */
    @Override
    public String representacaoResumida() {
        return getValor();
    }
}