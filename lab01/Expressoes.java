import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class Expressoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        int y = 2 * numero;
        int z = 3 * numero;
        System.out.println("dobro: " + y + ", triplo: " + z);
    }
}
