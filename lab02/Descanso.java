/**
 * Representação contendo informações sobre a
 * rotina de descanso de um estudante
 *
 * @author Eliane Tamara - 122110693
 */

public class Descanso {

    /**
     *  Quantidade de horas descansadas pelo aluno
     */
    private int horasDescanso;
    /**
     *  Quantidade de semanas em que ele teve os tempos de descanso
     */
    private int numeroSemanas;
    /**
     *  Status do aluno, que pode ser "cansado" ou "descansado"
     */
    private String statusGeral;

    /**
     * Atribui valor ao atributo horasDescanso
     * @param i valor a ser atribuído
     */
    public void defineHorasDescanso(int i) {
        horasDescanso = 0;
        horasDescanso += i;
    }

    /**
     * Atribui valor ao atributo numeroSemanas
     * @param i valor a ser atribuído
     */
    public void defineNumeroSemanas(int i) {
        numeroSemanas = 0;
        numeroSemanas += i;
    }

    /**
     * Retorna a String que representa o status do aluno
     * de acordo com as horas descansadas.
     *
     * @return a representação em String de statusGeral.
     */
    public String getStatusGeral() {
        statusGeral = "cansado";
        if (numeroSemanas != 0) {
            if (!(horasDescanso / numeroSemanas < 26)) {
                statusGeral = "descansado";
            }
        }
        return statusGeral;
    }
}
