package src;

/**
 * Representação de um host
 * de cachorros pro sistema da
 * HugsAndSmiles
 *
 * @author eliane - 122110693
 */

public class DogHost {

    private String nome;

    private int qtdMaxRacao;

    private int qtdMaxCachorros;

    private Dog[] cachorros;

    public DogHost(String nome, int qtdMaxRacao, int qtdMaxCachorros){
        this.nome = nome;
        this.qtdMaxRacao = qtdMaxRacao;
        this.qtdMaxCachorros = qtdMaxCachorros;
        this.cachorros = new Dog[qtdMaxCachorros];
        for (int i = 0; i < qtdMaxCachorros; i++) {
            cachorros[i] = new Dog("", "", 0);
        }
    }

    private int cont = 0;

    /**
     * Adiciona cachorro sem restrição
     * @param nome nome do cachorro
     * @param tutor nome do tutor
     * @param qtdRacao quantidade diária de ração
     * @return true se for adicionado, false se contrário
     */
    public boolean adicionaDog(String nome, String tutor, int qtdRacao){
        if(qtdRacao > qtdMaxRacao){
            throw new IllegalArgumentException("Excede quantidade máxima de ração");
        }if (cont >= qtdMaxCachorros){
            throw new IllegalArgumentException("Excede quantidade maxima de cachorros");
        }
        for (Dog d: cachorros) {
            if(d.equals(nome, tutor)){
                throw new IllegalArgumentException("Cachorro já cadastrado");
            }
        }
        cachorros[cont] = new Dog(nome, tutor, qtdRacao);
        cont++;
        return true;
    }

    /**
     * Adiciona cachorro com restrição
     * @param nome nome do cachorro
     * @param tutor nome do tutor
     * @param qtdRacao quantidade diária de ração
     * @param tipoRestricao o tipo da restriçã́o do cachorro
     * @return true se for adicionado, false se contrário
     */
    public boolean adicionaDog(String nome, String tutor, int qtdRacao, String tipoRestricao){
        boolean adicionou = adicionaDog(nome, tutor, qtdRacao);
        if(adicionou){
            cachorros[cont].setRestricao(tipoRestricao);
            cachorros[cont].setQtdRacao(qtdRacao*2);
            return true;
        }
        return false;
    }

    /**
     * Lista de cachorros do host
     * @return String listando os cachorros de certo host
     */
    public String listaDogs(){
        String lista = nome + ":\n";
        for (int i = 0; i < cachorros.length; i++) {
            if(i == cont){
                lista += cachorros[i].toString();
            }else{
                lista += cachorros[i].toString() + "\n";
            }
        }
        return lista;
    }

    /**
     * Somatório das rações de todos os cachorros
     * @return quantidade total da ração
     */
    public int pegaRacaoTotal(){
        int total = 0;
        for (Dog d: cachorros) {
            total += d.getQtdRacao();
        }
        return total;
    }

    /**
     * Somatório do valor das hospedagens dos cães
     * @return valor total das hospedagens
     */
    public double pegaValorTotalHospedagem(){
        double total = 0;
        for (Dog d: cachorros) {
            total += consultaValorHospedagem(d, 1);
        }
        return total;
    }

    /**
     * Calcula valor total da hospedagem por cachorro
     * @param toto cachorro a ser procurado
     * @param dias dias de hospedagem
     * @return valor da hospedagem do cachorro
     */
    public double consultaValorHospedagem(Dog toto, int dias){
        boolean temCachorro = procuraCachorro(toto);
        if(!temCachorro){
            throw new IllegalArgumentException("Esse cachorro não existe");
        }
        return toto.getQtdRacao() * 0.4 * dias;
    }

    private boolean procuraCachorro(Dog toto){
        boolean temCachorro = false;
        for (Dog d: cachorros) {
            if(d.equals(toto.getNome(), toto.getTutor())){
                temCachorro = true;
                break;
            }
        }
        return temCachorro;
    }
}
