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
    @DisplayName("Adicionar contatos na lista")
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
    @DisplayName("Muda telefone dos contatos na lista")
    void testaMudancaTelefone() {
        //Sem lançamento de Exceção
        agendaBase.mudarTelefone(2,  "123456789");
        //Telefone nulo
        assertThrows(NullPointerException.class,
                () -> agendaBase.mudarTelefone(3, null));
        //Telefone vazio
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.mudarTelefone(3, ""));
        // Posição inválida
        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.mudarTelefone(200, "123456789"));

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
        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.cadastraContato(0, "João", "Gaudencio", "(83) 99999-0000"));
        //Acima do limite
        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.cadastraContato(101, "João", "Gaudencio", "(83) 99999-0000"));
    }

    @Test
    @DisplayName("Adicionar contatos com campos obrigatórios vazios")
    void testaCadastroObrigatoriosVazios() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(1, "João", "Gaudencio", ""));
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000"));
    }

    @Test
    @DisplayName("Adicionar contatos com campos obrigatórios nulos")
    void testaCadastroObrigatoriosNulos() {
        assertThrows(NullPointerException.class,
                () -> agendaBase.cadastraContato(1, "João", "Gaudencio", null));
        assertThrows(NullPointerException.class,
                () -> agendaBase.cadastraContato(1, null, "Gaudencio", "(83) 99999-0000"));
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
        System.out.println("--------------------");
    }

    @Test
    @DisplayName("Pegar contato")
    void testaPegarContato() {
        Contato contato = agendaBase.getContato(2);
        System.out.println(contato);
        System.out.println("--------------------");
    }

    @Test
    @DisplayName("Listar contatos")
    void testaListaContatos() {
        String[] listaContatos = agendaBase.listaContatos();
        for (String s: listaContatos) {
            System.out.println(s);
        }
        System.out.println("--------------------");
    }

    @Test
    @DisplayName("Remover um contato")
    void testaRemoverContato() {

        agendaBase.removeContato(1);
        assertEquals("",  agendaBase.getContato(1).getNome());
    }

    @Test
    @DisplayName("Remover um contato que é favoritado")
    void testaRemoverContatoFavoritado() {
        agendaBase.cadastraFavorito(agendaBase.getContato(1), 1);

        agendaBase.removeContato(1);
        assertEquals("",  agendaBase.getContato(1).getNome());
        assertEquals("",  agendaBase.getFavorito(1).getNome());
    }

    @Test
    @DisplayName("Remover contato com índice inválido")
    void testaRemoveContatoIndiceInvalido() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.removeContato(110));

        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.removeContato(0));
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
        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.cadastraFavorito(agendaBase.getContato(1), 0));
        //Acima do limite
        assertThrows(IndexOutOfBoundsException.class,
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
        System.out.println("--------------------");
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
        System.out.println("--------------------");
    }

   @Test
    @DisplayName("Remover um favorito")
    void testaRemoverFavorito() {
       agendaBase.cadastraFavorito(agendaBase.getContato(1), 1);

       agendaBase.removeFavorito(1);
       assertEquals("",  agendaBase.getFavorito(1).getNome());
    }

    @Test
    @DisplayName("Remover favorito com índice inválido")
    void testaRemoveFavoritoIndiceInvalido() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.removeFavorito(11));

        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.removeFavorito(0));
    }

    @Test
    @DisplayName("Remover favorito que não é favoritado")
    void testaRemoveFavoritoQueNaoEhFavorito() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.removeFavorito(1));
    }

    @Test
    @DisplayName("Exibir um contato favoritado")
    void testaExibeContatoFavorito() {
        agendaBase.cadastraFavorito(agendaBase.getContato(1), 1);
        agendaBase.cadastraFavorito(agendaBase.getContato(2), 2);
        assertEquals("❤ Livia Campos\n(83) 90000-0000", agendaBase.exibeContato(1));
        assertEquals("❤ Ouvidoria UFCG \n(83) 2102-2102", agendaBase.exibeContato(2));
    }

    @Test
    @DisplayName("Exibir um contato que não é favoritado")
    void testaExibeContato() {
        assertEquals("Livia Campos\n(83) 90000-0000", agendaBase.exibeContato(1));
        assertEquals("Ouvidoria UFCG \n(83) 2102-2102", agendaBase.exibeContato(2));
    }
}