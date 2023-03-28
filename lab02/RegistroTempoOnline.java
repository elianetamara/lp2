/**
 * escrever documentacao
 *
 * @author Eliane Tamara
 */

public class RegistroTempoOnline {

    private String nomeDisciplina;
    private int tempoGasto;
    private int tempoEsperado;

    public RegistroTempoOnline(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = 60 * 2;

    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoEsperado;

    }
    public void adicionaTempoOnline(int i) {
       tempoGasto += i;
    }

    public boolean atingiuMetaTempoOnline() {
        if(tempoGasto >= tempoEsperado){
            return true;
        }else {
            return false;
        }
    }

    public int getTempoEsperado() {
        return tempoEsperado;
    }

    public int getTempoGasto() { return tempoGasto; }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    @Override
    public String toString(){
        return getNomeDisciplina() + " " + getTempoGasto() + "/" + getTempoEsperado();
    }
}
