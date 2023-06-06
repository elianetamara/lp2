package entities;

public class DesafioPessoal extends Desafio{

    public DesafioPessoal(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public String toString() {
        return "Tìtulo: " + getTitulo() + " (pessoal)" + "\n" + getQtdExecucoes() + " execuções";
    }

    @Override
    public void calculoSatisfacao() {
        setSatisfacao(10);
    }
}
