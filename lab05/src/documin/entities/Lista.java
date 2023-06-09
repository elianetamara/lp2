package documin.entities;

/**
 * Classe que representa uma lista de elementos.
 * @author eliane - 122110693
 */
public class Lista extends Elemento {

    private String separador;
    private String caractere;

    /**
     * Construtor da classe Lista.
     *
     * @param prioridade A prioridade da lista.
     * @param valor O valor da lista.
     * @param caractere O caractere a ser utilizado na representação da lista.
     * @param separador O separador a ser utilizado para dividir os elementos da lista.
     */
    public Lista(int prioridade, String valor, String caractere, String separador) {
        super(prioridade, valor);
        this.caractere = caractere;
        this.separador = separador;
    }

    /**
     * Obtém o separador utilizado na lista.
     *
     * @return O separador da lista.
     */
    public String getSeparador() {
        return separador;
    }

    /**
     * Obtém o caractere utilizado na representação da lista.
     *
     * @return O caractere da lista.
     */
    public String getCaractere() {
        return caractere;
    }

    /**
     * Retorna a representação completa da lista.
     *
     * @return A representação completa da lista.
     */
    @Override
    public String representacaoCompleta() {
        String[] elemen = getValor().split(getSeparador());
        String representacao = null;
        for (String e: elemen) {
            representacao += getCaractere() + " " + e + "\n";
        }
        return representacao;
    }

    /**
     * Retorna a representação resumida da lista.
     *
     * @return A representação resumida da lista.
     */
    @Override
    public String representacaoResumida() {
        return super.representacaoResumida();
    }
}