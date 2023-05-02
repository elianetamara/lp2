import java.util.ArrayList;

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

}
