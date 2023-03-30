import java.util.*;

/**
 * Mantém registro dos resumos cadastrados pelo
 * aluno de determinado assunto
 *
 * @author Eliane Tamara - 122110693
 */

public class RegistroResumos {

	/**
     *  Lista de Strings com os títulos dos resumos
     */
    private String[] titulos;
    /**
     *  Lista de Strings contendo os resumos
     */
    private String[] resumos;

	/**
	 * Constrói um registro de resumo a partir do 
	 * número de resumos que o aluno irá cadastrar
	 *
	 * @param numeroDeResumos o número de resumos que vão ser registrados
	 */
	public RegistroResumos(int numeroDeResumos){
    	titulos = new String[numeroDeResumos];
    	resumos = new String[numeroDeResumos];

    }
	
	/**
     *  Conta quantos resumos foram adicionados
     */
    private int contadorDeResumos;
    
    /**
     * Adiciona um resumo a lista
     *
     * @param tema o título/assunto do resumo
     * @param conteudo o corpo do resumo
     */
    public void adiciona(String tema, String conteudo) {
    	contadorDeResumos++;
    	for(int i = 0; i < resumos.length; i++) {
    		if(resumos[i] == null) {
    			titulos[i] = tema;
    			resumos[i] = titulos[i] + ": " + conteudo;
    			break;
    		}
    	}
    }

    /**
     * Devolve a lista de resumos
     *
     * @return os resumos adicionados
     */
	public String[] pegaResumos() {
        return resumos;
    }
	
	/**
     * Retorna uma String contendo informações sobre
     * os resumos.
     *
     * @return uma String contendo o número de resumos 
     * cadastrados, e seus títulos
     */
    public String imprimeResumos() {
    	String impressao = conta() + " resumo(s) cadastrado(s)\n- ";
    	for(int i = 0; i < conta(); i++) {
    		if(i == (conta()-1)) {
    			impressao += titulos[i];
    		}else {
    			impressao += titulos[i] + " | ";
    		}
    	}
        return impressao;
    }

    /**
     * Procura dentre os resumos se existe algum
     * sobre aquele tema cadastrado
     * 
     * @param tema titulo a ser procurado
     * @return true caso tenha resumo, false caso contrário
     */
    public boolean temResumo(String tema) {
    	for(String titulo: titulos) {
    		if(titulo != null && titulo.equals(tema)) {
    			return true;
    		}
    	}
        return false;
    }

    /**
     * Informa quantos resumos foram cadastrados
     * 
     * @
     * eturn numero de resumos
     * 
     */
    public int conta() {
        return contadorDeResumos;
    }
}
