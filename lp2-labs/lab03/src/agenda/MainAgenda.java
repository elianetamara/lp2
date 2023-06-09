package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author eliane - 122110693
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha;
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" +
						"(C)adastrar Contato\n" +
						"(L)istar Contatos\n" +
						"(E)xibir Contato\n" +
						"(M)udar Telefone\n" +
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(R)emover\n" +
						"(S)air\n" +
						"\n" +
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
			case "C":
				cadastraContato(agenda, scanner);
				break;
			case "L":
				listaContatos(agenda);
				break;
			case "E":
				exibeContato(agenda, scanner);
				break;
			case "M":
				mudarTelefone(agenda, scanner);
				break;
			case "S":
				sai();
				break;
			case "F":
				exibeFavoritos(agenda);
				break;
			case "A":
				adicionarFavorito(agenda, scanner);
				break;
			case "R":
				remover(agenda, scanner);
				break;
			default:
				System.out.println("Opção inválida!");
		}
	}

	private static void remover(Agenda agenda, Scanner scanner) {
		System.out.print("\nDe agenda - 1\nDos favoritos - 2\n> ");
		int opcao = scanner.nextInt();
		switch (opcao) {
			case 1:
				removerAgenda(agenda, scanner);
				break;
			case 2:
				removerFavorito(agenda, scanner);
				break;
		}
	}

	private static void removerAgenda(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		try {
			agenda.removeContato(posicao);
		}catch (IndexOutOfBoundsException | IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

	private static void mudarTelefone(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		System.out.print("\nNovo Telefone> ");
		String novoTelefone = scanner.next();
		try{
			agenda.mudarTelefone(posicao, novoTelefone);
		}catch (IllegalArgumentException | NullPointerException | IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}

	}

	private static void removerFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		try {
			agenda.removeFavorito(posicao);
		}catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	}

	private static void adicionarFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int indiceContato = scanner.nextInt();
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		try{
			System.out.println(agenda.cadastraFavorito(agenda.getContato(indiceContato), posicao));
		}catch (IndexOutOfBoundsException | IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

	private static void exibeFavoritos(Agenda agenda) {
		String[] listaFavoritos = agenda.listaFavoritos();
		for (String s : listaFavoritos) {
			if(s != null) {
				System.out.println(s);
			}
		}
	}

	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		String[] listaContatos = agenda.listaContatos();
		for (String s: listaContatos) {
			System.out.println(s);
		}
	}

	private static void exibeContato(Agenda agenda, Scanner scanner){
		System.out.print("\nContato> ");
		int posicao = scanner.nextInt();
		try {
			System.out.println(agenda.exibeContato(posicao));
		}catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	}

	private static void cadastraContato(Agenda agenda, Scanner scanner){
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		System.out.print("\nNome> ");
		String nome = scanner.next();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.next();
		System.out.print("\nTelefone> ");
		String telefone = scanner.next();
		try {
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		}catch (IllegalArgumentException | NullPointerException | IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	}

	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv.
	 *
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();

		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
