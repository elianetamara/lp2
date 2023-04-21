package agenda;

/**
 * Uma representação de um contato.
 *
 * @author Eliane Tamara - 122110693
 *
 */

public class Contato {

    private String nome;
    private String sobrenome;
    private String telefone;

    private boolean ehFavorito;

    public Contato(String nome, String sobrenome, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isEhFavorito() {
        return ehFavorito;
    }

    public void setEhFavorito(boolean ehFavorito) {
        this.ehFavorito = ehFavorito;
    }

    /**
     * Exibe dados de um contato expecífico
     *
     * @return Dados do contato
     */
    @Override
    public String toString() {
        if(ehFavorito){
            return "❤ " + this.getNome() + " " + this.getSobrenome() + "\n" + this.getTelefone();
        }else{
            return this.getNome() + " " + this.getSobrenome() + "\n" + this.getTelefone()  ;
        }
    }

    public boolean equals(String nome, String sobrenome) {
        return getNome().toLowerCase().equalsIgnoreCase(nome) && getSobrenome().toLowerCase().equalsIgnoreCase(sobrenome);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getNome(), getSobrenome());
    }
}