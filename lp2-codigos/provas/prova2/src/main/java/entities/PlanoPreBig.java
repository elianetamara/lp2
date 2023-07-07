package entities;

public class PlanoPreBig  extends Plano {

    private int franquia;

    private double valorInicial;

    private double valorExcedente;

    public PlanoPreBig(String nome, String cpf, String numTelefone, int franquia, double valorInicial, double valorExcedente) {
        super(nome, cpf, numTelefone);
        this.franquia = franquia;
        this.valorExcedente = valorExcedente;
        this.valorInicial = valorInicial;
    }

    @Override
    public String toString() {
        if(isHasAdicional()){
            return super.toString() + "franquia=" + franquia + "]\n" + getAdicional().toString();
        }
        return super.toString() + "franquia=" + franquia + "]";
    }

    @Override
    public double valorAPagar(int numero_de_dias) {
        double valor = franquia < numero_de_dias ? (numero_de_dias-franquia)*valorExcedente : 0;
        if(isHasAdicional()){
            return valor + getAdicional().getValorDoAdicional(numero_de_dias);
        }
        return valor;
    }

}
