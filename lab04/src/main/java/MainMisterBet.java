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
        System.out.println(
                "\n---\nMENU\n" +
                        "(M)Minha inclusão de times\n" +
                        "(R)Recuperar time\n" +
                        "(.)Adicionar campeonato\n" +
                        "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
                        "(E)Exibir campeonatos que o time participa\n" +
                        "(T)Tentar a sorte e status\n" +
                        "(!)Já pode fechar o programa!\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
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
        System.out.println("\nPor hoje é só pessoal!");
        System.exit(0);
    }

    private static void sorteOuStatus(MrBet mrBet, Scanner scanner) {
        System.out.print("\n(A)Apostar ou (S)Status das Apostas? ");
        String opcao = scanner.next();
        switch (opcao) {
            case "A":
                apostarTime(mrBet, scanner);
                break;
            case "S":
                statusApostas(mrBet, scanner);
                break;
        }
    }

    private static void statusApostas(MrBet mrBet, Scanner scanner) {
    }

    private static void apostarTime(MrBet mrBet, Scanner scanner) {
    }

    private static void exibeCampeonatosTime(MrBet mrBet, Scanner scanner) {
    }

    private static void incluirOuVerificarTimeCamp(MrBet mrBet, Scanner scanner) {
        System.out.print("\n(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
        String opcao = scanner.next();
        switch (opcao) {
            case "I":
                incluirTimeCampeonato(mrBet, scanner);
                break;
            case "V":
                verificarTimeCampeonato(mrBet, scanner);
                break;
        }
    }

    private static void verificarTimeCampeonato(MrBet mrBet, Scanner scanner) {
    }

    private static void incluirTimeCampeonato(MrBet mrBet, Scanner scanner) {
    }

    private static void adicionaCampeonato(MrBet mrBet, Scanner scanner) {
    }

    private static void recuperaTime(MrBet mrBet, Scanner scanner) {
    }

    private static void incluirTime(MrBet mrBet, Scanner scanner) {
    }
}
