package src;

/**
 * Classe que representa a interação com o usuário
 *
 * @author Eliane Tamara - 122110693
 */

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
                RegistroTempoOnline tempoOnline = criaTempoOnline();
                menuTempoOnline(entrada, tempoOnline);
                break;

            case OpcoesMenu.DESCANSO:
                Descanso descanso = criaDescanso();
                menuDescanso(entrada, descanso);
                break;

            case OpcoesMenu.DISCIPLINA:
                Disciplina disciplina = criaDisciplina();
                menuDisciplina(entrada, disciplina);
                break;

            case OpcoesMenu.RESUMOS:
                RegistroResumos resumos = criaResumo();
                menuResumos(entrada, resumos);
                break;

            default:
                //perguntar se o usuario deseja sair
        }
    }

    private static RegistroResumos criaResumo() {
        RegistroResumos resumos = null;
        return resumos;
    }

    private static Disciplina criaDisciplina() {
        Disciplina disciplina = null;
        return disciplina;
    }

    private static Descanso criaDescanso() {
        Descanso descanso = null;
        return descanso;
    }

    private static RegistroTempoOnline criaTempoOnline() {
        RegistroTempoOnline tempoOnline = null;
        return tempoOnline;
    }

    private static void menuTempoOnline(Scanner entrada, RegistroTempoOnline tempoOnline) {
        System.out.println(opcoesMenuTempoOnline);
        String comando = entrada.nextLine();
        switch (comando) {
            case OpcoesMenu.HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                tempoOnline.adicionaTempoOnline(horas);
                break;
            case OpcoesMenu.META:
                tempoOnline.atingiuMetaTempoOnline();
                break;
        }
    }

    private static void menuDescanso(Scanner entrada, Descanso descanso) {
        System.out.println(opcoesMenuDescanso);
        String comando = entrada.nextLine();
        switch (comando) {
            case OpcoesMenu.HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                descanso.defineHorasDescanso(horas);
                break;
            case OpcoesMenu.EMOJI:
                System.out.println("Digite o emoji que você quer adicionar:");
                String emoji = entrada.nextLine();
                descanso.definirEmoji(emoji);
                break; 
            case OpcoesMenu.SEMANAS:
                System.out.println("Digite quantas semanas você quer adicionar:");
                int semanas = entrada.nextInt();
                descanso.defineNumeroSemanas(semanas);
                break;
            case OpcoesMenu.STATUS:
                descanso.getStatusGeral();
                break;
        }
    }

    private static void menuDisciplina(Scanner entrada, Disciplina disciplina) {
        System.out.println(opcoesMenuDisciplina);
        String comando = entrada.nextLine();
        switch (comando) {
            case OpcoesMenu.HORAS:
                System.out.println("Digite quantas horas você quer adicionar:");
                int horas = entrada.nextInt();
                disciplina.cadastraHoras(horas);
                break;
            case OpcoesMenu.NOTA:
                System.out.println("Digite qual nota e o valor dela:");
                int numNota = entrada.nextInt();
                double nota = entrada.nextDouble();
                disciplina.cadastraNota(numNota, nota);
                break;
            case OpcoesMenu.APROVADO:
                disciplina.aprovado();
                break;
        }
    }

    private static void menuResumos(Scanner entrada, RegistroResumos resumos) {
        System.out.println(opcoesMenuResumos);
        String comando = entrada.nextLine();
        switch (comando) {
            case OpcoesMenu.ADICIONA:
                System.out.println("Digite o título e o conteúdo do resumo:");
                String titulo = entrada.next();
                String conteudo = entrada.next();
                resumos.adiciona(titulo, conteudo);
                break;
            case OpcoesMenu.PEGA:
                resumos.pegaResumos();
                break;
            case OpcoesMenu.IMPRIME:
                resumos.imprimeResumos();
                break;
            case OpcoesMenu.TEM:
                System.out.println("Digite o título do resumo:");
                String tituloPesquisa = entrada.next();
                resumos.temResumo(tituloPesquisa);
                break;
            case OpcoesMenu.CONTA:
                resumos.conta();
                break;
            case OpcoesMenu.BUSCA:
                System.out.println("Digite a palavra a ser procurada:");
                String palavra = entrada.next();
                resumos.busca(palavra);
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
