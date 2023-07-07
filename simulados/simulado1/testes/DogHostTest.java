package testes;

import org.junit.Test;

import src.Dog;
import src.DogHost;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DogHostTest {

    @Test
    public void testaAdicionarCachorro(){
        DogHost dh1 = new DogHost("dh1", 500, 3);
        dh1.adicionaDog("Julie", "André", 100);
        dh1.adicionaDog("Toto", "Maty", 100);
        dh1.adicionaDog("Neca", "André", 100);
    }

    @Test
    public void testaCachorroComRestricao() {
        Dog dh1 = new Dog("Julie", "André", 100, "diabetes");
        assertEquals(200, dh1.getQtdRacao());
    }

        @Test
    public void testaAdicionarCachorroAcimaLimite(){
        DogHost dh1 = new DogHost("dh1", 500, 3);
        dh1.adicionaDog("Julie", "André", 100);
        dh1.adicionaDog("Toto", "Maty", 100);
        dh1.adicionaDog("Neca", "André", 100);
        assertThrows(IllegalArgumentException.class, () -> dh1.adicionaDog("Bela", "Ana", 100));
    }

    @Test
    public void testaAdicionarCachorroAcimaLimiteRacao(){
        DogHost dh1 = new DogHost("dh1", 500, 3);
        assertThrows(IllegalArgumentException.class, () -> dh1.adicionaDog("Bela", "Ana", 600));
    }

    @Test
    public void testaAdicionarCachorroRepetido(){
        DogHost dh1 = new DogHost("dh1", 500, 3);
        dh1.adicionaDog("Julie", "André", 100);
        dh1.adicionaDog("Toto", "Maty", 100);
        dh1.adicionaDog("Neca", "André", 100);
        assertThrows(IllegalArgumentException.class, () -> dh1.adicionaDog("Neca", "André", 100));
    }


    @Test
    public void TestaValorHospedagem(){
        DogHost dh1 = new DogHost("dh1", 500, 3);
        dh1.adicionaDog("Julie", "André", 100);
        dh1.adicionaDog("Toto", "Maty", 100);
        Dog d1 = new Dog("Julie", "André", 100);
        assertEquals(120.0, dh1.consultaValorHospedagem(d1, 3), 0.001);
    }

    @Test
    public void TestaValorHospedagemSemDias(){
        DogHost dh1 = new DogHost("dh1", 500, 3);
        dh1.adicionaDog("Julie", "André", 100);
        dh1.adicionaDog("Toto", "Maty", 100);
        Dog d1 = new Dog("Julie", "André", 100);
        assertEquals(0, dh1.consultaValorHospedagem(d1, 0), 0.001);
    }

    @Test
    public void TestaValorHospedagemCachorroErrado(){
        DogHost dh1 = new DogHost("dh1", 500, 3);
        dh1.adicionaDog("Julie", "André", 100);
        dh1.adicionaDog("Toto", "Maty", 100);
        Dog d1 = new Dog("Neca", "André", 100);
        assertThrows(IllegalArgumentException.class, () -> dh1.consultaValorHospedagem(d1, 3));
    }

}
