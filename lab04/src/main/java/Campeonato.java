import java.util.Locale;

public class Campeonato {

    private String nome;

    private Time[] times;

    public Campeonato(String nome, int participantes) {
        this.nome = nome;
        this.times = new Time[participantes];
    }

    public String getNome() {
        return nome;
    }

    public Time[] getTimes() {
        return times.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Campeonato that = (Campeonato) o;

        return getNome().toLowerCase().equalsIgnoreCase(that.getNome());
    }

    @Override
    public int hashCode() {
        return getNome().hashCode();
    }
}
