package prova2.entities;

public class Acao {

    private Desafio desafio;

    private String data;

    private int progresso;

    private int codigo;

    public Acao(Desafio desafio, String data, int codigo) {
        this.desafio = desafio;
        this.data = data;
        this.progresso = 0;
        this.codigo = codigo;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso += progresso;
    }

    public Desafio getDesafio() {
        return desafio;
    }

    public boolean atingiuMaxProgresso(){
        if(getProgresso() >= 100){
            setProgresso(100);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acao acao = (Acao) o;

        return codigo == acao.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Ação " + codigo + " - " + data  + " - " + desafio + " - " + "Progresso " + progresso + "\n";
    }
}
