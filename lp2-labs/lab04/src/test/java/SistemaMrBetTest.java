import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.SistemaMrBet;
import src.Time;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SistemaMrBetTest {

    SistemaMrBet mrBetTest;

    @BeforeEach
    void setup(){
        this.mrBetTest = new SistemaMrBet();
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        mrBetTest.cadastraTime("002_RJ","CLUBE REGATAS DO FLAMENGO","URUBU");
        mrBetTest.cadastraTime("105_PB","SOCIEDADE RECREATIVA DE MONTEIRO (SOCREMO)","GAVIÃO");
        mrBetTest.cadastraCampeonato("Copa do Nordeste 2023", 2);
    }

    @Test
    void cadastraTime() {
        assertEquals("INCLUSÃO REALIZADA!", mrBetTest.cadastraTime("300_PB", "CAMPINENSE", "RAPOSA"));
        // parâmetros inválidos
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraTime(null, "NACIONAL DE PATOS", "CANÁRIO"));
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraTime("", "NACIONAL DE PATOS", "CANÁRIO"));
        // time já existente
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraTime("300_PB", "CAMPINENSE", "RAPOSA"));
    }

    @Test
    void recuperaTime() {
        assertEquals( "[250_PB] NACIONAL DE PATOS / CANÁRIO", mrBetTest.recuperaTime("250_PB"));
        // time não existente
        assertThrows(NoSuchElementException.class, () -> mrBetTest.recuperaTime("100_PB"));
    }

    @Test
    void cadastraCampeonato() {
        assertEquals("CAMPEONATO ADICIONADO!", mrBetTest.cadastraCampeonato("Brasileirão Série A 2023", 20));
        // parâmetros inválidos
        assertThrows(IllegalArgumentException.class, () ->  mrBetTest.cadastraCampeonato(null, 20));
        assertThrows(IllegalArgumentException.class, () ->  mrBetTest.cadastraCampeonato("", 20));
        // campeonato já existe
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraCampeonato("Brasileirão Série A 2023", 20));
        // campeonato que já existente sem case sensitive
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraCampeonato("brasiLeirão Série a 2023", 20));
    }

    @Test
    void cadastraTimeCampeonato() {
        mrBetTest.cadastraCampeonato("Brasileirão Série A 2023", 3);
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.cadastraTimeCampeonato("Brasileirão Série A 2023", "250_PB"));
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.cadastraTimeCampeonato("Brasileirão Série A 2023", "252_PB"));
        // incluir time já cadastrado
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.cadastraTimeCampeonato("Brasileirão Série A 2023", "252_PB"));
        // incluir time não cadastrado
        assertThrows(NoSuchElementException.class, () -> mrBetTest.cadastraTimeCampeonato("Brasileirão Série A 2023", "005_PB"));
        // incluir em campeonato não existente
        assertThrows(NoSuchElementException.class, () -> mrBetTest.cadastraTimeCampeonato("Brasileirão Série D 2023", "252_PB"));
        // incluir time excedendo quantidade de participantes
        mrBetTest.cadastraTimeCampeonato("Brasileirão Série A 2023", "002_RJ");
        assertThrows(IllegalStateException.class, () -> mrBetTest.cadastraTimeCampeonato("Brasileirão Série A 2023", "105_PB"));

    }

    @Test
    void recuperaTimeCampeonato() {
        mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "250_PB");
        assertEquals( "O TIME ESTÁ NO CAMPEONATO!",mrBetTest.recuperaTimeCampeonato("Copa do Nordeste 2023", "250_PB"));
        assertEquals( "O TIME NÃO ESTÁ NO CAMPEONATO!",mrBetTest.recuperaTimeCampeonato("Copa do Nordeste 2023", "252_PB"));
        // campeonato não existe
        assertThrows(NoSuchElementException.class, () -> mrBetTest.cadastraTimeCampeonato("Brasileirão série D 2023", "252_PB"));
        // time não existe
        assertThrows(NoSuchElementException.class, () -> mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "005_PB"));
    }

    @Test
    void recuperaCampeonatosTime() {
        String saidaEsperada = "Campeonatos do NACIONAL DE PATOS:\n" + "* Brasileirão 2023 - 1/3";
        mrBetTest.cadastraCampeonato("Brasileirão 2023", 3);
        mrBetTest.cadastraTimeCampeonato("Brasileirão 2023", "250_PB");
        assertEquals(saidaEsperada, mrBetTest.recuperaCampeonatosTime("250_PB"));
        // time não cadastrado
        assertThrows(NoSuchElementException.class, () -> mrBetTest.recuperaCampeonatosTime("005_PB"));
    }

    @Test
    void apostaTime() {
        mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "250_PB");
        mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "252_PB");
        assertEquals("APOSTA REGISTRADA!", mrBetTest.apostaTime("250_PB", "Copa do Nordeste 2023", 1, "10.00"));
        // colocação > quantidade de participantes do campeonato
        assertEquals("APOSTA NÃO REGISTRADA!", mrBetTest.apostaTime("250_PB", "Copa do Nordeste 2023", 10, "10.00"));
        // time não existe
        assertThrows(NoSuchElementException.class, () -> mrBetTest.apostaTime("005_PB", "Copa do Nordeste 2023", 10, "10.00"));
        // campeonato não existe
        assertThrows(NoSuchElementException.class, () -> mrBetTest.apostaTime("250_PB" ,"Brasileirão série D 2023", 10, "10.00"));
        // time não participa do campeonato
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.apostaTime("105_PB" ,"Copa do Nordeste 2023", 10, "10.00"));
    }

    @Test
    void recuperaStatusApostas() {
        String saidaEsperada = "Apostas:\n" + "1. [250_PB] NACIONAL DE PATOS / CANÁRIO\n" + "Copa do Nordeste 2023\n" + "1/2\n" + "R$ 10.00\n";
        mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "250_PB");
        mrBetTest.apostaTime("250_PB", "Copa do Nordeste 2023", 1, "10.00");
        assertEquals(saidaEsperada, mrBetTest.recuperaStatusApostas());
    }

    @Test
    void recuperaMinParticipacao() {
        String saidaEsperada = "[250_PB] NACIONAL DE PATOS / CANÁRIO\n" + "[002_RJ] CLUBE REGATAS DO FLAMENGO / URUBU\n" + "[105_PB] SOCIEDADE RECREATIVA DE MONTEIRO (SOCREMO) / GAVIÃO\n" + "[252_PB] SPORT LAGOA SECA / CARNEIRO\n";
        assertEquals(saidaEsperada, mrBetTest.recuperaMinParticipacao());
    }

    @Test
    void recuperaPopularidade() {
        String saidaEsperada = "NACIONAL DE PATOS / 1\n";
        mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "250_PB");
        mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "252_PB");
        mrBetTest.apostaTime("250_PB", "Copa do Nordeste 2023", 1, "10.00");
        mrBetTest.apostaTime("252_PB", "Copa do Nordeste 2023", 2, "10.00");
        assertEquals(saidaEsperada, mrBetTest.recuperaPopularidade());
    }

    @Test
    void recuperaMaxParticipacao() {
        String saidaEsperada = "[250_PB] NACIONAL DE PATOS / CANÁRIO / 2\n";
        mrBetTest.cadastraCampeonato("Brasileirão", 2);
        mrBetTest.cadastraTimeCampeonato("Brasileirão", "250_PB");
        mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "250_PB");
        mrBetTest.cadastraTimeCampeonato("Copa do Nordeste 2023", "252_PB");
        assertEquals(saidaEsperada, mrBetTest.recuperaMaxParticipacao());
    }
}