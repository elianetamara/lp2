import java.util.*;

/**
 * escrever documentacao
 *
 * @author Eliane Tamara
 */

public class RegistroResumos {

    private int numeroDeResumos;
    private String[] titulos;
    private String[] conteudo;

    public RegistroResumos(int numeroDeResumos){
    	this.numeroDeResumos = numeroDeResumos;
    	titulos = new String[this.numeroDeResumos];
    	conteudo = new String[this.numeroDeResumos];

    }

    private int contador;
    public void adiciona(String classes, String s) {
    	contador++;
    	for(int i = 0; i < titulos.length; i++) {
    		titulos[i] = classes;
    		conteudo[i] = s;
    	}
    }

	public String[] pegaResumos() {
    	String[] resumos = new String[titulos.length];
    	for(int i = 0; i < 1; i++) {
    		String resumo = titulos[i] + ": " + conteudo[i];
        	resumos[i] = resumo;	
    	}
        return resumos;
    }

    public String imprimeResumos() {
    	String saida = "- " + conta() + " resumo(s) cadastrado(s)\n";
    	String resumos = "- ";
    	for(String titulo: titulos) {
    		resumos += titulo + " | ";
    	}
    	saida += resumos;
        return saida;
    }

    public boolean temResumo(String classes) {
    	for(String tituloResumo: titulos) {
    		if(tituloResumo.equals(classes)) {
    			return true;
    		}
    	}
        return false;
    }

    public int conta() {
        return contador;
    }
}
