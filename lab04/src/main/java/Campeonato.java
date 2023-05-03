import java.util.Locale;

public class Campeonato {

    private String nome;

    private Time[] times;

    private int indiceTime;


    private int maxTimes;

    public Campeonato(String nome, int participantes) {
        this.nome = nome;
        this.times = new Time[participantes];
        this.indiceTime = 0;
        this.maxTimes = participantes;
    }

    public boolean existeTime(String codigo){
        for (Time t : times) {
            if (t != null && t.getId().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public void adicionaTime(Time time){
        if(verificaLotacao()){
            throw new IllegalStateException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
        }
        times[indiceTime] = time;
        indiceTime++;
        time.adicionaCampeonato(this);
    }

    private boolean verificaLotacao(){
        int qtdTimes = 0;
        for (Time c: times) {
            if(c != null){
                qtdTimes++;
            }
        }
        return qtdTimes == times.length;
    }


    public String getNome() {
        return nome;
    }

    public int getIndiceTime() {
        return indiceTime;
    }

    public int getMaxTimes() {
        return maxTimes;
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
