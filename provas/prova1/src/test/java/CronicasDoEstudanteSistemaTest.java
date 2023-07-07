import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class CronicasDoEstudanteSistemaTest {

    private CronicasDoEstudanteSistema teste;
    private Cronica c1;

    @BeforeEach
    void setUp(){
        teste = new CronicasDoEstudanteSistema();
        c1 = new Cronica("a", "texto", "20042023");
        teste.cadastrarCronica("a", "texto", "20042023");
        teste.cadastrarCronica("ab", "texto", "20042023");
        teste.cadastrarCronica("abc", "texto", "20042023");
        teste.lerCronica(1);
        teste.lerCronica(1);
    }

    /*@Test
    void criarLivreto() {
        int[] posicoes = {1, 2 ,3};
        teste.criarLivreto(posicoes);
    }

    @Test
    void contemCronicaNoLivreto() {
        int[] posicoes = {1, 2 ,3};
        teste.criarLivreto(posicoes);
        Assertions.assertTrue(teste.contemCronicaNoLivreto("abc", 1));
    }*/

    @Test
    void cadastrarCronica() {
       assertThrows(IllegalArgumentException.class, () -> teste.cadastrarCronica("", "texto", "20042023"));
    }

    @Test
    void testCadastrarCronica() {
        teste.cadastrarCronica("a","texto", "20042023", "ana");
        assertThrows(IllegalArgumentException.class, () -> teste.cadastrarCronica("a", "texto", "20042023"));
    }

    /*@Test
    void exibirCronicaMaisLida() {
        assertEquals(c1.toString(), teste.exibirCronicaMaisLida());
    }*/
}