package documin.entities;

public class Elemento implements ElementoInterface{

    private int prioridade;

    private String valor;

    public Elemento(int prioridade, String valor) {
        this.prioridade = prioridade;
        this.valor = valor;
    }

    @Override
    public String representacaoCompleta() {
        return valor;
    }

    @Override
    public String representacaoResumida() {
        return valor;
    }
}
