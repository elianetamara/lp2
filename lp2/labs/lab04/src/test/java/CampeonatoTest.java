import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Campeonato;
import src.Time;

import static org.junit.jupiter.api.Assertions.*;

class CampeonatoTest {

    private Campeonato campeonatoTest;

    @BeforeEach
    void setUp() {
        this.campeonatoTest = new Campeonato("Brasileirão Série A 2023", 3);
        campeonatoTest.adicionaTime(new Time("250_PB", "CAMPINENSE", "RAPOSA"));
        campeonatoTest.adicionaTime(new Time("260_PB", "TREZE", "GALO"));
    }

    @Test
    void existeTime() {
        //código válido
        assertTrue(campeonatoTest.existeTime("250_PB"));
        //códgoo inválido
        assertFalse(campeonatoTest.existeTime("300_PB"));
    }

    @Test
    void adicionaTime() {
        campeonatoTest.adicionaTime( new Time("270_PB", "SPORT LAGOA SECA", "CANÁRIO"));
        assertTrue(campeonatoTest.existeTime("270_PB"));
        // adiciona acima do limite
        assertThrows(IllegalStateException.class, () ->  campeonatoTest.adicionaTime( new Time("3000_PB", "SPORT", "GAVIÃO")));
    }
}