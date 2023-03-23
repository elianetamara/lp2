import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class MaiorMenorDuasPalavras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra1 = sc.next();
        String palavra2 = sc.next();
        int tam1 = palavra1.length();
        int tam2 = palavra2.length();

        if (tam1 == tam2) {
            System.out.println(palavra1);
            System.out.println(palavra1);
        }else if (tam1 > tam2) {
            System.out.println(palavra2);
            System.out.println(palavra1);
        }else{
            System.out.println(palavra1);
            System.out.println(palavra2);
        }
    }
}

