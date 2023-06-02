package prova2.comparator;

import prova2.entities.Acao;

import java.util.Comparator;

public class AcaoComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Acao a1 = (Acao) o1;
        Acao a2 = (Acao) o2;
        if (a1.getProgresso() < a2.getProgresso()) {
            return -1;
        }
        if (a1.getProgresso() > a2.getProgresso()) {
            return 1;
        }
        return 0;
    }
}
