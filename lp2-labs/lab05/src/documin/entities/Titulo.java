package documin.entities;

/**
 * Classe que representa um elemento de título.
 * @author eliane - 122110693
 */
public class Titulo extends Elemento {

    private int nivel;
    private boolean linkavel;

    /**
     * Construtor da classe Titulo.
     *
     * @param nivel O nível do título.
     * @param linkavel Indica se o título é linkável.
     * @param prioridade A prioridade do título.
     * @param valor O valor do título.
     */
    public Titulo(int nivel, boolean linkavel, int prioridade, String valor) {
        super(prioridade, valor, true);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    /**
     * Obtém o nível do título.
     *
     * @return O nível do título.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Verifica se o título é linkável.
     *
     * @return {@code true} se o título é linkável, {@code false} caso contrário.
     */
    public boolean isLinkavel() {
        return linkavel;
    }

    /**
     * Retorna a representação completa do título.
     *
     * @return A representação completa do título.
     */
    @Override
    public String representacaoCompleta() {
        if (isLinkavel()) {
            return getNivel() + ". " + getValor() + " - " + getNivel() + "-" + getValor().toUpperCase();
        }
        return representacaoResumida();
    }

    /**
     * Retorna a representação resumida do título.
     *
     * @return A representação resumida do título.
     */
    @Override
    public String representacaoResumida() {
        return nivel + ". " + getValor();
    }
}