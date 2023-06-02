package documin.controller;

import documin.entities.*;

import java.util.HashMap;

import static documin.validator.DocumentoValidator.*;

public class DocumentoController {

    private HashMap<String, Documento> documentos;

    private VisaoController visaoController;

    public DocumentoController() {
        documentos = new HashMap<>();
        visaoController = new VisaoController();
    }

    public Documento getDocumento(String tituloDoc){
        validaTitulo(tituloDoc, getDocumentos());
        return documentos.get(tituloDoc);
    }

    public HashMap<String, Documento> getDocumentos() {
        return documentos;
    }

    public boolean criarDocumento(String titulo) {
        if(validaTituloVazio(titulo) && !validaDocumentoInexistente(titulo, documentos)){
            documentos.put(titulo ,new Documento(titulo));
            return true;
        }
        return false;
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        if(validaTituloVazio(titulo) && validaTamanhoDoc(tamanhoMaximo) && !validaDocumentoInexistente(titulo, documentos)){
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
        String[] visaoCompleta = visaoController.visaoCompleta(doc);
        visaoController.adicionaVisao(visaoCompleta);
        return visaoController.getVisoes().indexOf(visaoCompleta);
    }

    public int criarVisaoResumida(String tituloDoc) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String[] visaoResumida = visaoController.visaoResumida(doc);
        visaoController.adicionaVisao(visaoResumida);
        return visaoController.getVisoes().indexOf(visaoResumida);
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String[] visaoPrioritaria = visaoController.visaoPrioritaria(prioridade, doc);
        visaoController.adicionaVisao(visaoPrioritaria);
        return visaoController.getVisoes().indexOf(visaoPrioritaria);
    }

    public int criarVisaoTitulo(String tituloDoc) {
        validaTitulo(tituloDoc, documentos);
        Documento doc = documentos.get(tituloDoc);
        String[] visaoTitulo = visaoController.visaoTitulo(doc);
        visaoController.adicionaVisao(visaoTitulo);
        return visaoController.getVisoes().indexOf(visaoTitulo);
    }

    public String[] exibirVisao(int visaoId) {
        return visaoController.getVisaoById(visaoId);
    }
}
