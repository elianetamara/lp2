package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;

	private Contato[] contatos; //apenas uma simplificacao de contato

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {

		this.contatos = new Contato[TAMANHO_AGENDA];
		for (int i = 0; i < TAMANHO_AGENDA; i++) {
			contatos[i] = new Contato();
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
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		contatos[posicao-1].setNome(nome);
		contatos[posicao-1].setSobrenome(sobrenome);
		contatos[posicao-1].setTelefone(telefone);
		contatos[posicao-1].setPosicao(posicao);
	}

	private int numContatos = 0;

	/**
	 * Conta a quantidade de contatos cadastrados
	 *
	 * @return  o numero de contatos
	 */
	public int conta(){
		for (int i = 0; i < contatos.length; i++) {
			if(contatos[i].getNome() != ""){
				numContatos++;
			}
		}
		return numContatos;
	}

}
