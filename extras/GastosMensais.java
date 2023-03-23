import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class GastosMensais {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] meses = sc.nextLine().split(" ");
        String[] gastos = sc.nextLine().split(" ");
        String mes = sc.nextLine();

        for(int i = 0; i < meses.length; i++){
            if(meses[i].equals(mes)){
                System.out.println(gastos[i]);
            }
        }
    }
}