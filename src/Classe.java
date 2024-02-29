import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Classe {

    public static double loteria(List<Integer> jogo, double premioTotal) {
        int acertos;
        double premioGanho;
        List<Integer> jogoVencedor;
        List<Integer> jogoValido = new ArrayList<>();

        jogoVencedor = sorteiaNumeros();
        try {
            jogoValido = validaJogo(jogo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        acertos = confereNumeros(jogoVencedor, jogoValido);
        premioGanho = calcularPremio(premioTotal, acertos);

        return premioGanho;
    }

    public static List<Integer> sorteiaNumeros() {
        List<Integer> jogoVencedor = new ArrayList<>();
        int s;
        while (jogoVencedor.size() < 6) {
            s = new Random().nextInt(59) + 1;
            if (!jogoVencedor.contains(s)) {
                jogoVencedor.add(s);
            }
        }
        return jogoVencedor;
    }

    public static List<Integer> validaJogo(List<Integer> jogo) throws Exception {
        List<Integer> jogoValido = new ArrayList<>();
        if (jogo.size() < 6 || jogo.size() > 15) {
            throw new Exception("Tamanho do jogo inválido");
        }
        for (Integer n : jogo) {
            if (n < 1 || n > 60) {
                throw new Exception("Jogo contém número inválido");
            }
            if (jogoValido.contains(n)) {
                throw new Exception("Jogo contém números repetidos");
            }
            jogoValido.add(n);
        }
        return jogoValido;
    }

    public static int confereNumeros(List<Integer> jogoVencedor, List<Integer> jogoValido) {
        int acertos = 0;
        for (Integer i : jogoValido) {
            if (jogoVencedor.contains(i)) {
                acertos++;
            }
        }
        return acertos;
    }

    public static double calcularPremio(double premioTotal, int acertos) {
        if (acertos == 6) {
            return premioTotal;
        } else if (acertos == 5) {
            return premioTotal * 0.2;
        } else if (acertos == 4) {
            return premioTotal * 0.05;
        }
        return 0.0;
    }

}
