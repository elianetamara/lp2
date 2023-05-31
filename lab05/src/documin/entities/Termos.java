package documin.entities;

import java.util.*;

public class Termos extends Elemento{

    private String separador;

    private String ordem;

    public Termos(int prioridade, String valor, String ordem, String separador) {
        super(prioridade, valor);
        this.ordem = ordem;
        this.separador = separador;
    }

    private List<String> sortTermos() {
        List<String> termos = Arrays.asList(getValor().split(getSeparador()));
        if (this.getOrdem().equals("ALFABETICA")) {
            termos.sort(String::compareToIgnoreCase);
        } else if (this.getOrdem().equals("TAMANHO")) {
            termos.sort(Comparator.comparingInt(String::length));
        }
        return termos;
    }

    public String getOrdem() {
        return ordem;
    }

    public String getSeparador() {
        return separador;
    }

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
