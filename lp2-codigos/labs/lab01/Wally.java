import java.util.*;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eliane Tamara - 122110693
 */

public class Wally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> maiores = new ArrayList<String>();
        String maior;
        String nomes;
        
        do{
            nomes = sc.nextLine();
            maior = "";
            for (String nome: nomes.split(" ")) {
                if(nome.length() == 5) {
                    maior = nome;
            	}else if (maior.equals("")){
                    maior = "?";
                }	
            }
            maiores.add(maior);
        }while(!(nomes.equals("wally")));
        
        for(int i = 0; i<maiores.size() -1; i++){
            System.out.println(maiores.get(i));
        }
    }
}

