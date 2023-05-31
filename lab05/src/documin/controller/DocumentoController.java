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
        validaTitulo(tituloDoc, getDocumentos());
        return documentos.get(tituloDoc);
    }

    public HashMap<String, Documento> getDocumentos() {
        return documentos;
    }

    public boolean criarDocumento(String titulo) {
        if(validaTituloVazio(titulo) && !validaTituloVazioExistente(titulo, documentos)){
            documentos.put(titulo ,new Documento(titulo));
            return true;
        }
        return false;
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        if(validaTituloVazio(titulo) && validaTamanhoDoc(tamanhoMaximo) && !validaTituloVazioExistente(titulo, documentos)){
            documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
            return true;
        }
        return false;
    }
    
    public void removerDocumento(String titulo) {
        validaTitulo(titulo, documentos);
        documentos.remove(titulo);
    }
    
    public int contarElementos(String titulo){
        validaTitulo(titulo, documentos);
        return documentos.get(titulo).contaElementos();
    }

    public String[] exibirDocumento(String titulo){
        validaTitulo(titulo, documentos);
        Documento d = documentos.get(titulo);
        String[] doc = new String[d.contaElementos()];
        for (int i = 0; i < d.contaElementos(); i++) {
            doc[i] = d.getElementosArray()[i].toString();
        }

        return doc;
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        hasAtalho(tituloDoc, tituloDocReferenciado, documentos);
        Documento doc = documentos.get(tituloDoc);
        Documento docRef = documentos.get(tituloDocReferenciado);
        Atalho a = new Atalho(docRef.calculaMediaPrioridade(), tituloDocReferenciado, docRef.getElementos());
        doc.adicionaElemento(a);
        doc.setAtalho(true);
        docRef.setAtalho(true);

        return docRef.getElementos().indexOf(a);
    }

    public int criarVisaoCompleta(String tituloDoc) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String visao = doc.visaoCompleta();
        doc.adicionaVisao(visao);
        return doc.getVisoes().indexOf(visao);
    }

    public int criarVisaoResumida(String tituloDoc) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String visao = doc.visaoResumida();
        doc.adicionaVisao(visao);
        return doc.getVisoes().indexOf(visao);
    }
}
