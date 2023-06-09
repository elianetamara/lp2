package documin.entities;

import java.util.ArrayList;

/**
 * A classe Atalho representa um atalho que contém uma lista de elementos.
 * É uma subclasse da classe Elemento.
 * @author eliane - 122110693
 */
public class Atalho extends Elemento {

    private ArrayList<Elemento> elementos;

    /**
     * Constrói um novo atalho com a prioridade, valor e lista de elementos especificados.
     *
     * @param prioridade a prioridade do atalho
     * @param valor o valor do atalho
     * @param elementos a lista de elementos do atalho
     */
    public Atalho(int prioridade, String valor, ArrayList<Elemento> elementos) {
        super(prioridade, valor);
        this.elementos = elementos;
    }

    /**
     * Retorna a representação completa do atalho.
     * A representação completa inclui apenas os elementos com prioridade 4 ou 5.
     *
     * @return a representação completa do atalho
     */
    @Override
    public String representacaoCompleta() {
        String saida = "";
        for (Elemento e : elementos) {
            if (e.getPrioridade() == 4 || e.getPrioridade() == 5) {
                saida += e.representacaoCompleta() + "\n";
            }
        }
        return saida;
    }

    /**
     * Retorna a representação resumida do atalho.
     * A representação resumida inclui apenas os elementos com prioridade 4 ou 5.
     *
     * @return a representação resumida do atalho
     */
    @Override
    public String representacaoResumida() {
        String saida = "";
        for (Elemento e : elementos) {
            if (e.getPrioridade() == 4 || e.getPrioridade() == 5) {
                saida += e.representacaoResumida() + "\n";
            }
        }
        return saida;
    }
}