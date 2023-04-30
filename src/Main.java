import Pessoas.*;
import IAs.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Mundo teste = new Mundo();
        Date tempo_inicio = new Date();

        while (true){
            Date current_time = new Date();
            /**
             * a cada interação atualiza-se o tempo
             */
            System.out.println("=======================================");
            System.out.println("Tempo de Simulação: "
                    + (current_time.getTime()
                    - tempo_inicio.getTime()) / 1000);
            System.out.println("=======================================");
            teste.desenhaMundo();

            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.getMessage();
            }
        }

    }
}