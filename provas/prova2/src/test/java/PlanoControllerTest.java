import controller.PlanoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlanoControllerTest {

    private PlanoController planoController;

    @BeforeEach
    void setUp(){
        planoController = new PlanoController();
        planoController.cadastrarPlanoPosBig("Plano teste pos big", "123456789", "1234-5678", 5.0);
        planoController.cadastrarPlanoPreBig("Plano teste pre big", "123456789", "1234-5679", 5, 15.0, 2.0 );
        planoController.cadastrarAdicionalInternet("Plano internet", 20);
        planoController.cadastrarAdicionalMusica("plano spotify", "Spotify");
    }

    @Test
    void valorAPagar() {
        assertEquals(50.0, planoController.valorAPagar(1, 10));
        // sem ultrapassar quantidade de dias do plano pre big
        assertEquals(0, planoController.valorAPagar(2, 4));
        // ultrapassando qauntidade de dias
        assertEquals(10.0, planoController.valorAPagar(2, 10));
        // valor a pagar com adicional de internet
        planoController.setAdicional(1, 1);
        assertEquals(60.0, planoController.valorAPagar(1, 10));
        // valor a pagar com adicional de musica
        planoController.setAdicional(2, 2);
        assertEquals(45.0, planoController.valorAPagar(2, 10));
        // passando id com plano nulo na lista
        assertThrows(IndexOutOfBoundsException.class, () -> planoController.valorAPagar(5, 5));
    }
}