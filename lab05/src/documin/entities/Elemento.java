package documin.entities;

import documin.interfaces.ElementoInterface;

public class Elemento implements ElementoInterface {

    private int prioridade;

    private String valor;

    private boolean ehTitulo;

    public Elemento(int prioridade, String valor) {
        this.prioridade = prioridade;
        this.valor = valor;
        this.ehTitulo = false;
    }

    public Elemento(int prioridade, String valor, boolean ehTitulo) {
        this.prioridade = prioridade;
        this.valor = valor;
        this.ehTitulo = ehTitulo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getValor() {
        return valor;
    }

    public boolean isEhTitulo() {
        return ehTitulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Elemento elemento = (Elemento) o;

        return valor.equals(elemento.valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }

    @Override
    public String representacaoCompleta() {
        return getValor();
    }

    @Override
    public String representacaoResumida() {
        return getValor();
    }
}
