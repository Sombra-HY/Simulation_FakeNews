import Pessoas.Imovable;
import Pessoas.Pessoa;
import Pessoas.PessoaBemInformada;
import Pessoas.PessoaMalInformada;

public class Mundo {
    public int[][] map = new int[30][60];
    public Pessoa p1;

    Mundo(){
        refazMudo();
        p1 = new PessoaBemInformada();
        atualizaMundo();


    }

    public void atualizaMundo(){
        refazMudo();
        map[p1.getY()][p1.getX()] = p1.getCor();
        Imovable a = (PessoaBemInformada) p1;
        a.moveRandom();
    }
    public void desenhaMundo(){
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                switch (ints[j]) {
                    case 0 -> System.out.print("\033[40m \033[0m");
                    case 1 -> System.out.print("\033[45m \033[0m");
                    case 2 -> System.out.print("\033[50m \033[0m");
                    case 3 -> System.out.print("\033[55m \033[0m");
                    case 4 -> System.out.print("\033[60m \033[0m");
                    case 5 -> System.out.print("\033[70m \033[0m");
                    default -> {
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void refazMudo(){
        for(int eixoX = 0; eixoX < map.length; eixoX++ )
            for (int eixoY = 0; eixoY < map[0].length; eixoY++)
                map[eixoX][eixoY] = 0;
    }






}
