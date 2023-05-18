package documin.entities;

public abstract class Elemento {

    private int prioridade;

    private String valor;

    public Elemento(int prioridade, String valor) {
        this.prioridade = prioridade;
        this.valor = valor;
    }

    public abstract String representacaoCompleta();

    public abstract String representacaoResumida();

}
