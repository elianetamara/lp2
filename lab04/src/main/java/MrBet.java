import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class MrBet {

    private final HashMap<String, Time> times;
    private final HashSet<Campeonato> campeonatos;
    private final ArrayList<Aposta> apostas;

    public MrBet() {
        this.times = new HashMap<>();
        this.campeonatos = new HashSet<>();
        this.apostas = new ArrayList<>();
    }

    public ArrayList<Aposta> getApostas() {
        return (ArrayList<Aposta>) apostas.clone();
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

    public String recuperaTime(String codigo) {
        if(!times.containsKey(codigo)){
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }
        return times.get(codigo).toString();
    }

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
        time.increaseQtdCampeonatos();
        return "TIME INCLUÍDO NO CAMPEONATO!";
    }

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

    public String recuperaCampeonatosTime(String time) {
        if(!times.containsKey(time)){
            throw new NoSuchElementException("TIME NÃO EXISTE!");
        }
        return times.get(time).pegaCampeonatos();
    }

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
        return "APOSTA REGISTRADA!";
    }

    public String recuperaStatusApostas() {
        String saida = "Apostas:\n";
        for (int i = 0; i < apostas.size(); i++) {
            saida += i+1 + ". " + apostas.get(i).toString() + "\n";
        }
        return saida;
    }

    public String recuperaMinParticipacao() {
        String saida = "";
        for (Time t: times.values()) {
            if(t.getQtdCampeonatos() == 0){
                saida += t.toString() + "\n";
            }
        }
        return saida;
    }
}
