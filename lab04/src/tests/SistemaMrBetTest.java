package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaMrBetTest {

    SistemaMrBet mrBetTest;

    @BeforeEach
    void setup(){
        this.mrBetTest = new SistemaMrBet();
    }

    @Test
    void cadastraTime() {
        assertEquals("INCLUSÃO REALIZADA!", mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO"));
        // parâmetros inválidos
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraTime(null, "NACIONAL DE PATOS", "CANÁRIO"));
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraTime("", "NACIONAL DE PATOS", "CANÁRIO"));
        // time já existente
        assertThrows(IllegalArgumentException.class, () -> mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO"));
    }

    @Test
    void recuperaTime() {
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
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
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        mrBetTest.cadastraTime("002_RJ","CLUBE REGATAS DO FLAMENGO","URUBU");
        mrBetTest.cadastraTime("105_PB","SOCIEDADE RECREATIVA DE MONTEIRO (SOCREMO)","GAVIÃO");
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
        mrBetTest.cadastraCampeonato("Copa do Nordeste 2023", 3);
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
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
    }

    @Test
    void apostaTime() {
    }

    @Test
    void recuperaStatusApostas() {
    }

    @Test
    void recuperaMinParticipacao() {
    }

    @Test
    void recuperaPopularidade() {
    }

    @Test
    void recuperaMaxParticipacao() {
    }
}