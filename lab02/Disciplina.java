import java.util.Arrays;

/**
 * escrever documentacao
 *
 * @author Eliane Tamara
 */

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas = new double[4];

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void cadastraHoras(int i) {
        horasEstudo += i;
    }

    public void cadastraNota(int i, double v) {
        notas[i-1] = v;
    }

    public double calculaMedia(double[] notas) {
        int soma = 0;
        for(double nota: notas){
            soma += nota;
        }
        return soma/4;
    }

    public boolean aprovado() {
        double media = calculaMedia(notas);
        if (media >= 7.0) {
            return true;
        }else {
            return false;
    }
}

    @Override
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia(notas) + " " + Arrays.toString(notas);
    }
}
