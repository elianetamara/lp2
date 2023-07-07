package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Mantém registro dos resumos cadastrados pelo
 * aluno de determinado assunto
 *
 * @author Eliane Tamara - 122110693
 */

public class RegistroResumos {

	/**
     *  Lista de Resumos
     */
    private Resumos[] ListaResumos;

	/**
	 * Constrói uma lista de resumos a partir do
	 * número de resumos que o aluno irá cadastrar
	 *
	 * @param numeroDeResumos o número de resumos que vão ser registrados
	 */
	public RegistroResumos(int numeroDeResumos){
		ListaResumos = new Resumos[numeroDeResumos];
		for (int i = 0; i < ListaResumos.length; i++) {
			ListaResumos[i] = new Resumos();
		}

    }

	/**
     *  Conta quantos resumos foram adicionados
     */
	private int indiceResumos = 0;

	/**
     * Adiciona um resumo a lista
     *
     * @param tema o título/assunto do resumo
     * @param conteudo o corpo do resumo
     */
    void adiciona(String tema, String conteudo) {
		if(indiceResumos < ListaResumos.length){
			ListaResumos[indiceResumos].setTitulo(tema);
			ListaResumos[indiceResumos].setConteudo(conteudo);
		}else {
			indiceResumos = 0;
			ListaResumos[indiceResumos].setTitulo(tema);
			ListaResumos[indiceResumos].setConteudo(conteudo);
		}
		indiceResumos++;
    }

    /**
     * Devolve a lista de resumos
     *
     * @return os resumos adicionados
     */
	String[] pegaResumos() {
		String[] resumos = new String[conta()];
		for(int i = 0; i < conta(); i++){
			resumos[i] = ListaResumos[i].getTitulo() + ": " + ListaResumos[i].getConteudo();
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
		String saida = conta() + " resumo(s) cadastrado(s)\n- ";
		for(int i = 0; i < conta(); i++) {
			if(i == (conta()-1)) {
				saida += ListaResumos[i].getTitulo();
			}else {
				saida += ListaResumos[i].getTitulo() + " | ";
			}
		}
        return saida;
    }

    /**
     * Procura dentre os resumos se existe algum
     * sobre aquele tema cadastrado
     * 
     * @param tema titulo a ser procurado
     * @return true caso tenha resumo, false caso contrário
     */
    boolean temResumo(String tema) {
		for(int i = 0; i < conta(); i++) {
			String titulo = ListaResumos[i].getTitulo();
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
		int contadorDeResumos = 0;
		for (Resumos resumo: ListaResumos) {
			if(resumo.getTitulo() != ""){
				contadorDeResumos++;
			}
		}
        return contadorDeResumos;
    }

	/**
	 * Procura dentre os resumos se existe algum
	 * sobre aquele tema cadastrado
	 *
	 * @param chaveDeBusca trecho de texto a ser procurado
	 * @return lista de conteúdos achados na busca
	 */
	String[] busca(String chaveDeBusca){
		List<String> achados = new ArrayList<>();
		int numAchados = 0;
		for(int i = 0; i < conta(); i++) {
			if ((ListaResumos[i].getConteudo().toLowerCase()).contains(chaveDeBusca.toLowerCase())) {
				achados.add(ListaResumos[i].getConteudo());
				numAchados++;
			}
		}
		String[] saida = achados.toArray(new String[numAchados]);
		Arrays.sort(saida);
		return saida;
	}

}
