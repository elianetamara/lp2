package src;

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
     *  Emoji que descreve a última sensação em geral do aluno
     */
    private String emoji;

    /**
     * Constrói um descanso com seus valores vazios.
     *
     */
    public Descanso(){
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
        this.statusGeral = "";
        this.emoji = "";

    }

    /**
     * Atribui valor ao atributo horasDescanso
     * @param horas valor a ser atribuído
     */
    void defineHorasDescanso(int horas) {
        emoji = "";
        horasDescanso = 0;
        horasDescanso += horas;
    }

    /**
     * Atribui valor ao atributo emoji
     * @param emoji valor a ser atribuído
     */
    void definirEmoji(String emoji){
        this.emoji = emoji;
    }

    /**
     * Atribui valor ao atributo numeroSemanas
     * @param semanas valor a ser atribuído
     */
    void defineNumeroSemanas(int semanas) {
        numeroSemanas = 0;
        numeroSemanas += semanas;
    }

    /**
     * Retorna a String que representa o status do aluno
     * de acordo com as horas descansadas.
     *
     * @return a representação em String de statusGeral.
     */
    String getStatusGeral() {
        statusGeral = "cansado";
        if (numeroSemanas != 0) {
            if (!(horasDescanso / numeroSemanas < 26)) {
                statusGeral = "descansado";
            }
        }
        if(emoji != ""){
            statusGeral += " - " + emoji;
        }
        return statusGeral;
    }

}
