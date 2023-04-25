package src;

import java.util.Objects;

/**
 * Representação de um cachorro para o
 * sistema da HugsAndSmiles
 *
 * @author eliane - 122110693
 */
public class Dog {

    private String nome;

    private String tutor;

    private int qtdRacao;

    private String restricao;


    public Dog(String nome, String tutor, int qtdRacao) {
        this.nome = nome;
        this.tutor = tutor;
        this.qtdRacao = qtdRacao;
    }

    public Dog(String nome, String tutor, int qtdRacao, String restricao) {
        this(nome, tutor, qtdRacao);
        this.qtdRacao = qtdRacao*2;
    }

    public String getNome() {
        return nome;
    }

    public String getTutor() {
        return tutor;
    }

    public int getQtdRacao() {
        return qtdRacao;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }

    public void setQtdRacao(int qtdRacao) {
        this.qtdRacao = qtdRacao;
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
