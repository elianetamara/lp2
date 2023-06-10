package documin.tests;

import documin.entities.Documento;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DocumentoTest {

    private Documento documento;
    private Documento documento2;

    @BeforeEach
    public void setUp() {
        this.documento = new Documento("Doc");
        this.documento2 = new Documento("Doc2");
    }

    @Test
    void criarElementos() {
        assertEquals(0, documento.criarTexto("Exemplo de texto", 2));
        assertEquals(1, documento.criarTitulo("Titulo", 2, 3, false));
        assertEquals(2, documento.criarTitulo("Titulo Linkável", 2, 3, true));
        assertEquals(3, documento.criarLista("termos - da - lista" ,1, "-", "*"));
        assertEquals(4, documento.criarTermos("T3 | A2 | M3", 1, "|", "ALFABETICA"));
        assertEquals(5, documento.criarTermos("T1 | A2 | M3", 1,"|", "NENHUM"));
        assertEquals(6, documento.criarTermos("Teste | Alfabeto | Mão", 1,"|", "TAMANHO"));
    }


    @Test
    void moverParaCima() {
        documento.criarTexto("Exemplo texto", 1);
        documento.criarTexto("Exemplo", 1);

        documento.moverParaCima(1);

        assertEquals("Exemplo", documento.getElemento(0).getValor());
        assertEquals("Exemplo texto", documento.getElemento(1).getValor());
    }

    @Test
    void moverParaBaixo() {
        documento.criarTexto("Exemplo texto", 1);
        documento.criarTexto("Exemplo", 1);

        documento.moverParaBaixo(0);

        assertEquals("Exemplo texto", documento.getElemento(1).getValor());
        assertEquals("Exemplo", documento.getElemento(0).getValor());
    }

    @Test
    void calculaMediaPrioridade() {
        documento2.criarTexto("Exemplo texto", 1);
        documento2.criarTexto("Exemplo", 4);
        assertEquals(2, documento2.calculaMediaPrioridade());
    }
}