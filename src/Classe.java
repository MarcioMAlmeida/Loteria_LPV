import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Classe {

    public double loteria(List<Integer> jogo, double premioTotal) {

        List<Integer> jogoVencedor = sorteiaNumeros();
        
        List<Integer> jogoValido = validaJogo(jogo);

        int acertos = confereNumeros(jogoVencedor, jogoValido);
        double premioGanho = calcularPremio(premioTotal, acertos);

        return premioGanho;
    }

    private static List<Integer> sorteiaNumeros() {
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

    private static List<Integer> validaJogo(List<Integer> jogo) {
        List<Integer> jogoValido = new ArrayList<>();
        for (Integer n: jogo){
            if (n < 1 || n > 60){
                return null;
            }
            if (jogoValido.contains(n)){
                return null;
            }
            jogoValido.add(n);
        }
        return jogoValido;
    }

    private static int confereNumeros(List<Integer> jogoVencedor, List<Integer> jogoValido) {
        int acertos = 0;
        if (jogoValido.size() >= 6 && jogoValido.size() <= 15) {
            for (Integer i: jogoValido){
                if (jogoVencedor.contains(i)){
                    acertos++;
                }
            }
        }
        return acertos;
    }

    private static double calcularPremio(double premioTotal, int acertos) {
        if (acertos == 6){
            return premioTotal;
        } else if (acertos == 5){
            return premioTotal * 0.2;
        } else if (acertos == 4){
            return premioTotal * 0.05;
        }
        return 0.0;
    }

}
