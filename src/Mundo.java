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
        // contato entre pessoas
        for (int i = 0; i <listPessoas.size() ; i++) {


            for (int j = 0; j <listPessoas.size(); j++) {


                //self
                if(listPessoas.get(i).getY() == (listPessoas.get(j).getY()) &&
                    listPessoas.get(i).getX() == listPessoas.get(j).getX()){

                        listPessoas.get(i).ShareWhatsapp(listPessoas.get(j).getWhatsappId());

                } else if (listPessoas.get(i).getY() == (listPessoas.get(j).getY() - 1) &&
                        listPessoas.get(i).getX() == listPessoas.get(j).getX()) {

                        listPessoas.get(i).ShareWhatsapp(listPessoas.get(j).getWhatsappId());


                } else if (listPessoas.get(i).getY() ==(listPessoas.get(j).getY() + 1) &&
                        listPessoas.get(i).getX() == listPessoas.get(j).getX()) {

                        listPessoas.get(i).ShareWhatsapp(listPessoas.get(j).getWhatsappId());


                } else if (listPessoas.get(i).getY() ==listPessoas.get(j).getY() &&
                        listPessoas.get(i).getX() == (listPessoas.get(j).getX() + 1)) {

                        listPessoas.get(i).ShareWhatsapp(listPessoas.get(j).getWhatsappId());


                } else if (listPessoas.get(i).getY() ==listPessoas.get(j).getY() &&
                        listPessoas.get(i).getX() == (listPessoas.get(j).getX() - 1)) {

                        listPessoas.get(i).ShareWhatsapp(listPessoas.get(j).getWhatsappId());


                }


            }
        }

//        quant de pessoas
        for (int i = 0; i<listPessoas.size();i++) {
            map[listPessoas.get(i).getY()][listPessoas.get(i).getX()] = listPessoas.get(i).getCor();

            // CONDICAO DE COLisao entre IAS
            int[] numeros ={
                    getElementUp(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementDown(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementLeft(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementRight(listPessoas.get(i).getY(),listPessoas.get(i).getX())};
//            System.out.println(listPessoas.get(i).getY()+" "+listPessoas.get(i).getX() +
//                    " "+numeros[0]+" "+numeros[1]+" "+numeros[2]+" "+numeros[3]);
            for (int j = 0; j < numeros.length; j++) {
                int el = numeros[j];
//                if (el == 2) {
//                    //UP
//                    if(j==0){
//                        listPessoas.get(i).ShareWhatsapp(
//                        (serchPeopleCord(listPessoas.get(i).getY(),listPessoas.get(i).getX(),"UP").getWhatsappId()));
//                        System.out.println(listPessoas.get(i).getAgendaContatos());
//                        continue;
//                    }
//                    if (j==1) {
//                        listPessoas.get(i).ShareWhatsapp(
//                                (serchPeopleCord(listPessoas.get(i).getY(),listPessoas.get(i).getX(),"DOWN").getWhatsappId()));
//                        System.out.println(listPessoas.get(i).getAgendaContatos());
//                        continue;
//                    }
//                    if( j==2 ){
//                        listPessoas.get(i).ShareWhatsapp(
//                                (serchPeopleCord(listPessoas.get(i).getY(),listPessoas.get(i).getX(),"LEFT").getWhatsappId()));
//                        System.out.println(listPessoas.get(i).getAgendaContatos());
//                        continue;
//                    }
//                    listPessoas.get(i).ShareWhatsapp(
//                            (serchPeopleCord(listPessoas.get(i).getY(),listPessoas.get(i).getX(),"RIGHT").getWhatsappId()));
//                    System.out.println(listPessoas.get(i).getAgendaContatos());
//                    continue;
//
////                    listPessoas.get(i).ShareWhatsapp();//AQUi
//                }
//                if(el == 2 ){
//                    if(listPessoas.get(i) instanceof PessoaBemInformada){
//                        int x = listPessoas.get(i).getX();
//                        int y = listPessoas.get(i).getY();
//                        System.out.println("CORDENADA"+x+"-"+y);
//
//                        try{
//                            String ID = serchPeopleCord(y,x,
//                                    ((j==0)?"UP":(j==1)?"DOWN":(j==2)?"LEFT":"RIGHT")).getWhatsappId();
//                            listPessoas.get(i).ShareWhatsapp(ID);
//                            System.out.println("ELE GOSTA");
//                            System.out.println(listPessoas.get(i).getAgendaContatos());
//                        }catch(NullPointerException e){
//                            continue;
//                        }
//
//                    }
//                }

                if (el == 4) {
                    if (listPessoas.get(i) instanceof PessoaBemInformada && !((PessoaBemInformada) listPessoas.get(i)).getProtecaoFakenews())
                        iMeioComunic.ativaProtecaoFN((PessoaBemInformada) listPessoas.get(i));
                } else if (el == 5) {
                    if (listPessoas.get(i) instanceof PessoaBemInformada) {

                        if(!((PessoaBemInformada) listPessoas.get(i)).getProtecaoFakenews()){
                            listPessoas.set(i, iGeraFakenews.changeMalInform(listPessoas.get(i)));

                            for (String id: listPessoas.get(i).getAgendaContatos()) {
                                System.out.println(serchPeopleid(id) == null ?"NULL":"bi");

                                if(serchPeopleid(id) instanceof PessoaBemInformada){
                                    System.out.println("CONTAMINO");
                                    listPessoas.set(
                                            listPessoas.indexOf(serchPeopleid(id)),
                                            iGeraFakenews.changeMalInform(serchPeopleid(id))
                                    );
                                }

                            }

                        }

                    }
                } else if (el == 6) {
                    if (listPessoas.get(i) instanceof PessoaMalInformada)
                        listPessoas.set(i, iaDfakenews.changePessoaBem(listPessoas.get(i)));
                }
            }
            //AQUI TESTE
            Imovable a = (listPessoas.get(i) instanceof PessoaBemInformada)? (PessoaBemInformada) listPessoas.get(i): (PessoaMalInformada) listPessoas.get(i);
            a.moveRandom();
        }
    }

    public void desenhaMundo(){
        //ALCONTATOS
        contatosAll();

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

    public void extracted(int i) {
        System.out.printf("X: %d Y:%d\n",listPessoas.get(i).getX(),listPessoas.get(i).getY());
        System.out.printf("""
                      %d
                      ^
                      |
                %d<--objecto--> %d
                      |
                      v
                      %d
                """,getElementUp(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                getElementLeft(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                        getElementRight(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                                getElementDown(listPessoas.get(i).getY(),listPessoas.get(i).getX())

                );
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

    public int somaLimits(int atual, int soma, int startlimit, int endLimit){
        return (atual+soma > endLimit)?
                (startlimit):(atual+soma < startlimit)?(endLimit):(atual+soma);
    }

    public int getElementUp(int posPessoaY,int intposPessoaX){
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

    public Pessoa serchPeopleid(String id){
        for(Pessoa el : listPessoas){
            System.out.println("AQUI__"+ el.getWhatsappId() + " = " + id + " " + el.getWhatsappId().equals(id) );
            if(el.getWhatsappId().equals(id)) {
                System.out.println("s?");
                return el;
            }
        }
        return null;
    }

    public void contatosAll(){
        for (Pessoa p1:listPessoas) {
            for (Pessoa p2:listPessoas) {
                p2.getAgendaContatos().add(p1.getWhatsappId());
            }
        }
    }

}

