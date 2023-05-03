/**
 * Classe para representação de uma aposta
 *
 * @author eliane - 122110693
 */
public class Aposta {

    private int colocacao;

    private String valor;

    private Time time;

    private Campeonato campeonato;

    public Aposta(int colocacao, String valor, Time time, Campeonato campeonato) {
        this.colocacao = colocacao;
        this.valor = valor;
        this.time = time;
        this.campeonato = campeonato;
    }

    @Override
    public String toString() {
        return time.toString() + "\n" +
                campeonato.getNome() + "\n" +
                colocacao + "/" + campeonato.getMaxTimes() +
                "\nR$ " + valor;
    }
}
