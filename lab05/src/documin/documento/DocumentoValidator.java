package documin.documento;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoValidator {

    public static boolean validaTamanhoDoc(int tamanho){
        if(tamanho <= 0){
            throw new IllegalArgumentException("TAMANHO INVÁLIDO");
        }
        return true;
    }

    public static boolean validaTituloDoc(String titulo){
        if(titulo.isBlank()){
            throw new IllegalArgumentException("TÍTULO INVÁLIDO");
        }
        return true;
    }

    public static boolean validaTituloDocExistente(String titulo, HashMap<String, Documento> docs){
        if(!docs.containsKey(titulo)){
            throw new NoSuchElementException("ELEMENTO NÃO EXISTE");
        }else{
            return true;
        }
    }
}
