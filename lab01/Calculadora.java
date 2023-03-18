import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operador = sc.next();
        if (operador.equals("+")){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double soma = a + b;
            System.out.println("RESULTADO: " + soma);
        }else if (operador.equals("-")){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double diff = a - b;
            System.out.println("RESULTADO: " + diff);
        }else if (operador.equals("*")){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double prod = a * b;
            System.out.println("RESULTADO: " + prod);
        }else if (operador.equals("/")){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            if (b == 0){
                System.out.println("ERRO");
            }else {
                double divisao = a / b;
                System.out.println("RESULTADO: " + divisao);
            }
        }else{
            System.out.println("ENTRADA INVALIDA");
        }


    }
}

