import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClasseTest {

    @Test
    public void testSorteiaNumeros() {
        List<Integer> numerosSorteados = Classe.sorteiaNumeros();
        assertEquals(6, numerosSorteados.size());
    }

    @Test
    public void testSorteiaNumerosSemRepeticao() {
        List<Integer> numerosSorteados = Classe.sorteiaNumeros();

        Set<Integer> conjuntoNumeros = new HashSet<>(numerosSorteados);
        assertEquals(numerosSorteados.size(), conjuntoNumeros.size());
    }

    @Test
    public void testSorteiaNumerosIntervalo() {
        List<Integer> numerosSorteados = Classe.sorteiaNumeros();
        for (int numero : numerosSorteados) {
            assertTrue(numero >= 1 && numero <= 60);
        }
    }

    @Test
    public void testValidaJogoTamanhoInvalidoMaiorQue15() {
        List<Integer> jogoInvalido = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        assertThrows(Exception.class, () -> Classe.validaJogo(jogoInvalido));
    }

    @Test
    public void testValidaJogoTamanhoInvalidoMenorQue6() {
        List<Integer> jogoInvalido = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(Exception.class, () -> Classe.validaJogo(jogoInvalido));
    }

    @Test
    public void testValidaJogoNumeroInvalidoMaiorQue60() {
        List<Integer> jogoInvalido = Arrays.asList(61, 2, 3, 4, 5, 6);
        assertThrows(Exception.class, () -> Classe.validaJogo(jogoInvalido));
    }

    @Test
    public void testValidaJogoNumeroInvalidoMenorQue1() {
        List<Integer> jogoInvalido = Arrays.asList(0, 2, 3, 4, 5, 6);
        assertThrows(Exception.class, () -> Classe.validaJogo(jogoInvalido));
    }

    @Test
    public void testValidaJogoNumeroRepetido() {
        List<Integer> jogoInvalido = Arrays.asList(1, 2, 3, 4, 5, 1);
        assertThrows(Exception.class, () -> Classe.validaJogo(jogoInvalido));
    }

    @Test
    public void testValidaJogoValido6Numeros() {
        List<Integer> jogoValido = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Classe.loteria(jogoValido, 100.0));
    }

    @Test
    public void testValidaJogoValido15Numeros() {
        List<Integer> jogoValido = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        assertDoesNotThrow(() -> Classe.loteria(jogoValido, 100.0));
    }

    @Test
    public void testCalcularPremio6Acertos() {
        double premio = Classe.calcularPremio(100.0, 6);
        assertEquals(100.0, premio, 0.001);
    }

    @Test
    public void testCalcularPremio5Acertos() {
        double premio = Classe.calcularPremio(100.0, 5);
        assertEquals(20.0, premio, 0.001);
    }

    @Test
    public void testCalcularPremio4Acertos() {
        double premio = Classe.calcularPremio(100.0, 4);
        assertEquals(5.0, premio, 0.001);
    }

    @Test
    public void testCalcularPremioSemPremio() {
        double premio = Classe.calcularPremio(100.0, 3);
        assertEquals(0.0, premio, 0.001);
    }

    @Test
    public void testConfereNumeros0Acertos() {
        List<Integer> jogoVencedor = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> jogoValido = Arrays.asList(7, 8, 9, 10, 11, 12);
        int acertos = Classe.confereNumeros(jogoVencedor, jogoValido);
        assertEquals(0, acertos);
    }

    @Test
    public void testConfereNumeros3Acertos() {
        List<Integer> jogoVencedor = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> jogoValido = Arrays.asList(3, 4, 5, 7, 8, 9);
        int acertos = Classe.confereNumeros(jogoVencedor, jogoValido);
        assertEquals(3, acertos);
    }

    @Test
    public void testConfereNumeros6Acertos() {
        List<Integer> jogoVencedor = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> jogoValido = Arrays.asList(1, 2, 3, 4, 5, 6);
        int acertos = Classe.confereNumeros(jogoVencedor, jogoValido);
        assertEquals(6, acertos);
    }

}