package entities;

public abstract class Adicional {

    private double valor;

    public Adicional() {
        valor = 0;
    }

    public abstract double getValorDoAdicional(int num_dias);
    public abstract String getDescricao();
}
