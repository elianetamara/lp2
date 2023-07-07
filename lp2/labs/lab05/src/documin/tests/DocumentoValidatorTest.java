package documin.tests;

import documin.entities.Documento;
import documin.entities.Texto;
import documin.validator.DocumentoValidator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class DocumentoValidatorTest {

    private DocumentoValidator documentoValidator;
    private HashMap<String, Documento> docs;
    private Documento doc;
    private Documento doc2;
    private ArrayList visoes;

    @BeforeEach
    void setUp() {
        documentoValidator = new DocumentoValidator();
        docs = new HashMap<>();
        docs.put("docTeste", new Documento("docTeste"));
        // teste de documento
        doc = new Documento("Doc", 1);
        doc.adicionaElemento(new Texto(1, "a"));
        doc2 = new Documento("Doc2", 4);
        doc2.adicionaElemento(new Texto(1, "a"));
        // teste de visão
        visoes = new ArrayList<>();
        visoes.add(new String[]{"Visao 1", "Visão"});
        // testes de atalho
        docs.put("Documento1", new Documento("Documento1"));
        docs.put("Documento2", new Documento("Documento2"));
    }
    @Test
    void validaTamanhoDoc() {
        assertTrue(DocumentoValidator.validaTamanhoDoc(10));
        assertThrows(IllegalArgumentException.class, () -> DocumentoValidator.validaTamanhoDoc(-1));
    }

    @Test
    void validaPrioridade() {
        assertDoesNotThrow(() -> DocumentoValidator.validaPrioridade(3));
        assertThrows(IllegalArgumentException.class, () -> DocumentoValidator.validaPrioridade(0));
        assertThrows(IllegalArgumentException.class, () -> DocumentoValidator.validaPrioridade(6));
    }

    @Test
    void validaTitulo() {
        assertDoesNotThrow(() -> DocumentoValidator.validaTitulo("docTeste", docs));
        assertThrows(IllegalArgumentException.class, () -> DocumentoValidator.validaTitulo("", docs));
        assertThrows(NoSuchElementException.class, () -> DocumentoValidator.validaTitulo("doc", docs));
    }

    @Test
    void validaTituloVazio() {
        assertThrows(IllegalArgumentException.class, () -> DocumentoValidator.validaTituloVazio(""));
        assertDoesNotThrow(() -> DocumentoValidator.validaTituloVazio("doc"));
    }

    @Test
    void validaOrdemTermos() {
        assertDoesNotThrow(() -> DocumentoValidator.validaOrdemTermos("alfabetica"));
        assertDoesNotThrow(() -> DocumentoValidator.validaOrdemTermos("tamanho"));
        assertDoesNotThrow(() -> DocumentoValidator.validaOrdemTermos("nenhum"));
        assertThrows(IllegalArgumentException.class, () -> DocumentoValidator.validaOrdemTermos("data"));
    }

    @Test
    void validaDocumentoInexistente() {
        assertDoesNotThrow(() -> DocumentoValidator.validaDocumentoInexistente("docTeste", docs));
        assertThrows(NoSuchElementException.class, () -> DocumentoValidator.validaDocumentoInexistente("Documento3", docs));
    }

    @Test
    void validaDocumentoExistente() {
        assertDoesNotThrow(() -> DocumentoValidator.validaDocumentoExistente("Documento3", docs));
        assertThrows(NoSuchElementException.class, () -> DocumentoValidator.validaDocumentoExistente("docTeste", docs));
    }

    @Test
    void validaDocumentoCheio() {
            assertDoesNotThrow(() -> DocumentoValidator.validaDocumentoCheio(new Documento("Doc", 0)));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> DocumentoValidator.validaDocumentoCheio(doc));
            assertDoesNotThrow(() -> DocumentoValidator.validaDocumentoCheio(doc2));
    }

    @Test
    void validaPosicaoElemento() {
        assertDoesNotThrow(() -> DocumentoValidator.validaPosicaoElemento(doc, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> DocumentoValidator.validaPosicaoElemento(doc, 3));
    }

    @Test
    void validaPosicaoVisao() {
        assertDoesNotThrow(() -> DocumentoValidator.validaPosicaoVisao(visoes, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> DocumentoValidator.validaPosicaoVisao(visoes, 1));
    }

    @Test
    void hasAtalho() {
        assertDoesNotThrow(() -> DocumentoValidator.hasAtalho("Documento1", "Documento2", docs));
        docs.get("Documento1").setAtalho(true);
        // dpcumento já com atalho
        assertThrows(IllegalStateException.class, () -> DocumentoValidator.hasAtalho("Documento1", "Documento2", docs));
        // título vazio
        assertThrows(IllegalArgumentException.class, () -> DocumentoValidator.hasAtalho("", "Documento2", docs));
        assertThrows(IllegalArgumentException.class, () -> DocumentoValidator.hasAtalho("Documento1", "", docs));
        // documento não existe
        assertThrows(NoSuchElementException.class, () -> DocumentoValidator.hasAtalho("Documento3", "Documento2", docs));
        assertThrows(NoSuchElementException.class, () -> DocumentoValidator.hasAtalho("Documento1", "Documento3", docs));
    }
}