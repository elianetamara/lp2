package entities;

public abstract class Plano {

    private String nome;
    private String cpf;
    private String numTelefone;
    private boolean hasAdicional;
    private Adicional adicional;

    public Plano(String nome, String cpf, String numTelefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.numTelefone = numTelefone;
        hasAdicional = false;
    }

    public boolean isHasAdicional() {
        return hasAdicional;
    }

    public void setHasAdicional() {
        this.hasAdicional = true;
    }

    public Adicional getAdicional() {
        return adicional;
    }

    public void setAdicional(Adicional adicional) {
        this.adicional = adicional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plano plano = (Plano) o;

        return numTelefone.equals(plano.numTelefone);
    }

    @Override
    public int hashCode() {
        return numTelefone.hashCode();
    }

    @Override
    public String toString() {
        return "Telefonia: [" + "nome=" + nome + ", cpf=" + cpf + ", telefone=" + numTelefone;
    }

    public abstract double valorAPagar(int numero_de_dias);
}
