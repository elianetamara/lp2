/**
 * Classe para representação de um campeonato
 *
 * @author eliane - 122110693
 */
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

    /**
     * Verifica a partir do códgio do time se
     * ele existe no campeonato
     *
     * @param codigo o código do time
     * @return true se o time existir, false caso contrário
     */
    public boolean existeTime(String codigo){
        for (Time t : times) {
            if (t != null && t.getId().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um time ao campeonato
     *
     * @param time a ser adicionado
     */
    public void adicionaTime(Time time){
        if(verificaLotacao()){
            throw new IllegalStateException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
        }
        times[indiceTime] = time;
        indiceTime++;
        time.adicionaCampeonato(this);
    }

    /**
     * Verifica se o campeonato está cheio
     *
     * @return true caso estea cheio, false caso contrário
     */
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

    @Override
    public String toString() {
        return "\n* " + getNome() + " - " + getIndiceTime() + "/" + getMaxTimes();
    }
}
