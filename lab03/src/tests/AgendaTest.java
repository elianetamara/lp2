package tests;

import agenda.Agenda;
import agenda.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AgendaTest {
    private Agenda agendaBase;

    @BeforeEach
    void setUp() {
        agendaBase = new Agenda();
        agendaBase.cadastraContato(1, "Livia", "Campos", "(83) 90000-0000");
        agendaBase.cadastraContato(2, "Ouvidoria UFCG", "", "(83) 2102-2102");
        agendaBase.cadastraContato(3, "Maria", "Tamara", "831234-1234");
        agendaBase.cadastraContato(4, "Ana", "lima", "477123");
        agendaBase.cadastraContato(5, "Matheus", "Gaudencio", "(83) 99999-0000");
        agendaBase.cadastraContato(100, "Eliane", "Tamara", "839876-1234");
    }

    @Test
    @DisplayName("Adicionar contatos a lista sem lançamento de exceção")
    void testaCadastraContatos() {
        Agenda agenda = new Agenda();
        //Posições vazias
        agenda.cadastraContato(2, "Ouvidoria UFCG", "", "(83) 2102-2102");
        agenda.cadastraContato(3, "Maria", "Tamara", "831234-1234");
        agenda.cadastraContato(4, "Ana", "lima", "477123");
        //Posições limite
        agenda.cadastraContato(1, "Livia", "Campos", "(83) 90000-0000");
        agenda.cadastraContato(100, "Eliane", "Tamara", "839876-1234");
        //Posição sobrescrita
        agenda.cadastraContato(1, "João", "Silva", "(84) 98888-1111");

    }

    @Test
    @DisplayName("Adicionando contato duplicado")
    void testaCadastroContatoDuplicado() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-1111"));
    }

    @Test
    @DisplayName("Posição inválida")
    void testaCadastroPosicaoInvalida() {
        //Abaixo do limite
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(0, "João", "Gaudencio", "(83) 99999-0000"));
        //Acima do limite
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(101, "João", "Gaudencio", "(83) 99999-0000"));
    }

    @Test
    @DisplayName("Campos obrigatórios vazios")
    void testaCadastroSemObrigatorios() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(1, "João", "Gaudencio", ""));
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000"));
    }

    @Test
    @DisplayName("Pegar contatos")
    void testaPegarContatos() {
        Contato[] contatos = agendaBase.getContatos();
        for (Contato contato : contatos) {
            if (!contato.getNome().equals( "")) {
                System.out.println(contato);
            }
        }
    }

    @Test
    @DisplayName("Pegar contato")
    void testaPegarContato() {
        Contato contato = agendaBase.getContato(2);
        System.out.println(contato);
    }

    @Test
    @DisplayName("Listar contatos")
    void testaListaContatos() {
        String[] listaContatos = agendaBase.listaContatos();
        for (String s: listaContatos) {
            System.out.println(s);
        }
    }

    @Test
    @DisplayName("Adicionar um favorito")
    void testaAdicionarFavorito() {
        // Posições limite
        agendaBase.cadastraFavorito(agendaBase.getContato(1), 1);
        agendaBase.cadastraFavorito(agendaBase.getContato(2), 10);
    }

    @Test
    @DisplayName("Adicionando contato favorito duplicado")
    void testaFavoritoDuplicado() {
        agendaBase.cadastraFavorito(agendaBase.getContato(1), 1);
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraFavorito(agendaBase.getContato(1), 2));
    }

    @Test
    @DisplayName("Adicionando contato favorito com posição inválida")
    void testaFavoritoPosicaoInvalida() {
        //Abaixo do limite
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraFavorito(agendaBase.getContato(1), 0));
        //Acima do limite
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraFavorito(agendaBase.getContato(1), 11));
    }


    @Test
    @DisplayName("Pegar contatos favoritos")
    void testaPegarFavoritos() {
        agendaBase.cadastraFavorito(agendaBase.getContato(1), 1);
        agendaBase.cadastraFavorito(agendaBase.getContato(2), 10);
        Contato[] favoritos = agendaBase.getFavoritos();
        for (Contato fav : favoritos) {
            if (!fav.getNome().equals( "")) {
                System.out.println(fav);
            }
        }
    }

    @Test
    @DisplayName("Listar favoritos")
    void testaListaFavoritos() {
        agendaBase.cadastraFavorito(agendaBase.getContato(1), 1);
        agendaBase.cadastraFavorito(agendaBase.getContato(2), 10);
        String[] listaFavoritos = agendaBase.listaFavoritos();
        for (String s: listaFavoritos) {
            System.out.println(s);
        }
    }

   @Test
    @DisplayName("Remover um favorito")
    void testaRemoverFavorito() {
       agendaBase.cadastraFavorito(agendaBase.getContato(1), 1);

       agendaBase.removeFavorito(1);
       assertEquals("",  agendaBase.getFavoritos()[1].getNome());
    }

    @Test
    @DisplayName("Remover favorito com índice inválido")
    void testaRemoveFavoritoIndiceInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.removeFavorito(11));

        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.removeFavorito(0));
    }

    @Test
    @DisplayName("Remover favorito que não é favoritado")
    void testaRemoveFavoritoQueNaoEhFavorito() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.removeFavorito(1));
    }

    /*@Test
    @DisplayName("Quando eu preciso exibir um contato favoritado")
    void QuandoPrecisoPegarContatosFavorito() {
        agendaBase.cadastraContato(1, "Matheus", "Gaudêncio", "(83) 21012101");
        agendaBase.cadastraContato(2, "John", "Doe", "(83) 996303247");
        Contato contato1 = agendaBase.getContato(1);
        Contato contato2 = agendaBase.getContato(2);

        agendaBase.cadastraFavorito(contato1, 1);
        agendaBase.cadastraFavorito(contato2, 2);
    }*/

}