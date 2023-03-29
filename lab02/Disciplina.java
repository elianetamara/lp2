import java.util.Arrays;

/**
 * Representação de uma disciplina contendo informações
 * sobre ela e os dados do aluno relacionados a ela
 *
 * @author Eliane Tamara - 122110693
 */

public class Disciplina {

    /**
     *  Nome da disciplina
     */
    private String nomeDisciplina;
    /**
     *  Quantidade de horas dedicadas a disciplina
     */
    private int horasEstudo;
    /**
     *  Lista de notas da disciplina
     */
    private double[] notas = new double[4];

    /**
     * Constrói uma disciplina a partir de seu nome.
     * Toda disciplina começa com os campos horas e notas como nulo;
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Atribui valor ao atributo horasEstudo
     * @param i valor a ser atribuído
     */
    public void cadastraHoras(int i) {
        horasEstudo += i;
    }

    /**
     * Atribui valor ao atributo horasDescanso
     * @param i numero da nota a ser cadastrada
     * @param v nota da disciplina
     */
    public void cadastraNota(int i, double v) {
        notas[i-1] = v;
    }

    /**
     * Calcula média da disciplina
     * @param notas  lista de notas
     * @return a média da disciplina
     */
    public double calculaMedia(double[] notas) {
        int soma = 0;
        for(double nota: notas){
            soma += nota;
        }
        return soma/4;
    }

    /**
     * Vefifica se o aluno foi aprovado
     * @return true se for aprovado, false caso contrário
     */
    public boolean aprovado() {
        double media = calculaMedia(notas);
        if (media >= 7.0) {
            return true;
        }else {
            return false;
    }
    }

    /**
     * Retorna a String que representa a disciplina. A representação segue o
     * formato “nomeDisciplina  horasEstudo media [notas]”.
     *
     * @return a representação em String de um aluno.
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia(notas) + " " + Arrays.toString(notas);
    }
}
