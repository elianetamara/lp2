package entities;

import entities.Adicional;

public class Musica extends Adicional {

    private String planoMusica;

    private String servico;

    public Musica(String planoMusica, String servico) {
        super();
        this.planoMusica = planoMusica;
        this.servico = servico;
    }


    @Override
    public double getValorDoAdicional(int num_dias) {
        return 25+num_dias;
    }

    @Override
    public String getDescricao() {
        return servico;
    }

    @Override
    public String toString() {
        return "entities.Musica: [nome=" + planoMusica + ", servico="+ servico +"]";
    }
}
