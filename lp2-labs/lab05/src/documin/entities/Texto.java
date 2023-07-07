package documin.entities;

/**
 * Classe que representa um elemento de texto.
 * @author eliane - 122110693
 */
public class Texto extends Elemento {

    /**
     * Construtor da classe Texto.
     *
     * @param prioridade A prioridade do texto.
     * @param valor O valor do texto.
     */
    public Texto(int prioridade, String valor) {
        super(prioridade, valor);
    }

    /**
     * Retorna a representação completa do texto.
     *
     * @return A representação completa do texto.
     */
    @Override
    public String representacaoCompleta() {
        return super.representacaoCompleta();
    }

    /**
     * Retorna a representação resumida do texto.
     *
     * @return A representação resumida do texto.
     */
    @Override
    public String representacaoResumida() {
        return super.representacaoResumida();
    }
}