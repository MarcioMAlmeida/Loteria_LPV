import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> jogo = new ArrayList<>();

        jogo.add(1);
        jogo.add(2);
        jogo.add(14);
        jogo.add(19);
        jogo.add(26);
        jogo.add(32);

         Classe loteria = new Classe();

        double premio = 0;
        int tentativas = 0;

        while(premio != 1000000){
             premio = loteria.loteria(jogo, 1000000);
            tentativas++;
        }

        System.out.println("Você tentou: "+tentativas+" vezes para ganhar: R$"+premio);
    }
}