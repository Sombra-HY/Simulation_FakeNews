import IAs.IaDestruidoraFakeNews;
import IAs.IaGeradoraFakeNews;
import IAs.MeioComunicacaoConfiavel;
import Pessoas.Imovable;
import Pessoas.Pessoa;
import Pessoas.PessoaBemInformada;
import Pessoas.PessoaMalInformada;

import java.util.ArrayList;

public class Mundo {
    public int[][] map = new int[30][60];
    public IaDestruidoraFakeNews iaDfakenews;
    public IaGeradoraFakeNews iGeraFakenews;
    public MeioComunicacaoConfiavel iMeioComunic;


    public ArrayList<Pessoa> listPessoas = new ArrayList<>();

    Mundo(){
        this.iaDfakenews = new IaDestruidoraFakeNews();
        this.iGeraFakenews = new IaGeradoraFakeNews();
        this.iMeioComunic = new MeioComunicacaoConfiavel();
        refazMudo(); //teste
        atualizaMundo();
    }

    public void addPeople(){
//        listPessoas.add(new PessoaBemInformada());
        //TESTE
        listPessoas.add(new PessoaBemInformada());
        //downs problema
    }
    public void atualizaMundo(){
        refazMudo();
//        for (Pessoa el : listPessoas) {
//            map[el.getY()][el.getX()] = el.getCor();
//            Imovable a = (PessoaBemInformada) el;
//            a.moveRandom();
//
//           if(     getElementUp(el.getY(),el.getX()) == 5 ||
//                   getElementDown(el.getY(),el.getX()) == 5 ||
//                   getElementLeft(el.getY(),el.getX()) == 5 ||
//                   getElementRight(el.getY(),el.getX()) == 5
//           ){
//
//           }
//
//        }
        for (int i = 0; i<listPessoas.size();i++) {
            map[listPessoas.get(i).getY()][listPessoas.get(i).getX()] = listPessoas.get(i).getCor();
            Imovable a = (listPessoas.get(i) instanceof PessoaBemInformada)? (PessoaBemInformada) listPessoas.get(i): (PessoaMalInformada) listPessoas.get(i);
//            Imovable a = (PessoaBemInformada) listPessoas.get(i);
            a.moveRandom();

            // CONDICAO DE COL
            int[] numeros ={
                    getElementUp(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementDown(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementLeft(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementRight(listPessoas.get(i).getY(),listPessoas.get(i).getX())};
            for (int el :numeros ){
                if(el == 4){
                    if (listPessoas.get(i) instanceof PessoaBemInformada && !((PessoaBemInformada) listPessoas.get(i)).getProtecaoFakenews())
                        iMeioComunic.ativaProtecaoFN((PessoaBemInformada) listPessoas.get(i));
                }
                else if (el == 5){
                    if(listPessoas.get(i) instanceof PessoaBemInformada)
                        listPessoas.set(i,iGeraFakenews.changeMalInform( listPessoas.get(i)));
                } else if (el == 6) {
                    if(listPessoas.get(i) instanceof PessoaMalInformada)
                        listPessoas.set(i,iaDfakenews.changePessoaBem(listPessoas.get(i)));
                }

            }


        }

    }

    public void desenhaMundo(){

        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                switch (ints[j]) {
                    case 0 -> System.out.print("\033[40m  \033[0m"); // Vazio
                    case 1 -> System.out.print("\033[41m  \033[0m"); // protecao
                    case 2 -> System.out.print("\033[42m  \033[0m"); // PessobemInf Verde
                    case 3 -> System.out.print("\033[43m  \033[0m"); // PessoMalInf amarelo
                    case 4 -> System.out.print("\033[44m  \033[0m"); // MeioConfiavel azul Claro
                    case 5 -> System.out.print("\033[45m  \033[0m"); // Iageradora de fakeNews Roxo
                    case 6 -> System.out.print("\033[46m  \033[0m"); // IaDestruidora fakenwes Ciano
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

    public void extracted() {
        System.out.printf("X: %d Y:%d\n",listPessoas.get(0).getX(),listPessoas.get(0).getY());
        System.out.printf("""
                      %d
                      ^
                      |
                %d<--objecto--> %d
                      |
                      v
                      %d
                """,getElementUp(listPessoas.get(0).getY(),listPessoas.get(0).getX()),
                getElementLeft(listPessoas.get(0).getY(),listPessoas.get(0).getX()),
                        getElementRight(listPessoas.get(0).getY(),listPessoas.get(0).getX()),
                                getElementDown(listPessoas.get(0).getY(),listPessoas.get(0).getX())

                );
        System.out.println(getElementUp(35,25));
    }
    // teste de posicao
    public static void main(String[] args) {
        Mundo a = new Mundo();
        a.addPeople();
//        a.atualizaMundo();
        a.desenhaMundo();
    }

    public void refazMudo(){
        for(int eixoX = 0; eixoX < map.length; eixoX++ )
            for (int eixoY = 0; eixoY < map[0].length; eixoY++)
                map[eixoX][eixoY] = 0;

        // IAS

        map[iMeioComunic.getY()][iMeioComunic.getX()] = iMeioComunic.getCor();
        map[iGeraFakenews.getY()][iGeraFakenews.getX()] = iGeraFakenews.getCor();
        map[iaDfakenews.getY()][iaDfakenews.getX()] = iaDfakenews.getCor();

    }

    // Valores ordenados
//    public void detec(Pessoa el){
//        switch (getElementUp(el.getY(),el.getX())){
//            case 2-> el.
//            default -> {}
//        }
//    }


    public int somaLimits(int atual, int soma, int startlimit, int endLimit){
        return (atual+soma > endLimit)?
                (startlimit):(atual+soma < startlimit)?(endLimit):(atual+soma);
    }

    public int getElementUp(int posPessoaY,int intposPessoaX){
//        System.out.println("a"+somaLimits(posPessoaY,-1,0,29));
//        System.out.println("c"+somaLimits(intposPessoaX,0,0,1));
        return map[somaLimits(posPessoaY,-1,0,29)][somaLimits(intposPessoaX,0,0,59)];
    }
    public int getElementDown(int posPessoaY,int intposPessoaX){
        return map[somaLimits(posPessoaY,1,0,29)][somaLimits(intposPessoaX,0,0,59)];
    }
    public int getElementRight(int posPessoaY,int intposPessoaX){
        return map[somaLimits(posPessoaY,0,0,59)][somaLimits(intposPessoaX,1,0,59)];
    }
    public int getElementLeft(int posPessoaY,int intposPessoaX){
        return map[somaLimits(posPessoaY,0,0,59)][somaLimits(intposPessoaX,-1,0,59)];
    }
}
