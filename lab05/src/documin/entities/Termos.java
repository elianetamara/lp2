package documin.entities;

public class Termos extends Elemento{

    private String separador;

    private String ordem;

    public Termos(int prioridade, String valor, String ordem, String separador) {
        super(prioridade, valor);
        this.ordem = ordem;
        this.separador = separador;
    }

    @Override
    public String representacaoCompleta() {
        return null;
    }

    @Override
    public String representacaoResumida() {
        return null;
    }
}
