package documin.tests;

import documin.controller.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes de ElementoController
 * asserts de lançamento de exceção já foram testados em DocumentoValidatorTest
 * @author eliane - 122110693
 */
class ElementoControllerTest {

    private ElementoController elementoController;
    private DocumentoController documentoController;

    @BeforeEach
    void setUp() {
        this.documentoController  = new DocumentoController();
        this.elementoController  = new ElementoController(documentoController);
    }

    @Test
    void criarTexto() {
        documentoController.criarDocumento("Meu Documento", 1);
        assertEquals(0, elementoController.criarTexto("Meu Documento", "Conteúdo do texto", 1));
    }

    @Test
    void criarTitulo() {
        documentoController.criarDocumento("Meu Documento", 2);
        assertEquals(0, elementoController.criarTitulo("Meu Documento", "Conteúdo do texto", 1, 2, false));
        assertEquals(1, elementoController.criarTitulo("Meu Documento", "Conteúdo do texto2", 1, 2, true));
    }

    @Test
    void criarLista() {
        documentoController.criarDocumento("Meu Documento", 2);
        assertEquals(0, elementoController.criarLista("Meu Documento", "termos - da - lista", 1, "-", "*"));
        assertEquals(1, elementoController.criarLista("Meu Documento", "termos - da - lista - dois", 1, "-", "*"));
    }

    @Test
    void criarTermos() {
        documentoController.criarDocumento("Meu Documento", 2);
        assertEquals(0, elementoController.criarTermos("Meu Documento", "T1 | A2 | M3", 1, "|", "NENHUM"));
        assertEquals(1, elementoController.criarTermos("Meu Documento", "Teste | Alfabeto | Mão", 1, "|", "TAMANHO"));
    }

    @Test
    void apagarElemento() {
        documentoController.criarDocumento("Meu Documento", 2);
        elementoController.criarTexto("Meu Documento", "Conteúdo do texto", 1);
        elementoController.criarTitulo("Meu Documento", "Conteúdo do texto", 1, 2, false);
        assertTrue(elementoController.apagarElemento("Meu Documento", 0));
    }

}