package documin.validator;

import documin.entities.Documento;

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
            throw new NoSuchElementException("DOCUMENTO NÃO EXISTE");
        }else{
            return true;
        }
    }

    public static boolean validaListaElemen(Documento doc){
        if(doc.getTamanho() != 0 && doc.contaElementos() == doc.getTamanho()){
            throw new ArrayIndexOutOfBoundsException("DOCUMENTO JÁ ESTÁ CHEIO");
        }else{
            return true;
        }
    }

    public static void validaPosicaoLista(Documento doc, int posicao){
        if(doc.getElementosArray()[posicao] == null) {
            throw new IllegalArgumentException("NÃO EXISTE ELEMENTO NA POSIÇÃO");
        }
    }
}
