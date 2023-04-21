package tests;

import agenda.Agenda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AgendaTest {
    private Agenda agendaBase;

    @BeforeEach
    void setUp() {
        agendaBase = new Agenda();
        agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        agendaBase.cadastraContato(3, "maria", "silva", "0928130");
        agendaBase.cadastraContato(4, "maria", "lima", "477123");
        agendaBase.cadastraContato(100, "contato", "cem", "09374937390");

    }

    @Test
    void testaCadastraPosicaoVazia() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio", agenda.getContatos()[0].toString());
    }

    @Test
    void testaCadastraSobrescrita() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio", agenda.getContatos()[0].toString());
        agenda.cadastraContato(1, "JOão", "Silva", "(84) 98888-1111");
        assertEquals("João Silva", agenda.getContatos()[0].toString());
    }

    @Test
    void testaCadastraContatoDuplicado() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        try {
            agenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000");
            fail("Deve lançar exceção");
        } catch (IllegalCallerException e ) {
            assertEquals("CONTATO JÁ CADASTRADO", e.getMessage());
        }
    }

    @Test
    void testaCadastraPosicaoLimite() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio", agenda.getContatos()[99].toString());
    }
    @Test
    void testaCadastraAcimaLimite() {
        Agenda agenda = new Agenda();
        try {
            agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000");
            fail("Deve lançar exceção");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }

    @Test
    void testaCadastraAbaixoLimite() {
        Agenda agenda = new Agenda();
        try {
            agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000");
            fail("Deve lançar exceção");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }

    @Test
    void testaCadastraSemTelefone() {
        Agenda agenda = new Agenda();
        try {
            agenda.cadastraContato(3, "Matheus", "Gaudencio", "");
            fail("Deve lançar exceção");
        } catch (IllegalArgumentException e ) {
            assertEquals("CONTATO INVÁLIDO - Telefone Vazio", e.getMessage());
        }
    }

    @Test
    void testaCadastraSemNome() {
        Agenda agenda = new Agenda();

        try {
            agenda.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000");
            fail("Deve lançar exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("CONTATO INVÁLIDO - Nome Vazio", e.getMessage());
        }
    }

    // ajeitar isso aq
    @Test
    void testaRepresentacaoContato() {
        assert agendaBase.getContato(1).toString().equals("Matheus Gaudencio\n(83) 99999-0000");
    }

    @Test
    void testaTemContato() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertNotNull(agendaBase.getContatos()[0], "Deve ter contato cadastrado na posição.");
    }

   // faltando testes de favorito

}