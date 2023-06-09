package documin.tests;

import documin.entities.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testa reperesentações dos elementos
 * @author eliane - 122110693
 */
class ElementosTest {

    private Atalho atalho;
    private Lista lista;
    private Termos termos;
    private Termos termosTam;
    private Termos termosAlf;
    private Texto texto;
    private Titulo tituloLinkavel;
    private Titulo titulo;

    @BeforeEach
    void setUp() {
        lista = new Lista(1, "termos - da - lista", "*", "-");
        termos = new Termos(1, "T1 | A2 | M3", "NENHUM", "|");
        termosTam = new Termos(1, "Teste | Alfabeto | Mão", "TAMANHO", "|");
        termosAlf = new Termos(1, "T3 | A2 | M3", "ALFABETICA", "|");
        texto = new Texto(2, "Texto teste");
        titulo = new Titulo(3, false, 2, "Titulo");
        tituloLinkavel = new Titulo(3, true, 2, "Titulo Linkável");
        // criando documento para ser usado na criação de atalho
        Documento documentoRef = new Documento("docRef");
        documentoRef.criarTermos("Teste / termos / Aleatórios",4, "/", "nenhuma");
        documentoRef.criarTitulo("Documentos Texto", 3, 1, true);
        atalho = new Atalho(documentoRef.calculaMediaPrioridade(), "docRef", documentoRef.getElementos());
    }

    @Test
    void representacaoCompleta() {
        assertEquals("* termos \n" + "*  da \n" + "*  lista\n", lista.representacaoCompleta());
        assertEquals("Texto teste", texto.representacaoCompleta());
        assertEquals("3. Titulo", titulo.representacaoCompleta());
        assertEquals("3. Titulo Linkável - 3-TITULO LINKÁVEL", tituloLinkavel.representacaoCompleta());
        assertEquals("Total termos: 3\n" + " A2 ,  M3, T3 ", termosAlf.representacaoCompleta());
        assertEquals("Total termos: 3\n" + " Alfabeto , Teste ,  Mão", termosTam.representacaoCompleta());
        assertEquals("Total termos: 3\n" + "T1 ,  A2 ,  M3", termos.representacaoCompleta());
        assertEquals("Total termos: 3\n" + "Teste ,  termos ,  Aleatórios\n", atalho.representacaoCompleta());
    }

    @Test
    void representacaoResumida() {
        assertEquals("termos - da - lista", lista.representacaoResumida());
        assertEquals("Texto teste", texto.representacaoCompleta());
        assertEquals("3. Titulo", titulo.representacaoResumida());
        assertEquals("3. Titulo Linkável", tituloLinkavel.representacaoResumida());
        assertEquals(" A2  |  M3 | T3 ", termosAlf.representacaoResumida());
        assertEquals(" Alfabeto  | Teste  |  Mão", termosTam.representacaoResumida());
        assertEquals("T1  |  A2  |  M3", termos.representacaoResumida());
        assertEquals("Teste  /  termos  /  Aleatórios\n", atalho.representacaoResumida());
    }
}