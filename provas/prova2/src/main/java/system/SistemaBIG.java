package system;

import controller.PlanoController;

public class SistemaBIG {

    private PlanoController planoController;

    public SistemaBIG(){
        planoController = new PlanoController();
    }

    public int cadastrarPlanoPreBig( String nome, String cpf, String numeroTelefone, int franquia, double valorInicial, double valorExcedente){
        if(numeroTelefone == null || numeroTelefone.isBlank()){
            throw new IllegalArgumentException("NUMERO DE TELEFONE INVALIDO");
        }
        return this.planoController.cadastrarPlanoPreBig(nome, cpf, numeroTelefone, franquia, valorInicial, valorExcedente);
    }

    public int cadastrarPlanoPosBig( String nome, String cpf, String numeroTelefone, double valorDia){
        if(numeroTelefone == null || numeroTelefone.isBlank()){
            throw new IllegalArgumentException("NUMERO DE TELEFONE INVALIDO");
        }
        return this.planoController.cadastrarPlanoPosBig(nome, cpf, numeroTelefone, valorDia);
    }

    public double valorAPagar(int iD, int numero_de_dias){
        return this.planoController.valorAPagar(iD, numero_de_dias);
    }

    public String exibirPlano(int iD) {
        return this.planoController.exibirPlano(iD);
    }

    public int cadastrarAdicionalInternet(String addInternet, int mega) {
        return this.planoController.cadastrarAdicionalInternet(addInternet, mega);
    }

    public int cadastrarAdicionalMusica(String addMusica, String servico){
        if(servico != "Spotify" || servico != "Deezer"){
            throw new IllegalArgumentException("SERVICO INVALIDO");
        }
        return this.planoController.cadastrarAdicionalMusica(addMusica, servico);
    }

    public void setAdicional( int idPlano, int idAdicional ){
        this.planoController.setAdicional(idPlano, idAdicional);
    }

}
