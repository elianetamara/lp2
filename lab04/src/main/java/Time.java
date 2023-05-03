import java.util.HashSet;

public class Time {

    private String id;

    private String nome;

    private String mascote;

    private final HashSet<Campeonato> campeonatos;

    private int qtdCampeonatos;

    private int qtdPrimeiroLugar;

    public Time(String id, String nome, String mascote) {
        this.id = id;
        this.nome = nome;
        this.mascote = mascote;
        this.campeonatos = new HashSet<>();
        this.qtdCampeonatos = 0;
        this.qtdPrimeiroLugar = 0;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void increaseQtdCampeonatos(){
        qtdCampeonatos++;
    }

    public void increasePrimeiroLugar(){
        qtdPrimeiroLugar++;
    }

    public int getQtdCampeonatos() {
        return qtdCampeonatos;
    }

    public int getQtdPrimeiroLugar() {
        return qtdPrimeiroLugar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return getId().equals(time.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " / " + mascote;
    }

    public void adicionaCampeonato(Campeonato c){
        campeonatos.add(c);
    }

    public String pegaCampeonatos() {
        StringBuilder saida = new StringBuilder("Campeonatos do " + nome + ":");
        for (Campeonato c: campeonatos) {
            saida.append("\n* " + c.getNome() + " - " + c.getIndiceTime() + "/" + c.getMaxTimes());
        }
        return saida.toString();
    }
}
