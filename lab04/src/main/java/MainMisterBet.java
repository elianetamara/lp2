import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Classe Main para interação do usuaŕio
 * com o sistema Mr Bet
 *
 * @author eliane - 122110693
 */

public class MainMisterBet {

    public static void main(String[] args) {
        SistemaMrBet sistemaMrBet = new SistemaMrBet();
        
        Scanner scanner = new Scanner(System.in);
        String escolha;
        while (true) {
            escolha = menu(scanner);
            comando(escolha, sistemaMrBet, scanner);
        }

    }

    private static String menu(Scanner scanner) {
        System.out.print(
                "\n---\nMENU\n" +
                        "(M)Minha inclusão de times\n" +
                        "(R)Recuperar time\n" +
                        "(.)Adicionar campeonato\n" +
                        "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
                        "(E)Exibir campeonatos que o time participa\n" +
                        "(T)Tentar a sorte e status\n" +
                        "(H) Histórico\n" +
                        "(!)Já pode fechar o programa!\n" +
                        "Opção> ");
        return scanner.nextLine().toUpperCase();
    }

    private static void comando(String opcao, SistemaMrBet sistemaMrBet, Scanner scanner) {
        switch (opcao) {
            case "M":
                incluirTime(sistemaMrBet, scanner);
                break;
            case "R":
                recuperaTime(sistemaMrBet, scanner);
                break;
            case ".":
                adicionaCampeonato(sistemaMrBet, scanner);
                break;
            case "B":
                incluirOuVerificarTimeCamp(sistemaMrBet, scanner);
                break;
            case "E":
                exibeCampeonatosTime(sistemaMrBet, scanner);
                break;
            case "T":
                sorteOuStatus(sistemaMrBet, scanner);
                break;
            case "H":
                historico(sistemaMrBet);
                break;
            case "!":
                sai();
                break;
            default:
                throw new IllegalArgumentException("Opção inválida!");
        }
    }

    private static void sai() {
        System.out.print("\nPor hoje é só pessoal!");
        System.exit(0);
    }

    private static void historico(SistemaMrBet sistemaMrBet) {
        System.out.println("Participação mais frequente em campeonatos");
        System.out.print(sistemaMrBet.recuperaMaxParticipacao());
        System.out.println("Ainda não participou de campeonato");
        System.out.print(sistemaMrBet.recuperaMinParticipacao());
        System.out.println("Popularidade em apostas");
        System.out.print(sistemaMrBet.recuperaPopularidade());
    }

    private static void sorteOuStatus(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("\n(A)Apostar ou (S)Status das Apostas? ");
        String opcao = scanner.nextLine();
        switch (opcao.toUpperCase()) {
            case "A":
                apostarTime(sistemaMrBet, scanner);
                break;
            case "S":
                statusApostas(sistemaMrBet);
                break;
        }
    }

    private static void statusApostas(SistemaMrBet sistemaMrBet) {
        System.out.print(sistemaMrBet.recuperaStatusApostas());
    }

    private static void apostarTime(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Campeonato: ");
        String campeonato = scanner.nextLine();
        System.out.println("Colocação: ");
        int colocacao = Integer.parseInt(scanner.nextLine());
        System.out.println("Valor: ");
        String valor = scanner.nextLine();
        try {
            System.out.print(sistemaMrBet.apostaTime(codigo, campeonato, colocacao, valor));
        }catch (NoSuchElementException | IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }

    private static void exibeCampeonatosTime(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("Time: ");
        String time = scanner.nextLine();
        try {
            System.out.print(sistemaMrBet.recuperaCampeonatosTime(time));
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    private static void incluirOuVerificarTimeCamp(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("\n(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
        String opcao = scanner.nextLine();
        switch (opcao.toUpperCase()) {
            case "I":
                incluirTimeCampeonato(sistemaMrBet, scanner);
                break;
            case "V":
                verificarTimeCampeonato(sistemaMrBet, scanner);
                break;
        }
    }

    private static void verificarTimeCampeonato(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Campeonato: ");
        String campeonato = scanner.nextLine();
        try{
            System.out.print(sistemaMrBet.recuperaTimeCampeonato(campeonato, codigo));
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }

    }

    private static void incluirTimeCampeonato(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Campeonato: ");
        String campeonato = scanner.nextLine();
        try{
            System.out.print(sistemaMrBet.cadastraTimeCampeonato(campeonato, codigo));
        }catch (IllegalArgumentException | NoSuchElementException | IllegalStateException e){
            System.out.print(e.getMessage());
        }
    }

    private static void adicionaCampeonato(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("Campeonato: ");
        String campeonato = scanner.nextLine();
        System.out.println("Participantes: ");
        int participantes = Integer.parseInt(scanner.nextLine());
        try{
            System.out.print(sistemaMrBet.cadastraCampeonato(campeonato, participantes));
        }catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }

    private static void recuperaTime(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        try{
            System.out.print(sistemaMrBet.recuperaTime(codigo));
        }catch (IllegalArgumentException | NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    private static void incluirTime(SistemaMrBet sistemaMrBet, Scanner scanner) {
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Mascote: ");
        String mascote = scanner.nextLine();
        try{
            System.out.print(sistemaMrBet.cadastraTime(codigo, nome, mascote));
        }catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }
}
