package documin.entities;

public class Lista extends Elemento{

    private String separador;

    private String caractere;

    public Lista(int prioridade, String valor, String caractere, String separador) {
        super(prioridade, valor);
        this.caractere = caractere;
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
