package entities;

import entities.Adicional;

public class Internet extends Adicional {

    private String planoInternet;

    private int mega;

    public Internet(String planoInternet, int mega) {
        super();
        this.planoInternet = planoInternet;
        this.mega = mega;
    }

    @Override
    public double getValorDoAdicional(int num_dias) {
        return mega*0.05*num_dias;
    }

    @Override
    public String getDescricao() {
        return mega + " Mega";
    }

    @Override
    public String toString() {
        return "entities.Internet: [nome=" + planoInternet + ", dados=" + getDescricao() + "]";
    }
}
