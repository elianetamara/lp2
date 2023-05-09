package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampeonatoTest {

    private Campeonato campeonatoTest;
    private Time timeTest1;
    private Time timeTest2;
    private Time timeTest3;

    @BeforeEach
    void setUp() {
        this.campeonatoTest = new Campeonato("Brasileirão Série A 2023", 3);
        campeonatoTest.adicionaTime(new Time("250_PB", "CAMPINENSE", "RAPOSA"));
        campeonatoTest.adicionaTime(new Time("260_PB", "TREZE", "GALO"));
    }

    @Test
    @DisplayName("Verificar se time existe no campeonato")
    void existeTime() {
        //código válido
        assertEquals(true, campeonatoTest.existeTime("250_PB"));
        //códgoo inválido
        assertEquals(flase, campeonatoTest.existeTime("300_PB"))
    }

    @Test
    @DisplayName("Adicionar time no campeonato")
    void adicionaTime() {
        campeonatoTest.adicionaTime( new Time("270_PB", "SPORT LAGOA SECA", "CANÁRIO"));
        assertEquals(true, campeonatoTest.existeTime("270_PB"));
        // adiciona acima do limite
        assertThrows(IllegalStateException.class, () ->  campeonatoTest.adicionaTime( new Time("3000_PB", "SPORT", "GAVIÃO"));)
    }
}