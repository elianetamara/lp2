package agenda;

/**
 * Uma representação de um contato.
 *
 * @author Eliane Tamara - 122110693
 *
 */

public class Contato {

    //private int posicao;
    private String nome;
    private String sobrenome;
    private String telefone;

    public Contato(){
        nome, sobrenome, telefone = new String();
        //posicao = 0;
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Contato contato = (Contato) object;
        return getNome().equals(contato.getNome()) && getSobrenome().equals(contato.getSobrenome());
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getNome(), getSobrenome());
    }
}