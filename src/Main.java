import Pessoas.Pessoa;
import Pessoas.PessoaBemInformada;
import Pessoas.PessoaMalInformada;

import java.util.Date;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {


        Mundo teste = new Mundo();
        Date tempo_inicio = new Date();
        for (int i = 0; i <8 ; i++) {
            teste.addPeople();
        }

        while (true){
            // types contar pessoas
            int pn= 0;
            int pp = 0;
            int pm = 0;

            for(Pessoa el:teste.listPessoas){
                if (el instanceof PessoaMalInformada){
                    pm++;
                    continue;
                }
                pn++;
            }


            Date current_time = new Date();
            System.out.println("=======================================");
            System.out.println("Tempo de Simulação: "
                    + (current_time.getTime()
                    - tempo_inicio.getTime()) / 1000 + "(s)");
            System.out.println("=======================================");
            System.out.println(" Pessoas Bem informadas " + pn +" \033[42m  \033[0m "+ "Pessoas Mal Informadas \033[43m  \033[0m" + pm+ " ");

            System.out.println();
            System.out.println();
            System.out.println();


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