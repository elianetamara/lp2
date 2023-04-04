package src;

/**
 * Classe Main para testes das
 * funcionalidades bônus
 *
 * @author Eliane Tamara - 122110693
 */

public class CoisaBonus {
    public static void main(String[] args) {
        registrarDescanso();
        System.out.println("-----");
        controlarDisciplina();
        System.out.println("-----");
        registrarResumos();
    }
    public static void registrarDescanso() {
        Descanso descanso = new Descanso();
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(2);
        descanso.definirEmoji(":(");
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
    }

    private static void controlarDisciplina() {
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 2);
        Disciplina lprog2 = new Disciplina("LAB PROGRAMACAO 2", 3, new int[]{3, 5, 2});
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        System.out.println(prog2.aprovado());
        lprog2.cadastraNota(1, 7.0);
        lprog2.cadastraNota(2, 10.0);
        lprog2.cadastraNota(3, 7.0);
        System.out.println(lprog2.aprovado());
        System.out.println(prog2.toString());
        System.out.println(lprog2.toString());
    }

    private static void registrarResumos() {
        RegistroResumos meusResumos = new RegistroResumos(5);  // 5 resumos

        meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
        meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");

        String[] resumos2 = meusResumos.busca("UM");
        for (int i = 0; i < resumos2.length; i++) {
            System.out.println(resumos2[i]);
        }
    }

}
