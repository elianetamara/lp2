package prova2.validator;

import prova2.entities.Acao;
import prova2.entities.Desafio;

import java.util.ArrayList;
import java.util.HashMap;

public class Validator {

    public static void verificaTitulo(String titulo){
        if(titulo.isBlank() || titulo == null){
            throw new IllegalArgumentException("TITULO INVALIDO");
        }
    }

    public static void verificaDesafioIgual(ArrayList<Desafio> desafios, Desafio desafio) throws IllegalAccessException {
        for (Desafio d: desafios) {
            if(d.equals(desafio)){
                throw new IllegalAccessException("DESAFIO JÁ EXISTE");
            }
        }
    }

    public static void verificaDesafioExiste(ArrayList<Desafio> desafios, int indice) throws IllegalAccessException {
        if (desafios.get(indice) == null) {
            throw new IllegalAccessException("DESAFIO NÃO EXISTE");
        }
    }

    public static void verificaAcaoIgual(HashMap<Integer, Acao> acoes, int codigo) throws IllegalAccessException {
            if(acoes.containsKey(codigo)){
                throw new IllegalAccessException("ACAO JA EXISTENTE COM ESTE CODIGO");
            }
    }

    public static void verificaAcaoExiste(HashMap<Integer, Acao> acoes, int codigo) throws IllegalAccessException {
        if(!acoes.containsKey(codigo)){
            throw new IllegalAccessException("ACAO NAO EXISTENTE COM ESTE CODIGO");
        }
    }
}
