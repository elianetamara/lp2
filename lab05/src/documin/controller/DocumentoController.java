package documin.controller;

import documin.entities.*;

import java.util.HashMap;

import static documin.validator.DocumentoValidator.*;

public class DocumentoController {

    private HashMap<String, Documento> documentos;

    public DocumentoController() {
        documentos = new HashMap<>();
    }

    public Documento getDocumento(String tituloDoc){
        validaTituloDocExistente(tituloDoc, getDocumentos());
        return documentos.get(tituloDoc);
    }

    public HashMap<String, Documento> getDocumentos() {
        return documentos;
    }

    public boolean criarDocumento(String titulo) {
        if(validaTituloDoc(titulo) && !validaTituloDocExistente(titulo, documentos)){
            documentos.put(titulo ,new Documento(titulo));
            return true;
        }
        return false;
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        if(validaTituloDoc(titulo) && validaTamanhoDoc(tamanhoMaximo) && !validaTituloDocExistente(titulo, documentos)){
            documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
            return true;
        }
        return false;
    }
    
    public void removerDocumento(String titulo) {
        validaTituloDocExistente(titulo, documentos);
        documentos.remove(titulo);
    }
    
    public int contarElementos(String titulo){
        int numElementos = 0;
        if(validaTituloDoc(titulo) && validaTituloDocExistente(titulo, documentos)){
            numElementos = documentos.get(titulo).contaElementos();
        }
        return numElementos;
    }

    public String[] exibirDocumento(String titulo){
        Documento d = null;
        String[] doc = new String[0];
        if(validaTituloDoc(titulo) && validaTituloDocExistente(titulo, documentos)){
           d = documentos.get(titulo);
           doc = new String[d.contaElementos()];
           for (int i = 0; i < d.contaElementos(); i++) {
               doc[i] = d.getElementosArray()[i].toString();
           }
        }
        return doc;
    }
}
