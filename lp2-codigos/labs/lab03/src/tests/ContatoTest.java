package tests;

import agenda.Contato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContatoTest {

    private Contato contatoTeste;

    @BeforeEach
    void criaContato() {
        this.contatoTeste = new Contato("Eliane", "Tamara", "839876-1234");
    }

    @Test
    void testEquals() {
        assertFalse(contatoTeste.equals("Matheus", "Gaudencio"));
        assertTrue(contatoTeste.equals("Eliane", "Tamara"));
    }

    @Test
    void testaToString() {
        assertEquals("Eliane Tamara\n839876-1234", contatoTeste.toString());
    }

    @Test
    void testaToStringFavorito() {
        Contato contatoFav = new Contato("Maria", "Tamara", "831234-1234");
        contatoFav.setEhFavorito(true);
        assertEquals("❤ Maria Tamara\n831234-1234", contatoFav.toString());
    }

}

