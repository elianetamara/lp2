package entities;

public class PlanoPosBig extends Plano {

    private double valorDia;


    public PlanoPosBig(String nome, String cpf, String numTelefone, double valorDia) {
        super(nome, cpf, numTelefone);
        this.valorDia = valorDia;
    }

    @Override
    public String toString() {
        if(isHasAdicional()){
            return super.toString() + "]\n" + getAdicional().toString();
        }
        return super.toString() + "]";
    }

    @Override
    public double valorAPagar(int numero_de_dias) {
        if(isHasAdicional()){
            return (valorDia*numero_de_dias) + getAdicional().getValorDoAdicional(numero_de_dias);
        }
        return (valorDia*numero_de_dias);
    }
}
