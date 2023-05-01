import java.util.Date;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Mundo teste = new Mundo();
        Date tempo_inicio = new Date();
        while (true){
            Date current_time = new Date();
            System.out.println("=======================================");
            System.out.println("Tempo de Simulação: "
                    + (current_time.getTime()
                    - tempo_inicio.getTime()) / 1000);
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