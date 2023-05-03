import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainMisterBet {

    public static void main(String[] args) {
        MrBet mrBet = new MrBet();
        
        Scanner scanner = new Scanner(System.in);
        String escolha;
        while (true) {
            escolha = menu(scanner);
            comando(escolha, mrBet, scanner);
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
                        "(!)Já pode fechar o programa!\n" +
                        "Opção> ");
        return scanner.nextLine().toUpperCase();
    }

    private static void comando(String opcao, MrBet mrBet, Scanner scanner) {
        switch (opcao) {
            case "M":
                incluirTime(mrBet, scanner);
                break;
            case "R":
                recuperaTime(mrBet, scanner);
                break;
            case ".":
                adicionaCampeonato(mrBet, scanner);
                break;
            case "B":
                incluirOuVerificarTimeCamp(mrBet, scanner);
                break;
            case "E":
                exibeCampeonatosTime(mrBet, scanner);
                break;
            case "T":
                sorteOuStatus(mrBet, scanner);
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

    private static void sorteOuStatus(MrBet mrBet, Scanner scanner) {
        System.out.print("\n(A)Apostar ou (S)Status das Apostas? ");
        String opcao = scanner.nextLine();
        switch (opcao.toUpperCase()) {
            case "A":
                apostarTime(mrBet, scanner);
                break;
            case "S":
                statusApostas(mrBet);
                break;
        }
    }

    private static void statusApostas(MrBet mrBet) {
        System.out.print(mrBet.recuperaStatusApostas());
    }

    private static void apostarTime(MrBet mrBet, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Campeonato: ");
        String campeonato = scanner.nextLine();
        System.out.print("Colocação: ");
        int colocacao = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor: ");
        String valor = scanner.nextLine();
        try {
            System.out.print(mrBet.apostaTime(codigo, campeonato, colocacao, valor));
        }catch (NoSuchElementException | IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }

    private static void exibeCampeonatosTime(MrBet mrBet, Scanner scanner) {
        System.out.print("Time: ");
        String time = scanner.nextLine();
        try {
            System.out.print(mrBet.recuperaCampeonatosTime(time));
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    private static void incluirOuVerificarTimeCamp(MrBet mrBet, Scanner scanner) {
        System.out.print("\n(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
        String opcao = scanner.nextLine();
        switch (opcao.toUpperCase()) {
            case "I":
                incluirTimeCampeonato(mrBet, scanner);
                break;
            case "V":
                verificarTimeCampeonato(mrBet, scanner);
                break;
        }
    }

    private static void verificarTimeCampeonato(MrBet mrBet, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Campeonato: ");
        String campeonato = scanner.nextLine();
        try{
            System.out.print(mrBet.recuperaTimeCampeonato(campeonato, codigo));
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }

    }

    private static void incluirTimeCampeonato(MrBet mrBet, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Campeonato: ");
        String campeonato = scanner.nextLine();
        try{
            System.out.print(mrBet.cadastraTimeCampeonato(campeonato, codigo));
        }catch (IllegalArgumentException | NoSuchElementException | IllegalStateException e){
            System.out.print(e.getMessage());
        }
    }

    private static void adicionaCampeonato(MrBet mrBet, Scanner scanner) {
        System.out.print("Campeonato: ");
        String campeonato = scanner.nextLine();
        System.out.print("Participantes: ");
        int participantes = Integer.parseInt(scanner.nextLine());
        try{
            System.out.print(mrBet.cadastraCampeonato(campeonato, participantes));
        }catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }

    private static void recuperaTime(MrBet mrBet, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        try{
            System.out.print(mrBet.recuperaTime(codigo));
        }catch (IllegalArgumentException | NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    private static void incluirTime(MrBet mrBet, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Mascote: ");
        String mascote = scanner.nextLine();
        try{
            System.out.print(mrBet.cadastraTime(codigo, nome, mascote));
        }catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }
}
