import java.util.*;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class ResultadosDeProva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] listaAlunos;
        int soma = 0;
        int menor = 1000;
        int maior = 0;
        int acima = 0;
        int abaixo = 0;
        int media = 0;
        int quantidade = 0;

        while (true) {
            listaAlunos = sc.nextLine().split(" ");
            if (listaAlunos[0].equals("-")) {
                break;
            }
            int nota = Integer.parseInt(listaAlunos[1]);
            quantidade++;


            if (nota > maior) {
                maior = nota;
            }
            if (nota < menor) {
                menor = nota;
            }

            soma += nota;
            media = soma / quantidade;

            if (nota < 700) {
                abaixo++;
            }else if (nota >= 700) {
                acima++;
            }
        }
        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("media: " + media);
        System.out.println("acima: " + acima);
        System.out.println("abaixo: " + abaixo);
    }
}
