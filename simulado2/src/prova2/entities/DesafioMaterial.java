package prova2.entities;

public class DesafioMaterial extends Desafio{

    private int investimento;

    public DesafioMaterial(String titulo, String descricao, int investimento) {
        super(titulo, descricao);
        this.investimento = investimento;
    }

    @Override
    public String toString() {
        return "Tìtulo: " + getTitulo() + " (material)" + "\n" + getQtdExecucoes() + " execuções";
    }

    @Override
    public void calculoSatisfacao() {
        setSatisfacao(Math.abs(10*(investimento/10)));
    }
}
