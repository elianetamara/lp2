package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author eliane - 122110693
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;

	private Contato[] contatos;

	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		for (int i = 0; i < TAMANHO_AGENDA; i++) {
			contatos[i] = new Contato();
		}
		this.favoritos = new Contato[10];
		for (int i = 0; i < favoritos.length; i++) {
			favoritos[i] = new Contato();
		}
	}

	/**
	 * Acessa a lista de contatos mantida.
	 *
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 *
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao-1];
	}

	/**
	 *
	 * @param posicao Posição do contato.
	 * @return String que represneta o contato
	 * @throws IllegalArgumentException Se a posição for inválida
	 */
	public String exibeContato(int posicao) throws IllegalArgumentException{
		if (posicao < 1 || posicao > 100){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		for (Contato c : getFavoritos()) {
			if (c.equals(getContato(posicao).getNome(), getContato(posicao).getSobrenome())){
				return "❤️ " + getContato(posicao).toString();
			}
		}
		return getContato(posicao).toString();
	}

	/**
	 * Retorna lista de contatos formatados da agenda.
	 *
	 */
	public String[] listaContatos() {
		Contato[] contatos = getContatos();
		String[] listaContatos = new String[conta(contatos)];
		for (int i = 0; i < listaContatos.length; i++) {
			if (contatos[i].getNome().equals("")) {
				listaContatos[i] = formataContato(i+1, contatos[i].getNome());
			}
		}
		return listaContatos;
	}

	/**
	 * Retorna lista de contatos favoritos formatados da agenda.
	 *
	 */
	public String[] listaFavoritos() {
		Contato[] favoritos = getFavoritos();
		String[] listaFavoritos = new String[conta(favoritos)];
		for (int i = 0; i < listaFavoritos.length; i++) {
			if (favoritos[i].getNome().equals("")) {
				listaFavoritos[i] = formataContato(i+1, favoritos[i].getNome());
			}
		}
		return listaFavoritos;
	}

	private Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Formata um contato para impressão na interface.
	 *
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @throws IllegalArgumentException se entradas forem inválidas
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) throws IllegalArgumentException {
		if (posicao < 1 || posicao > 100){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if (nome.isBlank() || telefone.isBlank()){
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
		for (Contato c: getContatos()) {
			if(c.equals(nome, sobrenome)){
				throw new IllegalArgumentException("CONTATO JA CADASTRADO");
			}
		}
		contatos[posicao-1].setNome(nome);
		contatos[posicao-1].setSobrenome(sobrenome);
		contatos[posicao-1].setTelefone(telefone);
		contatos[posicao-1].setPosicao(posicao);
	}

	/**
	 * Cadastra um contato favorito em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao Posição do contato.
	 * @param contato o contado a ser favoritado
	 */
	public void cadastraFavorito(Contato contato, int posicao) throws IllegalArgumentException{
		if(posicao < 1 || posicao > 10){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		for (Contato c: favoritos) {
			if(c.equals(contato.getNome(), contato.getSobrenome())){
				throw new IllegalArgumentException("CONTATO JÁ É FAVORITO");
			}
		}
		favoritos[posicao-1].setNome(contato.getNome());
		favoritos[posicao-1].setSobrenome(contato.getSobrenome());
		favoritos[posicao-1].setTelefone(contato.getTelefone());
		favoritos[posicao-1].setPosicao(posicao);
		System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!");
	}

	private int numContatos = 0;

	/**
	 * Conta a quantidade de contatos cadastrados
	 *
	 * @return  o numero de contatos
	 */
	public int conta(Contato[] lista){
		for (Contato c: lista) {
			if(c.getNome().equals("")){
				numContatos++;
			}
		}
		return numContatos;
	}

	/**
	 * Remove contato da lista de favoritos
	 *
	 * @param posicao a posição do contato a ser removido
	 */

	public void removeFavorito(int posicao) {
		if(posicao < 1 || posicao > 10){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		favoritos[posicao-1].setNome("");
		favoritos[posicao-1].setSobrenome("");
		favoritos[posicao-1].setTelefone("");
	}
}
