import Pessoas.Pessoa;
import Pessoas.PessoaBemInformada;

import java.util.Date;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Mundo teste = new Mundo();
        Date tempo_inicio = new Date();
        for (int i = 0; i <1 ; i++) {
            teste.addPeople();
        }

        while (true){
            Date current_time = new Date();
            System.out.println("=======================================");
            System.out.println("Tempo de Simulação: "
                    + (current_time.getTime()
                    - tempo_inicio.getTime()) / 1000 + "(s)");
            System.out.println("=======================================");

            teste.atualizaMundo();
            teste.desenhaMundo();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}