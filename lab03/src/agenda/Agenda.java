package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author eliane - 122110693
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;

	private static final int TAMANHO_FAVORITOS = 10;

	private Contato[] contatos;

	private Contato[] favoritos;

	private int numContatos = 0;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		for (int i = 0; i < TAMANHO_AGENDA; i++) {
			contatos[i] = new Contato( "", "", "");
		}
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
		for (int i = 0; i < TAMANHO_FAVORITOS; i++) {
			favoritos[i] = new Contato("", "", "");
		}
	}

	private Contato[] getContatos() {
		return this.contatos.clone();
	}

	private Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	public Contato getContato(int posicao) {
		return contatos[posicao-1];
	}

	private Contato getFavorito(int posicao) {
		return favoritos[posicao-1];
	}

	/**
	 * Retorna lista de contatos formatados da agenda.
	 *
	 */
	public String[] listaContatos() {
		String[] listaContatos = new String[conta(getContatos())];
		for (int i = 0; i < listaContatos.length; i++) {
			if (contatos[i].getNome().equals("")) {
				listaContatos[i] = formataContato(i+1, contatos[i].getNome());
			}
		}
		return listaContatos;
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
		if (posicao < 1 || posicao > TAMANHO_AGENDA){
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
		contatos[posicao-1] = new Contato(nome, sobrenome, telefone);
	}

	/**
	 *
	 * @param posicao Posição do contato.
	 * @return String que represneta o contato
	 * @throws IllegalArgumentException Se a posição for inválida
	 */
	public String exibeContato(int posicao) throws IllegalArgumentException{
		if (posicao < 1 || posicao > TAMANHO_AGENDA){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		return getContato(posicao).toString();
	}

	/**
	 * Conta a quantidade de contatos cadastrados
	 *
	 * @return  o numero de contatos
	 */
	private int conta(Contato[] lista){
		for (Contato c: lista) {
			if(c.getNome().equals("")){
				numContatos++;
			}
		}
		return numContatos;
	}

	/**
	 * Cadastra um contato favorito em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao Posição do contato.
	 * @param contato o contado a ser favoritado
	 * @throws IllegalArgumentException Se a posição for inválida
	 */
	public void cadastraFavorito(Contato contato, int posicao) throws IllegalArgumentException{
		if(posicao < 1 || posicao > TAMANHO_FAVORITOS){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if(contato.isEhFavorito()){
			throw new IllegalArgumentException("CONTATO JÁ É FAVORITO");
		}
		contato.setEhFavorito(true);
		favoritos[posicao-1] = new Contato(contato.getNome(), contato.getSobrenome(), contato.getTelefone());
		System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!");
	}

	/**
	 * Retorna lista de contatos favoritos formatados da agenda.
	 *
	 */
	public String[] listaFavoritos() {
		String[] listaFavoritos = new String[conta(getFavoritos())];
		for (int i = 0; i < listaFavoritos.length; i++) {
			if (favoritos[i].getNome().equals("")) {
				listaFavoritos[i] = formataContato(i+1, favoritos[i].getNome());
			}
		}
		return listaFavoritos;
	}

	/**
	 * Remove contato da lista de favoritos
	 *
	 * @param posicao a posição do contato a ser removido
	 * @throws IllegalArgumentException Se a posição for inválida
	 */
	public void removeFavorito(int posicao) throws IllegalArgumentException{
		if(posicao < 1 || posicao > TAMANHO_FAVORITOS){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		Contato contato = getFavorito(posicao);
		if (contato.isEhFavorito()) {
			favoritos[posicao - 1] =  new Contato("", "", "");
			contato.setEhFavorito(false);
		}
	}

	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}
}
