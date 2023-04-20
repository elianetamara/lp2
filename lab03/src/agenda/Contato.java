package agenda;

/**
 * Uma representação de um contato.
 *
 * @author Eliane Tamara - 122110693
 *
 */

public class Contato {

    private int posicao;
    private String nome;
    private String sobrenome;
    private String telefone;

    public Contato(){
        nome = "";
        sobrenome = "";
        telefone = "";
        posicao = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    /**
     * Exibe dados de um contato expecífico
     *
     * @return Dados do contato
     */
    @Override
    public String toString() {
        return this.getNome() + " " + this.getSobrenome() + "\n" + this.getTelefone()  ;
    }

    public boolean equals(String nome, String sobrenome) {
        return getNome().toLowerCase().equalsIgnoreCase(nome) && getSobrenome().toLowerCase().equalsIgnoreCase(sobrenome);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getNome(), getSobrenome());
    }
}