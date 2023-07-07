package documin.tests;

import documin.controller.DocumentoController;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes de DocumentoController
 * asserts de lançamento de exceção já foram testados em DocumentoValidatorTest
 * @author eliane - 122110693
 */
class DocumentoControllerTest {

    private DocumentoController documentoController;

    @BeforeEach
    void setUp() {
        documentoController = new DocumentoController();
        documentoController.criarDocumento("Doc1");
        documentoController.getDocumento("Doc1").criarTexto("texto teste", 1);
        documentoController.getDocumento("Doc1").criarTitulo("Título teste", 1, 3, false);

        documentoController.criarDocumento("DocReferenciado");
        documentoController.getDocumento("DocReferenciado").criarTexto("texto teste", 3);
        documentoController.getDocumento("DocReferenciado").criarTitulo("Título teste", 1, 3, true);
        documentoController.getDocumento("DocReferenciado").criarLista("termos - da - lista" ,1, "-", "*");
        documentoController.getDocumento("DocReferenciado").criarTermos("T1 | A2 | M3", 1,"|", "NENHUM");
    }

    @Test
    void criarDocumento() {
        assertTrue(documentoController.criarDocumento("Doc"));
        assertTrue(documentoController.criarDocumento("Doc2", 10));
    }


    @Test
    void removerDocumento() {
        documentoController.removerDocumento("Doc1");
        // verificar se este elemento foi removido
        assertThrows(NoSuchElementException.class, () -> documentoController.getDocumento("Doc1"));
    }

    @Test
    void exibirDocumento() {
        assertArrayEquals(new String[]{"texto teste", "3. Título teste"}, documentoController.exibirDocumento("Doc1"));
    }

    @Test
    void criarAtalho() {
        assertEquals(2, documentoController.criarAtalho("Doc1", "DocReferenciado"));
        assertTrue(documentoController.getDocumento("Doc1").isAtalho());
        assertTrue(documentoController.getDocumento("DocReferenciado").isAtalho());
    }
    @Test
    void criarVisoes() {
        // completa
        assertEquals(0, documentoController.criarVisaoCompleta("DocReferenciado"));
        // resumida
        assertEquals(1, documentoController.criarVisaoResumida("DocReferenciado"));
        // prioritaria
        assertEquals(2, documentoController.criarVisaoPrioritaria("DocReferenciado", 2));
        // titulo
        assertEquals(3, documentoController.criarVisaoTitulo("DocReferenciado"));
    }

    @Test
    void exibirVisao() {
        criarVisoes();
        assertArrayEquals(new String[]{"texto teste", "3. Título teste - 3-TÍTULO TESTE", "* termos \n" + "*  da \n" + "*  lista\n", "Total termos: 3\n" + "T1 ,  A2 ,  M3"}, documentoController.exibirVisao(0));
        assertArrayEquals(new String[]{"texto teste", "3. Título teste", "termos - da - lista", "T1  |  A2  |  M3"}, documentoController.exibirVisao(1));
        assertArrayEquals(new String[]{"texto teste"}, documentoController.exibirVisao(2));
        assertArrayEquals(new String[]{"3. Título teste"}, documentoController.exibirVisao(3));
    }
}