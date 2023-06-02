package prova2.controller;

import prova2.entities.*;

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

    public int adicionaDesafioPessoal(String titulo, String descricao) throws IllegalAccessException {
        Desafio d = new DesafioPessoal(titulo, descricao);
        verificaDesafioIgual(desafios, d);
        desafios.add(d);
        return desafios.indexOf(d);
    }

    public int adicionaDesafioMaterial(String titulo, String descricao, int investimento) throws IllegalAccessException {
        Desafio d = new DesafioMaterial(titulo, descricao, investimento);
        verificaDesafioIgual(desafios, d);
        desafios.add(d);
        return desafios.indexOf(d);
    }

    public int adicionaDesafioSocial(String titulo, String descricao, int qtdPessoas) throws IllegalAccessException {
        Desafio d = new DesafioSocial(titulo, descricao, qtdPessoas);
        verificaDesafioIgual(desafios, d);
        desafios.add(d);
        return desafios.indexOf(d);
    }

    public String exibirDesafio(int indice) throws IllegalAccessException {
        return getDesafioById(indice).toString();
    }

    public void findAndAtualizaDesafioByTitulo(Desafio desafio) {
        for (Desafio d : desafios) {
            if (d.equals(desafio)) {
                d.increaseQtdExecucoes();
                d.calculoSatisfacao();
                break;
            }
        }
    }
}
