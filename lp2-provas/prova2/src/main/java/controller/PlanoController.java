package controller;

import entities.*;

import java.util.ArrayList;

public class PlanoController {

    private ArrayList<Plano> planos;

    private ArrayList<Adicional> adicionais;

    public PlanoController(){
        planos = new ArrayList<>();
        adicionais = new ArrayList<>();
    }

    public int cadastrarPlanoPreBig( String nome, String cpf, String numeroTelefone, int franquia, double valorInicial, double valorExcedente){
        PlanoPreBig p = new PlanoPreBig(nome, cpf, numeroTelefone, franquia, valorInicial, valorExcedente);
        for (Plano p1: planos) {
            if(p1.equals(p)){
                throw new IllegalArgumentException("TELEFONE JÁ CADASTRADO");
            }
        }
        planos.add(p);
        return planos.indexOf(p)+1;
    }

    public int cadastrarPlanoPosBig( String nome, String cpf, String numeroTelefone, double valorDia){
        PlanoPosBig p = new PlanoPosBig(nome, cpf, numeroTelefone, valorDia);
        for (Plano p1: planos) {
            if(p1.equals(p)){
                throw new IllegalArgumentException("TELEFONE JÁ CADASTRADO");
            }
        }
        planos.add(p);
        return planos.indexOf(p)+1;
    }

    public double valorAPagar(int iD, int numero_de_dias){
        if(planos.get(iD-1) == null){
            throw new IndexOutOfBoundsException("PLANO NAO CADASTRADO");
        }
        return planos.get(iD-1).valorAPagar(numero_de_dias);
    }

    public String exibirPlano(int iD) {
        if(planos.get(iD-1) == null){
            throw new IndexOutOfBoundsException("PLANO NAO CADASTRADO");
        }
        return planos.get(iD-1).toString();
    }

    public int cadastrarAdicionalInternet(String addInternet, int mega) {
        Internet i = new Internet(addInternet, mega);
        adicionais.add(i);
        return adicionais.indexOf(i)+1;
    }

    public int cadastrarAdicionalMusica(String addMusica, String servico){
        Musica m = new Musica(addMusica, servico);
        adicionais.add(m);
        return adicionais.indexOf(m)+1;
    }

    public void setAdicional( int idPlano, int idAdicional ){
        if(planos.get(idPlano-1) == null || adicionais.get(idAdicional-1) == null){
            throw new IndexOutOfBoundsException("PLANO OU ADICIONAL NAO CADASTRADO");
        }
        if(planos.get(idPlano-1).isHasAdicional()){
            throw new IllegalArgumentException("PLANO JÁ TEM ADICIONAL");
        }
        planos.get(idPlano-1).setAdicional(adicionais.get(idAdicional-1));
        planos.get(idPlano-1).setHasAdicional();
    }
}
