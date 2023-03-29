import java.util.*;

/**
 * escrever documentacao
 *
 * @author Eliane Tamara
 */

public class RegistroResumos {

    private String[] titulos;
    private String[] resumos;

    public RegistroResumos(int numeroDeResumos){
    	titulos = new String[numeroDeResumos];
    	resumos = new String[numeroDeResumos];

    }

    private int contador;
    public void adiciona(String tema, String conteudo) {
    	contador++;
    	for(int i = 0; i < resumos.length; i++) {
    		if(resumos[i] == null) {
    			titulos[i] = tema;
    			resumos[i] = titulos[i] + ": " + resumos[i];
    		}
    	}
    }

	public String[] pegaResumos() {
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

    public boolean temResumo(String tema) {
    	for(String tituloResumo: titulos) {
    		if(tituloResumo.equals(tema)) {
    			return true;
    		}
    	}
        return false;
    }

    public int conta() {
        return contador;
    }
}
