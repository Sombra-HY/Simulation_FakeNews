public class Mundo {
    public int[][] map = new int[30][60];

    public Mundo(){
        refazMudo();
    }
    
    void atualizaMundo(){

    }
    void desenhaMundo(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                switch(map[i][j]){
                    case 0:
                        System.out.print("\033[47m \033[0m");
                        break;
                    case 1:
                        System.out.print("\033[47m \033[0m");
                        break;
                    case 2:
                        System.out.print("\033[45m \033[0m");
                        break;
                    case 3:
                        System.out.print("\033[44m \033[0m");
                        break;
                    case 4:
                        System.out.print("\033[41m \033[0m");
                        break;
                    case 5:
                        System.out.print("\033[43m \033[0m");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    void refazMudo(){
        for(int eixoX = 0; eixoX < map.length; eixoX++ )
            for (int eixoY = 0; eixoY < map[0].length; eixoY++)
                map[eixoX][eixoY] = 0;
    }






}
