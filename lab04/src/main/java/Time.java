public class Time {

    private String id;

    private String nome;

    private String mascote;

    public Time(String id, String nome, String mascote) {
        this.id = id;
        this.nome = nome;
        this.mascote = mascote;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMascote() {
        return mascote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return getId().equals(time.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
