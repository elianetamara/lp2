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