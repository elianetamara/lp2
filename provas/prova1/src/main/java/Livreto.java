import java.util.ArrayList;

public class Livreto {

    private ArrayList<Cronica> cronicasLivreto;

    private int id;

    public Livreto(){
        cronicasLivreto = new ArrayList<>();
        this.id = 0;
    }

    public Cronica[] getCronicasLivreto() {
        return (Cronica[]) cronicasLivreto.toArray();
    }

    public Cronica getCronicaLivreto(int posicao) {
        return cronicasLivreto.get(posicao-1);
    }

    public int getId() {
        return id;
    }

    public void aumentaId() {
        this.id = id+1;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String saida = "Livreto: \n";
        for (Cronica c : cronicasLivreto) {
            saida += c.toString() + "\n";
            c.setQtdLeituras();
        }
        return saida;
    }
}
