/**
 * escrever documentacao
 *
 * @author Eliane Tamara
 */

public class Descanso {

    private int horasDescanso;
    private int numeroSemanas;
    private String statusGeral;

    public void defineHorasDescanso(int i) {
        horasDescanso = 0;
        horasDescanso += i;
    }

    public void defineNumeroSemanas(int i) {
        numeroSemanas = 0;
        numeroSemanas += i;
    }

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
