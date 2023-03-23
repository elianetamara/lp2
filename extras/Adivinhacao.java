import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class Adivinhacao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        int tentativa;
        while (true) {
            tentativa = sc.nextInt();
            if (tentativa == numero){
                System.out.println("ACERTOU");
                break;
            } else if (tentativa < numero) {
                System.out.println("MENOR");
            }else if (tentativa > numero){
                System.out.println("MAIOR");
            }
        }
    }

}
