package prova2.entities;

public class DesafioSocial extends Desafio{

    private int qtdPessoas;

    public DesafioSocial(String titulo, String descricao, int qtdPessoas) {
        super(titulo, descricao);
        this.qtdPessoas = qtdPessoas;
    }

    @Override
    public String toString() {
        return "Tìtulo: " + getTitulo() + " (social)" + "\n" + getQtdExecucoes() + " execuções";
    }

    @Override
    public void calculoSatisfacao() {
        if(qtdPessoas >= 10 && qtdPessoas <= 50){
            setSatisfacao(20);
        }else if(qtdPessoas >= 51 && qtdPessoas <= 100){
            setSatisfacao(50);
        }else if(qtdPessoas > 100){
            setSatisfacao(qtdPessoas);
        }
    }
}
