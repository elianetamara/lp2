package prova2.system;

import prova2.controller.*;

public class MeuDesafioMinhaVida {


    private DesafioController desafioController;

    private AcaoController acaoController;

    public MeuDesafioMinhaVida(){
        desafioController  = new DesafioController();
        acaoController = new AcaoController();
    }

    public int adicionaDesafioPessoal(String titulo, String descricao) throws IllegalAccessException {
        return this.desafioController.adicionaDesafioPessoal(titulo, descricao);
    }

    public int adicionaDesafioMaterial(String titulo, String descricao, int investimento) throws IllegalAccessException {
        return this.desafioController.adicionaDesafioMaterial(titulo, descricao, investimento);
    }

    public int adicionaDesafioSocial(String titulo, String descricao, int qtdPessoas) throws IllegalAccessException {
        return this.desafioController.adicionaDesafioSocial(titulo, descricao, qtdPessoas);
    }

    public String exibirDesafio(int indice) throws IllegalAccessException {
        return this.desafioController.exibirDesafio(indice);
    }

    public void adicionaAcao(int indiceDesafio, String data, int codigo) throws IllegalAccessException {
        this.acaoController.adicionaAcao(indiceDesafio, data, codigo);
    }

    public void atualizaProgressoAcao(int codigo) throws IllegalAccessException {
        this.acaoController.atualizaProgressoAcao(codigo);
    }

    public void atualizaProgressoAcao(int codigo, int progresso) throws IllegalAccessException {
        this.acaoController.atualizaProgressoAcao(codigo, progresso);
    }

    public String listarAcaoOrdemProgresso(){
        return this.acaoController.listarAcaoOrdemProgresso();
    }
}
