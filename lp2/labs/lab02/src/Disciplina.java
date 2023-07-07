package src;

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
    private double[] notas;
    /**
     *  Lista de pesoas das notas da disciplina
     */
    private int[] pesos;

    /**
     * Constrói uma disciplina a partir de seu nome.
     * Toda disciplina começa com os campos horas e notas como sero/nulo;
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
    }

    /**
     * Constrói uma disciplina a partir de seu nome e do número de notas dela.
     * Toda disciplina começa com o camponotas como nulo;
     *
     * @param nomeDisciplina o nome da disciplina
     * @param numNotas o número de notas que a disciplina tem
     */
    public Disciplina(String nomeDisciplina, int numNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numNotas];
    }

    /**
     * Constrói uma disciplina a partir de seu nomedo número de notas, dos pesos de cada nota.
     * Toda disciplina começa com o campo notas como nulo;
     *
     * @param nomeDisciplina o nome da disciplina
     * @param numNotas o número de notas que a disciplina tem
     * @param pesos os pesos de cada nota da disciplina
     */
    public Disciplina(String nomeDisciplina, int numNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numNotas];
        this.pesos = pesos;
    }

    /**
     * Atribui valor ao atributo horasEstudo
     * @param horas valor a ser atribuído
     */
    void cadastraHoras(int horas) {
        horasEstudo += horas;
    }

    /**
     * Atribui valor ao atributo horasDescanso
     * @param numero numero da nota a ser cadastrada
     * @param nota nota da disciplina
     */
    void cadastraNota(int numero, double nota) {
        notas[numero-1] = nota;
    }

    /**
     * Calcula média da disciplina
     * @param notas  lista de notas
     * @return a média da disciplina
     */
    private double calculaMedia(double[] notas) {
        if(pesos != null){
            int somaNotas = 0;
            for(int i = 0; i < notas.length; i++){
                somaNotas += (notas[i]*pesos[i]);
            }
            int somaPesos = 0;
            for(int peso: pesos){
                somaPesos += peso;
            }
            return somaNotas/ somaPesos;
        }
        int somaNotas = 0;
        for(double nota: notas){
            somaNotas += nota;
        }
        return somaNotas/ notas.length;
    }

    /**
     * Vefifica se o aluno foi aprovado
     * @return true se for aprovado, false caso contrário
     */
    boolean aprovado() {
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
