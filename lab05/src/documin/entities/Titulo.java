package documin.entities;

public class Titulo extends Elemento{

    private int nivel;

    private boolean linkavel;

    public Titulo(int nivel, boolean linkavel, int prioridade, String valor) {
        super(prioridade, valor, true);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean isLinkavel() {
        return linkavel;
    }

    @Override
    public String representacaoCompleta() {
        if (isLinkavel()){
            return getNivel() +". " + getValor() + " - " + getNivel() + "-" + getValor().toUpperCase();
        }
        return representacaoResumida();
    }

    @Override
    public String representacaoResumida() {
        return nivel +". " + getValor();
    }
}
