package documin.interfaces;

import documin.entities.Documento;

/**
 * Interface que define os métodos para representação de uma visão.
 * @author eliane - 122110693
 */
public interface VisaoInterface {

    String[] visaoCompleta(Documento doc);

    String[] visaoResumida(Documento doc);
    
    String[] visaoPrioritaria(int prioridade, Documento doc);

    String[] visaoTitulo(Documento doc);
}
