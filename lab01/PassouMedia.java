import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class PassouMedia {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double nota1 = sc.nextDouble();
        double nota2 = sc.nextDouble();
        double media = (nota1 + nota2)/2;
        if (media >= 7.0) {
            System.out.println("pass: True!");
        } else {
            System.out.println("pass: False!");
        }
    }
}
