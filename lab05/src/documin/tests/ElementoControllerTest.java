package documin.tests;

import documin.controller.*;
import documin.validator.DocumentoValidator;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


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
        // documento inválido
        assertThrows(NoSuchElementException.class, () -> elementoController.criarTexto("Doc Inexistente", "Conteúdo do texto", 1));
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTexto("", "Conteúdo", 1));
        // fora de tamanho
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> elementoController.criarTexto("Meu Documento", "Conteúdo", 1));
        // prioridade invalida
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTexto("Meu Documento", "Conteúdo", -1));
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTexto("Meu Documento", "Conteúdo", 10));
    }

    @Test
    void criarTitulo() {
        documentoController.criarDocumento("Meu Documento", 2);
        assertEquals(0, elementoController.criarTitulo("Meu Documento", "Conteúdo do texto", 1, 2, false));
        assertEquals(1, elementoController.criarTitulo("Meu Documento", "Conteúdo do texto2", 1, 2, true));
        // documento inválido
        assertThrows(NoSuchElementException.class, () -> elementoController.criarTitulo("Doc Inexistente", "Conteúdo do texto", 1, 2, false));
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTitulo("", "Conteúdo", 1, 2, false));
        // fora de tamanho
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> elementoController.criarTitulo("Meu Documento", "Conteúdo3", 1, 2, false));
        // prioridade invalida
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTitulo("Meu Documento", "Conteúdo1", -1, 2, false));
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTitulo("Meu Documento", "Conteúdo2", 10, 2, false));
    }

    @Test
    void criarLista() {
        documentoController.criarDocumento("Meu Documento", 2);
        assertEquals(0, elementoController.criarLista("Meu Documento", "termos - da - lista", 1, "-", "*"));
        assertEquals(1, elementoController.criarLista("Meu Documento", "termos - da - lista - dois", 1, "-", "*"));
        // documento inválido
        assertThrows(NoSuchElementException.class, () -> elementoController.criarLista("Doc Inexistente", "termos - da - lista - invalida", 1, "-", "*"));
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarLista("", "termos - da - lista - invalida", 1, "-", "*"));
        // fora de tamanho
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> elementoController.criarLista("Meu Documento", "termos - da - lista - tres", 1, "-", "*"));
        // prioridade invalida
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarLista("Meu Documento", "Conteúdo - 1", -1, "-", "*"));
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarLista("Meu Documento", "Conteúdo - 2", 10, "-", "*"));
    }

    @Test
    void criarTermos() {
        documentoController.criarDocumento("Meu Documento", 2);
        assertEquals(0, elementoController.criarTermos("Meu Documento", "T1 | A2 | M3", 1, "|", "NENHUM"));
        assertEquals(1, elementoController.criarTermos("Meu Documento", "Teste | Alfabeto | Mão", 1, "|", "TAMANHO"));
        // documento inválido
        assertThrows(NoSuchElementException.class, () -> elementoController.criarTermos("Doc Inexistente", "Teste | Alfabeto | Casa", 1, "|", "NENHUM"));
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTermos("", "Teste | Alfabeto | Casa", 1, "|", "NNEHUM"));
        // fora de tamanho
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> elementoController.criarTermos("Meu Documento", "T3 | A2 | M3", 1, "|", "ALFABETICA"));
        // ordem inválida
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTermos("Meu Documento", "T3 | A2 | M3", 1, "|", "DATA"));
        // prioridade invalida
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTermos("Meu Documento", "Teste | Alfabeto | Casa", -1, "-", "NENHUM"));
        assertThrows(IllegalArgumentException.class, () -> elementoController.criarTermos("Meu Documento", "Teste | Alfabeto | Casa", 10, "-", "NENHUM"));
    }

    @Test
    void apagarElemento() {
        documentoController.criarDocumento("Meu Documento", 2);
        elementoController.criarTexto("Meu Documento", "Conteúdo do texto", 1);
        elementoController.criarTitulo("Meu Documento", "Conteúdo do texto", 1, 2, false);
        assertTrue(elementoController.apagarElemento("Meu Documento", 0));
        // documento inválido
        assertThrows(IllegalArgumentException.class, () -> elementoController.apagarElemento("", 0));
        assertThrows(NoSuchElementException.class, () -> elementoController.apagarElemento("Doc Inexistente", 0));
        // posição inválida
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> elementoController.apagarElemento("Meu Documento", 3));
    }

}