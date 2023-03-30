/**
 * Mantém a informação sobre quantidade de horas
 * de internet que o aluno tem dedicado a uma disciplina
 *
 * @author Eliane Tamara - 122110693
 */

public class RegistroTempoOnline {

    /**
     *  Nome da disciplina
     */
    private String nomeDisciplina;
    /**
     *  Quantidade de horas gastas com a disciplina
     */
    private int tempoGasto;
    /**
     *  Quantidade de horas planejadas para estudar a disciplina
     */
    private int tempoEsperado;
    /**
     * Constrói um registro de tempo online a partir do nome da disciplina
     * e define o tempo esperado para ela
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = 60 * 2;
        this.tempoGasto = 0;

    }

    /**
     * Constrói um registro de tempo online a partir do nome da disciplina
     * e do tempo esperado para ela
     *
     * @param nomeDisciplina o nome da disciplina
     * @param tempoEsperado horas planejadas para estudo da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoEsperado;
        this.tempoGasto = 0;

    }

    /**
     * Atribui valor ao atributo tempoGasto
     * 
     * @param tempo valor a ser atribuído
     */
    void adicionaTempoOnline(int tempo) {
       tempoGasto += tempo;
    }

    /**
     * Vefifica se o aluno atingiu a meta de tempo online
     * 
     * @return true se for aprovado, false caso contrário
     */
    boolean atingiuMetaTempoOnline() {
        if(tempoGasto >= tempoEsperado){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Retorna a String que representa o registro. A representação segue o
     * formato “nomeDisciplina  tempoGasto/tempoEsperado”.
     *
     * @return a representação em String de um aluno.
     */
    @Override
    public String toString(){
        return nomeDisciplina + " " + tempoGasto + "/" + tempoEsperado;
    }
}
