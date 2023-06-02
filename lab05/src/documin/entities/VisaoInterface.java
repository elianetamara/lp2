package documin.entities;

public interface VisaoInterface {

    String[] visaoCompleta(Documento doc);

    String[] visaoResumida(Documento doc);
    
    String[] visaoPrioritaria(int prioridade, Documento doc);

    String[] visaoTitulo(Documento doc);
}
