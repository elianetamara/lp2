package system;

import controller.MDMVController;

public class MeuDesafioMinhaVida {


    private MDMVController MDMVController;

    public MeuDesafioMinhaVida(){
        MDMVController  = new MDMVController();
    }

    public int adicionaDesafioPessoal(String titulo, String descricao) throws IllegalAccessException {
        return this.MDMVController.adicionaDesafioPessoal(titulo, descricao);
    }

    public int adicionaDesafioMaterial(String titulo, String descricao, int investimento) throws IllegalAccessException {
        return this.MDMVController.adicionaDesafioMaterial(titulo, descricao, investimento);
    }

    public int adicionaDesafioSocial(String titulo, String descricao, int qtdPessoas) throws IllegalAccessException {
        return this.MDMVController.adicionaDesafioSocial(titulo, descricao, qtdPessoas);
    }

    public String exibirDesafio(int indice) throws IllegalAccessException {
        return this.MDMVController.exibirDesafio(indice);
    }

    public void adicionaAcao(int indiceDesafio, String data, int codigo) throws IllegalAccessException {
        this.MDMVController.adicionaAcao(indiceDesafio, data, codigo);
    }

    public void atualizaProgressoAcao(int codigo) throws IllegalAccessException {
        this.MDMVController.atualizaProgressoAcao(codigo);
    }

    public void atualizaProgressoAcao(int codigo, int progresso) throws IllegalAccessException {
        this.MDMVController.atualizaProgressoAcao(codigo, progresso);
    }

    public String listarAcaoOrdemProgresso(){
        return this.MDMVController.listarAcaoOrdemProgresso();
    }
}
