package documin.documento;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoValidator {

    public static void validaTamanhoDoc(int tamanho){
        if(tamanho <= 0){
            throw new IllegalArgumentException("TAMANHO INVÁLIDO");
        }
    }

    public static void validaTituloDoc(String titulo){
        if(titulo.isBlank()){
            throw new IllegalArgumentException("TÍTULO INVÁLIDO");
        }
    }

    public static void validaDocExistente(HashMap<String, Documento> documentos, String titulo){
        if(!documentos.containsKey(titulo)){
            throw new NoSuchElementException("ELEMENTO NÃO EXISTE");
        }
    }

}
