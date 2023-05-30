package documin.controller;

import documin.entities.Documento;
import static documin.validator.DocumentoValidator.*;


public class ElementoController {

    private DocumentoController documentoController;

    ElementoController() {
        documentoController = new DocumentoController();
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaListaElemen(doc)){
            return doc.criarTexto(valor, prioridade);
        }else {
            return 0;
        }
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaListaElemen(doc)){
            return doc.criarTitulo(valor, prioridade, nivel, linkavel);
        }else {
            return 0;
        }
    }
}
