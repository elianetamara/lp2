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

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaListaElemen(doc)){
            return doc.criarLista(valorLista, prioridade, separador, charLista);
        }else {
            return 0;
        }
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        Documento doc = documentoController.getDocumento(tituloDoc);
        if(validaListaElemen(doc)){
            return doc.criarTermos(valorTermos, prioridade, separador, ordem);
        }else {
            return 0;
        }
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return false;
    }
}
