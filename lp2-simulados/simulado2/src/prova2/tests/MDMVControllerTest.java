import controller.MDMVController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MDMVControllerTest {

    private MDMVController mdmvController;

    @BeforeEach
    void setUp() {
        mdmvController = new MDMVController();
    }

    @Test
    void getDesafioById() {
    }

    @Test
    void adicionaDesafioPessoal() throws IllegalAccessException {
        assertEquals(0, mdmvController.adicionaDesafioPessoal("teste-pessoal-1", "descricao-1"));
    }

    @Test
    void adicionaDesafioMaterial() {
    }

    @Test
    void adicionaDesafioSocial() {
    }

    @Test
    void exibirDesafio() {
    }

    @Test
    void findAndAtualizaDesafioByTitulo() {
    }

    @Test
    void adicionaAcao() {
    }

    @Test
    void atualizaProgressoAcao() {
    }

    @Test
    void testAtualizaProgressoAcao() {
    }

    @Test
    void listarAcaoOrdemProgresso() {
    }
}