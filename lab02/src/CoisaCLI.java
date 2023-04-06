package src;

/**
 * Classe que representa a interação com o usuário
 *
 * @author Eliane Tamara - 122110693
 */

import java.util.Scanner;

public class CoisaCLI {
    public static void main(String[] args) {
        carregaMenu();
    }

    static void carregaMenu(){
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }
    static void menu(Scanner entrada){
            System.out.println(opcoesMenu);
            OpcoesMenu opcao = OpcoesMenu.valueOf(entrada.nextLine());
            switch (opcao) {
                case TEMPOONLINE:
                    RegistroTempoOnline tempoOnline = new RegistroTempoOnline("LP2", 30);
                    menuTempoOnline(entrada, tempoOnline);
                    break;

                case DESCANSO:
                    Descanso descanso = new Descanso();
                    menuDescanso(entrada, descanso);
                    break;

                case DISCIPLINA:
                    Disciplina disciplina = new Disciplina("PROGRAMACAO 2");
                    menuDisciplina(entrada, disciplina);
                    break;

                case RESUMOS:
                    RegistroResumos resumos = new RegistroResumos(100);
                    menuResumos(entrada, resumos);
                    break;
                case SAIR:
                    break;
            }
    }

    private static void menuTempoOnline(Scanner entrada, RegistroTempoOnline tempoOnline) {
        System.out.println(opcoesMenuTempoOnline);
        OpcoesMenu opcao = OpcoesMenu.valueOf(entrada.nextLine());
        switch (opcao) {
            case HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                tempoOnline.adicionaTempoOnline(horas);
                break;
            case META:
                System.out.println(tempoOnline.atingiuMetaTempoOnline());
                break;
        }
        carregaMenu();
    }

    private static void menuDescanso(Scanner entrada, Descanso descanso) {
        System.out.println(opcoesMenuDescanso);
        OpcoesMenu opcao = OpcoesMenu.valueOf(entrada.nextLine());
        switch (opcao) {
            case HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                descanso.defineHorasDescanso(horas);
                break;
            case EMOJI:
                System.out.println("Digite o emoji que você quer adicionar:");
                String emoji = entrada.nextLine();
                descanso.definirEmoji(emoji);
                break; 
            case SEMANAS:
                System.out.println("Digite quantas semanas você quer adicionar:");
                int semanas = entrada.nextInt();
                descanso.defineNumeroSemanas(semanas);
                break;
            case STATUS:
                System.out.println(descanso.getStatusGeral());
                break;
        }
        carregaMenu();
    }

    private static void menuDisciplina(Scanner entrada, Disciplina disciplina) {
        System.out.println(opcoesMenuDisciplina);
        OpcoesMenu opcao = OpcoesMenu.valueOf(entrada.nextLine());
        switch (opcao) {
            case HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                disciplina.cadastraHoras(horas);
                break;
            case NOTA:
                System.out.println("Digite qual nota e o valor dela:");
                int numNota = entrada.nextInt();
                double nota = entrada.nextDouble();
                disciplina.cadastraNota(numNota, nota);
                break;
            case APROVADO:
                System.out.println(disciplina.aprovado());
                break;
        }
        carregaMenu();
    }

    private static void menuResumos(Scanner entrada, RegistroResumos resumos) {
        System.out.println(opcoesMenuResumos);
        OpcoesMenu opcao = OpcoesMenu.valueOf(entrada.nextLine());
        switch (opcao) {
            case ADICIONA:
                System.out.println("Digite o título e o conteúdo do resumo:");
                String titulo = entrada.next();
                String conteudo = entrada.next();
                resumos.adiciona(titulo, conteudo);
                break;
            case PEGA:
                String[] resumo = resumos.pegaResumos();
                for (int i = 0; i < resumos.conta(); i++) {
                    System.out.println(resumo[i]);
                }
                break;
            case IMPRIME:
                System.out.println(resumos.imprimeResumos());
                break;
            case TEM:
                System.out.println("Digite o título do resumo:");
                String tituloPesquisa = entrada.next();
                resumos.temResumo(tituloPesquisa);
                break;
            case CONTA:
                System.out.println(resumos.conta());
                break;
            case BUSCA:
                System.out.println("Digite a palavra a ser procurada:");
                String palavra = entrada.next();
                String[] achados =  resumos.busca(palavra);
                for (int i = 0; i < achados.length; i++) {
                    System.out.println(achados[i]);
                }
                break;
        }
        carregaMenu();
    }

    static String opcoesMenu = "Bem vindo ao coISA! Selecione uma das atividades abaixo:\n" +
            "- Registro de Tempo Online -> TEMPOONLINE\n" +
            "- Descanso -> DESCANSO\n" +
            "- Disciplina -> DISCIPLINA\n" +
            "- Registro de Resumos -> RESUMOS\n" +
            "- Sair -> SAIR";


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
