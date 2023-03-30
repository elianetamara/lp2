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
    private String[] conteudos;

	/**
	 * Constrói um registro de resumo a partir do 
	 * número de resumos que o aluno irá cadastrar
	 *
	 * @param numeroDeResumos o número de resumos que vão ser registrados
	 */
	public RegistroResumos(int numeroDeResumos){
    	titulos = new String[numeroDeResumos];
    	conteudos = new String[numeroDeResumos];

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
    void adiciona(String tema, String conteudo) {
    	contadorDeResumos++;
    	for(int i = 0; i < conteudos.length; i++) {
    		if(conteudos[i] == null) {
    			titulos[i] = tema;
    			conteudos[i] = conteudo;
    			break;
    		}
    	}
    }

    /**
     * Devolve a lista de resumos
     *
     * @return os resumos adicionados
     */
	String[] pegaResumos() {
		String[] resumos = new String[titulos.length];
		for(int i = 0; i < titulos.length; i++){
			resumos[i] = titulos[i] + ": " + conteudos[i];
		}
        return resumos;
    }
	
	/**
     * Retorna uma String contendo informações sobre
     * os resumos.
     *
     * @return uma String contendo o número de resumos 
     * cadastrados, e seus títulos
     */
    String imprimeResumos() {
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
    boolean temResumo(String tema) {
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
     * @return numero de resumos
     * 
     */
    int conta() {
        return contadorDeResumos;
    }

	/**
	 * Procura dentre os resumos se existe algum
	 * sobre aquele tema cadastrado
	 *
	 * @param chaveDeBusca trecho de texto a ser procurado
	 * @return lista de conteúdos achados na busca
	 */
	/*String[] busca(String chaveDeBusca){
		String[] achados = new String[conteudos.length];
		for(int i = 0; i < conteudos.length; i++) {
			int conteudo = Character.toLowerCase(conteudos[i]);
			chaveDeBusca = Character.toLowerCase(chaveDeBusca);
			if (conteudo.contains(chaveDeBusca)) {
				achados[i] = conteudos[i];
			}
		}
		return achados;
	}*/
}
