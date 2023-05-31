package documin.entities;

public class Lista extends Elemento{

    private String separador;

    private String caractere;

    public Lista(int prioridade, String valor, String caractere, String separador) {
        super(prioridade, valor);
        this.caractere = caractere;
        this.separador = separador;
    }

    public String getSeparador() {
        return separador;
    }

    public String getCaractere() {
        return caractere;
    }

    @Override
    public String representacaoCompleta() {
        String[] elemen = getValor().split(getSeparador());
        String representacao = null;
        for (String e: elemen) {
            representacao += getCaractere() + " " + e + "\n";
        }
        return representacao;
    }

    @Override
    public String representacaoResumida() {
        return super.representacaoResumida();
    }

}
