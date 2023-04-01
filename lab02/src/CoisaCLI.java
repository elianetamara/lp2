package src;

public class CoisaCLI {
    public static void main(String[] args) {
        System.out.println("-----");
    }

    String menuTempoOnline = "Registro de Tempo Online:\n" +
            "- TEMPOONLINE HORAS <num>: adicionar <num> horas\n" +
            "- TEMPOONLINE META: verificar se atingiu a meta de tempo";

    String menuDescanso = "lab02.Descanso:\n" +
            "- DESCANSO HORAS <num>: definir horas de descanso\n" +
            "- DESCANSO EMOJI <emoji>: definir emoji\n" +
            "- DESCANSO SEMANAS <num>: define número de semanas\n" +
            "- DESCANSO STATUS: ver status geral";

    String menuDisciplina = "lab02.Disciplina:\n" +
            "- DISCIPLINA HORAS: cadastra horas de estudo\n" +
            "- DISCIPLINA NOTA: cadastra notas\n" +
            "- DISCIPLINA AROVADO: verifica se o aluno foi aprovado";


    String menuResumos = "Registro de Resumos:\n" +
            "- RESUMOS ADICIONA <titulo> <conteudo>: adiciona resumo\n" +
            "- RESUMOS PEGA: pega lista de resumos\n" +
            "- RESUMOS IMPRIME: informações sobre os resumos\n" +
            "- RESUMOS TEM <titulo>: procura resumo sobre determinado tema\n" +
            "- RESUMOS CONTA: informa quantos resumos foram cadastrados\n" +
            "- RESUMOS BUSCA <texto>:";
}
