package documin.entities;

public class Titulo extends Elemento{

    private int nivel;

    private boolean linkavel;

    public Titulo(int nivel, boolean linkavel, int prioridade, String valor) {
        super(prioridade, valor);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    @Override
    public String representacaoCompleta() {
        if (linkavel){
            return nivel +". " + getValor() + " - " + nivel+"-"+getValor().toUpperCase();
        }
        return representacaoResumida();
    }

    @Override
    public String representacaoResumida() {
        return nivel +". " + getValor();
    }
}
