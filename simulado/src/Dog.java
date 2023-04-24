package src;

import java.util.Objects;

public class Dog {

    private String nome;

    private String tutor;

    private int qtdRacao;

    private String restricao;

    public Dog(String nome, String tutor, int qtdRacao, String restricao) {
        this.nome = nome;
        this.tutor = tutor;
        this.restricao = restricao;
        if(!restricao.isBlank()){
            this.qtdRacao = qtdRacao*2;
        }else{
            this.qtdRacao = qtdRacao;
        }
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }

    @Override
    public String toString() {
        return "Dog [nome="+ nome +", tutor="+ tutor +" +]";
    }

    public boolean equals(Object o, Object b) {
        return nome.equals(o) && tutor.equals(b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tutor);
    }
}
