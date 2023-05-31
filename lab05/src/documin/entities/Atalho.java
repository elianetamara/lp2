package documin.entities;

import java.util.ArrayList;

public class Atalho extends Elemento{

    private ArrayList<Elemento> elementos;

    public Atalho(int prioridade, String valor, ArrayList<Elemento> elementos) {
        super(prioridade, valor);
        this.elementos = elementos;
    }

    @Override
    public String representacaoCompleta() {
        String saida = "";
        for (Elemento e : elementos) {
            if(e.getPrioridade() == 4 || e.getPrioridade() == 5){
                saida += e.representacaoCompleta() + "\n";
            }
        }
        return saida;
    }

    @Override
    public String representacaoResumida() {
        String saida = "";
        for (Elemento e : elementos) {
            if(e.getPrioridade() == 4 || e.getPrioridade() == 5){
                saida += e.representacaoResumida() + "\n";
            }
        }
        return saida;
    }
}
