package documin.entities;

public class Titulo extends  Elemento{

    private int nivel;

    private boolean linkavel;

    public Titulo(int nivel, boolean linkavel, int prioridade, String valor) {
        super(prioridade, valor);
        this.nivel = nivel;
        this.linkavel = linkavel;
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
