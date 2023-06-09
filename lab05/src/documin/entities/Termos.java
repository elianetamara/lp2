package documin.entities;

import java.util.*;

/**
 * Classe que representa um conjunto de termos.
 * @author eliane - 122110693
 */
public class Termos extends Elemento {

    private String separador;
    private String ordem;

    /**
     * Construtor da classe Termos.
     *
     * @param prioridade A prioridade dos termos.
     * @param valor O valor dos termos.
     * @param ordem A ordem dos termos ("ALFABETICA" ou "TAMANHO").
     * @param separador O separador utilizado para dividir os termos.
     */
    public Termos(int prioridade, String valor, String ordem, String separador) {
        super(prioridade, valor);
        this.ordem = ordem;
        this.separador = separador;
    }

    /**
     * Ordena os termos de acordo com a ordem especificada.
     *
     * @return Uma lista de termos ordenados.
     */
    private List<String> sortTermos() {
        List<String> termos = Arrays.asList(getValor().split(getSeparador()));
        if (this.getOrdem().equals("ALFABETICA")) {
            termos.sort(String::compareToIgnoreCase);
        } else if (this.getOrdem().equals("TAMANHO")) {
            termos.sort(Comparator.comparingInt(String::length));
        }
        return termos;
    }

    /**
     * Obtém a ordem dos termos.
     *
     * @return A ordem dos termos.
     */
    public String getOrdem() {
        return ordem;
    }

    /**
     * Obtém o separador utilizado para dividir os termos.
     *
     * @return O separador dos termos.
     */
    public String getSeparador() {
        return separador;
    }

    /**
     * Retorna a representação completa dos termos.
     *
     * @return A representação completa dos termos.
     */
    @Override
    public String representacaoCompleta() {
        List<String> termos = sortTermos();
        String representacao = "";
        for (int i = 0; i < termos.size(); i++) {
            if(i == termos.size()-1){
                representacao += termos.get(i);
            }else{
                representacao += termos.get(i) + ", ";
            }
        }
        return "Total termos: " + termos.size()+ "\n" + representacao;
    }

    /**
     * Retorna a representação resumida dos termos.
     *
     * @return A representação resumida dos termos.
     */
    @Override
    public String representacaoResumida() {
        List<String> termos = sortTermos();
        String representacao = "";
        for (int i = 0; i < termos.size(); i++) {
            if(i == termos.size()-1){
                representacao += termos.get(i);
            }else{
                representacao += termos.get(i) + getSeparador();
            }
        }
        return representacao;
    }
}
