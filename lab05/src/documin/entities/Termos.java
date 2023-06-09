package documin.entities;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Classe que representa um conjunto de termos.
 * @author eliane - 122110693
 */
public class Termos extends Elemento {

    private String separador;
    private String ordem;

    private String[] termos;

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
        this.termos = getValor().split(Pattern.quote(separador));
    }

    /**
     * Ordena os termos de acordo com a ordem especificada.
     *
     * @return Uma lista de termos ordenados.
     */
    private List<String> sortTermos() {
        if (this.getOrdem().equals("ALFABETICA")) {
            Arrays.sort(termos, (s1, s2) -> s1.compareToIgnoreCase(s2));
        } else if (this.getOrdem().equals("TAMANHO")) {
            Arrays.sort(termos, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        }
        return List.of(termos);
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
                representacao += termos.get(i) + " " + getSeparador() + " ";
            }
        }
        return representacao;
    }
}
