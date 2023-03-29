import java.util.*;

/**
 * escrever documentacao
 *
 * @author Eliane Tamara - 122110693
 */

public class RegistroResumos {

    private String[] titulos;
    private String[] resumos;

	/**
	 * Constrói
	 *
	 * @param numeroDeResumos o número de resumos que vão ser registrados
	 */
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
    			resumos[i] = titulos[i] + ": " + conteudo;
    			break;
    		}
    	}
    }

	public String[] pegaResumos() {
        return resumos;
    }

    public String imprimeResumos() {
    	String saida = "- " + conta() + " resumo(s) cadastrado(s)\n";
    	String resumos = "- ";
    	for(int i = 0; i < conta(); i++) {
    		if(i == (conta()-1)) {
    			resumos += titulos[i];
    		}else {
    			resumos += titulos[i] + " | ";
    		}
    	}
    	saida += resumos;
        return saida;
    }

    public boolean temResumo(String tema) {
    	for(String tituloResumo: titulos) {
    		if(tituloResumo != null && tituloResumo.equals(tema)) {
    			return true;
    		}
    	}
        return false;
    }

    public int conta() {
        return contador;
    }
}
