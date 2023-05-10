package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * Classe que representa o sistema de Mr Bet
 *
 * @author eliane - 122110693
 */
public class SistemaMrBet {

    private final HashMap<String, Time> times;
    private final HashSet<Campeonato> campeonatos;
    private final ArrayList<Aposta> apostas;

    public SistemaMrBet() {
        this.times = new HashMap<>();
        this.campeonatos = new HashSet<>();
        this.apostas = new ArrayList<>();
    }

    private Campeonato getCampeonato(String nome){
        Campeonato campeonato = null;
        for (Campeonato c: campeonatos) {
            if (c.getNome().toLowerCase().equalsIgnoreCase(nome)){
                campeonato = c;
            }
        }
        return campeonato;
    }

    /**
     * Cadastra um time contendo código, nome e mascote
     * @param codigo o codigo do time
     * @param nome o nome do time
     * @param mascote o mascote do time
     * @return mensagem de sucesso do cadastro
     */
    public String cadastraTime(String codigo, String nome, String mascote) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("CÓDIGO OBRIGATÓRIO");
        }
        if(times.containsKey(codigo)){
            throw new IllegalArgumentException("TIME JÁ EXISTE!");
        }
        times.put(codigo, new Time(codigo, nome, mascote));
        return "INCLUSÃO REALIZADA!";
    }

    /**
     * Busca time pelo seu código identificador
     * @param codigo o codigo a ser pesquisado
     * @return string com as informações do time
     */
    public String recuperaTime(String codigo) {
        if(!times.containsKey(codigo)){
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }
        return times.get(codigo).toString();
    }

    /**
     * Cadastra um campeonato com nome e o número de participantes
     * @param campeonato o nome do campeonato
     * @param participantes o número de participantes
     * @return mensagem de sucesso do cadastro
     */
    public String cadastraCampeonato(String campeonato, int participantes) {
        if (campeonato == null || campeonato.isBlank()) {
            throw new IllegalArgumentException("NOME OBRIGATÓRIO");
        }
        if(getCampeonato(campeonato) != null){
            throw new IllegalArgumentException("CAMPEONATO JÁ EXISTE!");
        }
        campeonatos.add(new Campeonato(campeonato, participantes));
        return "CAMPEONATO ADICIONADO!";
    }

    /**
     * Cadastra um time no campeonato
     * @param campeonato nome do campeonato
     * @param codigo o codigo do time a ser adicionado
     * @return mensagem de sucesso do cadastro
     */
    public String cadastraTimeCampeonato(String campeonato, String codigo) {
        if(!times.containsKey(codigo)){
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }
        Campeonato c = getCampeonato(campeonato);
        if (c == null) {
            throw new NoSuchElementException("CAMPEONATO NÃO EXISTE!");
        }
        Time time = times.get(codigo);
        c.adicionaTime(time);
        time.adicionaCampeonato(c);
        time.increaseQtdCampeonatos();
        return "TIME INCLUÍDO NO CAMPEONATO!";
    }

    /**
     * Verifica se o time no campeonato pelo seu código
     * @param campeonato nome do campeonato
     * @param codigo o codigo do time a ser adicionado
     * @return mensagem de sucesso do cadastro
     */
    public String recuperaTimeCampeonato(String campeonato, String codigo) {
        if(!times.containsKey(codigo)){
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }
        Campeonato c = getCampeonato(campeonato);
        if (c == null) {
            throw new NoSuchElementException("O CAMPEONATO NÃO EXISTE!");
        }
        if(c.existeTime(codigo)){
            return "O TIME ESTÁ NO CAMPEONATO!";
        }
        return "O TIME NÃO ESTÁ NO CAMPEONATO!";
    }

    /**
     * Busca campeonatos que o time participa
     * @param time o código do time
     * @return string com as informações dos campeonatos do time
     */
    public String recuperaCampeonatosTime(String time) {
        if(!times.containsKey(time)){
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }
        return times.get(time).pegaCampeonatos();
    }

    /**
     * Cadastra uma aposta
     * @param codigo o código do time
     * @param campeonato nome do campeonato
     * @param colocacao suposta posição do time no campeonato
     * @param valor valor da aposta
     * @return mensagem de sucesso do cadastro
     */
    public String apostaTime(String codigo, String campeonato, int colocacao, String valor) {
        if(!times.containsKey(codigo)){
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }
        Campeonato c = getCampeonato(campeonato);
        if (c == null) {
            throw new NoSuchElementException("O CAMPEONATO NÃO EXISTE!");
        }
        if(!c.existeTime(codigo)){
            throw new IllegalArgumentException("O TIME NÃO ESTÁ NO CAMPEONATO!");
        }
        if(colocacao > c.getMaxTimes()){
            return "APOSTA NÃO REGISTRADA!";
        }
        apostas.add(new Aposta(colocacao, valor, times.get(codigo), c));
        if(colocacao == 1){
            times.get(codigo).increasePrimeiroLugar();
        }
        return "APOSTA REGISTRADA!";
    }

    /**
     * Mostra informações gerais sobre as apostas cadastradas
     * @return string com as informações gerais
     */
    public String recuperaStatusApostas() {
        String saida = "Apostas:\n";
        for (int i = 0; i < apostas.size(); i++) {
            saida += i+1 + ". " + apostas.get(i).toString() + "\n";
        }
        return saida;
    }

    /**
     * Mostra times que não estão em campeonato nenhum
     * @return string contendo os times
     */
    public String recuperaMinParticipacao() {
        String saida = "";
        for (Time t: times.values()) {
            if(t.getQtdCampeonatos() == 0){
                saida += t + "\n";
            }
        }
        if(saida.equals("")){
            saida += "\n";
        }
        return saida;
    }

    /**
     * Mostra times que tiveram apostas onde a colocação na aposta é igual a 1
     * @return string contendo os times e a popularidade
     */
    public String recuperaPopularidade() {
        String saida = "";
        for (Time t: times.values()) {
            if(t.getQtdPrimeiroLugar() > 0) {
                saida += t.getNome() + " / " + t.getQtdPrimeiroLugar() + "\n";
            }
        }
        if(saida.equals("")){
            saida += "\n";
        }
        return saida;
    }

    /**
     * Mostra times que tiveram o maior número de participação em campeonatos
     * @return string contendo os times e a participação
     */
    public String recuperaMaxParticipacao() {
        String saida = "";
        ArrayList<Time> frequentes = maxParticipacao();
        for (Time f : frequentes) {
            saida += f.toString() + " / " + f.getQtdCampeonatos() + "\n";
        }
        if(frequentes.size() == 0){
            saida += "\n";
        }
        return saida;
    }

    private ArrayList<Time> maxParticipacao(){
        ArrayList<Time> frequentes = new ArrayList<>();
        frequentes.add(new Time("", "", ""));
        for (Time t: times.values()) {
            if(t.getQtdCampeonatos() > frequentes.get(0).getQtdCampeonatos() && t.getQtdCampeonatos() != 0){
                frequentes.remove(0);
                frequentes.add(t);
            } else if (t.getQtdCampeonatos() == frequentes.get(0).getQtdCampeonatos() && t.getQtdCampeonatos() != 0) {
                frequentes.add(t);
            }
        }
        if(frequentes.get(0).getId().equals("")){
            frequentes.remove(0);
        }
        return frequentes;
    }
}
