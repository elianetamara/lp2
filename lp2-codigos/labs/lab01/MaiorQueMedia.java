import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class MaiorQueMedia {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int tam = nums.length;
        int[] numeros = new int[tam];
        int soma = adiciona(nums, numeros);

        String result = "";
        int media = soma / tam;
        for (int num : numeros) {
            if (num > media) {
                if (result.equals("")) {
                    result += num;
                } else {
                    result += " " + num;
                }
            }
        }
        System.out.println(result);
    }
    public static int adiciona(String[] linha, int[] lista){
        int sum = 0;
        for (int i = 0; i < lista.length; i++) {
            lista[i] = Integer.parseInt(linha[i]);
            sum += lista[i];
        }
        return sum;
    }
}