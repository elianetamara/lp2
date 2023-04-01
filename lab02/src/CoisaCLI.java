package src;

import java.util.Scanner;

public class CoisaCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        carregaMenu(sc);
    }

    static void carregaMenu(Scanner entrada){
        System.out.println(opcoesMenu);
        String atividade = entrada.nextLine();
        switch (atividade) {
            case OpcoesMenu.TEMPOONLINE:
                menuTempoOnline(entrada);
                break;

            case OpcoesMenu.DESCANSO:
                menuDescanso(entrada);
                break;

            case OpcoesMenu.DISCIPLINA:
                menuDisciplina(entrada);
                break;

            case OpcoesMenu.RESUMOS:
                menuResumos(entrada);
                break;

            default:
                //perguntar se o usuario deseja sair
        }
    }

    private static void menuTempoOnline(Scanner entrada) {
        System.out.println(opcoesMenuTempoOnline);
        String comando = entrada.nextLine();
        switch (comando) {
            case OpcoesMenu.HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                //adicionaTempoOnline(horas);
                break;
            case OpcoesMenu.META:
                //atingiuMetaTempoOnline()
                break;
        }
    }

    private static void menuDescanso(Scanner entrada) {
        System.out.println(opcoesMenuDescanso);
        String comando = entrada.nextLine();
        switch (comando) {
            case OpcoesMenu.HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                //comando
                break;
            case OpcoesMenu.EMOJI:
                String emoji = entrada.nextLine();
                //comando
                break; 
            case OpcoesMenu.SEMANAS:
                int semanas = entrada.nextInt();
                //comando
                break;
            case OpcoesMenu.STATUS:
                //comando
                break;
        }
    }

    private static void menuDisciplina(Scanner entrada) {
        System.out.println(opcoesMenuDisciplina);
        String comando = entrada.nextLine();
        switch (comando) {
            case OpcoesMenu.HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                //comando
                break;
            case OpcoesMenu.NOTA:
                System.out.println("Digite qual nota e o valor dela:");
                int numNota = entrada.nextInt();
                double nota = entrada.nextDouble();
                //comando
                break;
            case OpcoesMenu.APROVADO:
                //comando
                break;
        }
    }

    private static void menuResumos(Scanner entrada) {
        System.out.println(opcoesMenuResumos);
        String comando = entrada.nextLine();
        switch (comando) {
            case OpcoesMenu.ADICIONA:
                System.out.println("Digite o título e o conteúdo do resumo:");
                String titulo = entrada.next();
                String conteudo = entrada.next();
                //comando
                break;
            case OpcoesMenu.PEGA:
                //comando
                break;
            case OpcoesMenu.IMPRIME:
                //comando
                break;
            case OpcoesMenu.TEM:
                System.out.println("Digite o título do resumo:");
                String tituloPesquisa = entrada.next();
                //comando
                break;
            case OpcoesMenu.CONTA:
                //comando
                break;
            case OpcoesMenu.BUSCA:
                System.out.println("Digite a palavra a ser procurada:");
                String palavra = entrada.next();
                //comando
                break;
        }
    }

    static String opcoesMenu = "Bem vindo ao coISA! Selecione uma das atividades abaixo:\n" +
            "- Registro de Tempo Online -> TEMPOONLINE\n" +
            "- Descanso -> DESCANSO\n" +
            "- Disciplina -> DISCIPLINA\n" +
            "- Registro de Resumos -> RESUMOS";


    static String opcoesMenuTempoOnline = "Registro de Tempo Online:\n" +
            "- HORAS -> adicionar <num> horas\n" +
            "- META -> verificar se atingiu a meta de tempo";

    static String opcoesMenuDescanso = "Descanso:\n" +
            "- HORAS -> definir horas de descanso\n" +
            "- EMOJI -> definir emoji\n" +
            "- SEMANAS -> define número de semanas\n" +
            "- STATUS -> ver status geral";
    
    static String opcoesMenuDisciplina = "Disciplina:\n" +
            "- HORAS -> cadastra horas de estudo\n" +
            "- NOTA -> cadastra notas\n" +
            "- APROVADO -> verifica se o aluno foi aprovado";


    static String opcoesMenuResumos = "Registro de Resumos:\n" +
            "- ADICIONA -> adiciona resumo\n" +
            "- PEGA -> pega lista de resumos\n" +
            "- IMPRIME -> informações sobre os resumos\n" +
            "- TEM -> procura resumo sobre determinado tema\n" +
            "- CONTA -> informa quantos resumos foram cadastrados\n" +
            "- BUSCA -> procura resumos com determinada palavra";
}
