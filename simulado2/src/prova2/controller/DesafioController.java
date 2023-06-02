package prova2.controller;

import prova2.entities.Acao;
import prova2.entities.Desafio;

import java.util.ArrayList;

import static prova2.validator.Validator.*;

public class DesafioController {

    private ArrayList<Desafio> desafios;

    public DesafioController(){
        desafios = new ArrayList<>();
    }

    public Desafio getDesafioById(int indice) throws IllegalAccessException {
        verificaDesafioExiste(desafios, indice);
        return desafios.get(indice);
    }

    public int adicionaDesafio(String titulo, String descricao) throws IllegalAccessException {
        Desafio d = new Desafio(titulo, descricao);
        verificaDesafioIgual(desafios, d);
        desafios.add(d);

        return desafios.indexOf(d);
    }

    public String exibirDesafio(int indice) throws IllegalAccessException {
        return getDesafioById(indice).toString();
    }

    public void findAndAtualizaDesafioByTitulo(Desafio desafio) {
        for (Desafio d: desafios) {
            if(d.equals(desafio)){
                d.increaseQtdExecucoes();
                break;
            }
        }
    }
}
