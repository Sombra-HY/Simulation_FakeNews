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
        listPessoas.add(new PessoaBemInformada());
    }
    public void atualizaMundo(){
        refazMudo();

        // contato entre pessoas
        for (int i = 0; i <listPessoas.size() ; i++) {


            for (Pessoa listPessoa : listPessoas) {
                // colisoes entre o mesmo lugar, direita, esqueda, em cima e em baixo.

                if (listPessoas.get(i).getY() == (listPessoa.getY()) &&
                        listPessoas.get(i).getX() == listPessoa.getX()) {
                    listPessoas.get(i).ShareWhatsapp(listPessoa.getWhatsappId()); // o mesmo componente

                } else if (listPessoas.get(i).getY() == (listPessoa.getY() - 1) &&
                        listPessoas.get(i).getX() == listPessoa.getX()) {
                    listPessoas.get(i).ShareWhatsapp(listPessoa.getWhatsappId()); // Componente em cima

                } else if (listPessoas.get(i).getY() == (listPessoa.getY() + 1) &&
                        listPessoas.get(i).getX() == listPessoa.getX()) {
                    listPessoas.get(i).ShareWhatsapp(listPessoa.getWhatsappId()); // Componente em baixo

                } else if (listPessoas.get(i).getY() == listPessoa.getY() &&
                        listPessoas.get(i).getX() == (listPessoa.getX() + 1)) {
                    listPessoas.get(i).ShareWhatsapp(listPessoa.getWhatsappId()); // Componente na direita

                } else if (listPessoas.get(i).getY() == listPessoa.getY() &&
                        listPessoas.get(i).getX() == (listPessoa.getX() - 1)) {
                    listPessoas.get(i).ShareWhatsapp(listPessoa.getWhatsappId()); // Componente na esquerda

                }
            }
        }
        // Colisao entre IAS
        for (int i = 0; i<listPessoas.size();i++) {
            map[listPessoas.get(i).getY()][listPessoas.get(i).getX()] = listPessoas.get(i).getCor();

            // array com elementos em cima, baixo, esquerda, direita em funcao do mapa
            int[] numeros ={
                    getElementUp(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementDown(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementLeft(listPessoas.get(i).getY(),listPessoas.get(i).getX()),
                    getElementRight(listPessoas.get(i).getY(),listPessoas.get(i).getX())};
            for (int el : numeros) {

                if (el == 4) {
                    if (listPessoas.get(i) instanceof PessoaBemInformada && !((PessoaBemInformada) listPessoas.get(i)).getProtecaoFakenews())
                        iMeioComunic.ativaProtecaoFN((PessoaBemInformada) listPessoas.get(i));
                    // se for um elemento 4 IaMeiodecomunicao ativara a protecao desta pessoa
                }
                else if (el == 5) {
                    if (listPessoas.get(i) instanceof PessoaBemInformada) {

                        if (!((PessoaBemInformada) listPessoas.get(i)).getProtecaoFakenews()) {
                            listPessoas.set(i, iGeraFakenews.changeMalInform(listPessoas.get(i)));
                            // se for um elemento 5 IaGeradoradeFakenews ativara a transformara esta em malinformada

                            for (String id : listPessoas.get(i).getAgendaContatos()) {
                                if (serchPeopleid(id) instanceof PessoaBemInformada) {
                                    listPessoas.set(
                                            listPessoas.indexOf(serchPeopleid(id)),
                                            iGeraFakenews.changeMalInform(serchPeopleid(id))
                                    );
                                }
                            // todos contatos desta serao transformadas em Malinformadas
                            }

                        }

                    }
                }

                else if (el == 6) {
                    if (listPessoas.get(i) instanceof PessoaMalInformada) {
                        listPessoas.set(i, iaDfakenews.changePessoaBem(listPessoas.get(i)));
                        // Destruidora de fakenews, vai transformar esta pessoa em bem informada
                        // além de transformar todos seus contatos neste tipo.
                        for (String id : listPessoas.get(i).getAgendaContatos()) {

                            if (serchPeopleid(id) instanceof PessoaMalInformada) {
                                listPessoas.set(
                                        listPessoas.indexOf(serchPeopleid(id)),
                                        iaDfakenews.changePessoaBem(serchPeopleid(id))
                                );
                            }

                        }

                    }
                }
            }
            // referencio o tipo para Imovable movimentar tanto uma pessoa mal informada quanto bem informada
            Imovable a = (listPessoas.get(i) instanceof PessoaBemInformada)? (PessoaBemInformada) listPessoas.get(i): (PessoaMalInformada) listPessoas.get(i);
            a.moveRandom();
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

    public void refazMudo(){
        for(int eixoX = 0; eixoX < map.length; eixoX++ )
            for (int eixoY = 0; eixoY < map[0].length; eixoY++)
                map[eixoX][eixoY] = 0;

        // IAS Posicoes

        map[iMeioComunic.getY()][iMeioComunic.getX()] = iMeioComunic.getCor();
        map[iGeraFakenews.getY()][iGeraFakenews.getX()] = iGeraFakenews.getCor();
        map[iaDfakenews.getY()][iaDfakenews.getX()] = iaDfakenews.getCor();

    }

   /**
   *  Retorna um (int.), com base em soma ciclica definindo o número
   *  atual, os limites e a soma +1 ou -1.
    * <br><br>
   *    Exemplos:
   *    somaCiclica(2, 1, 0, 2) -> 0
   *    somaCiclica(0, -1, 0, 2) -> 2
   * */
    public int somaCiclica(int atual, int soma, int startlimit, int endLimit){
        return (atual+soma > endLimit)?
                (startlimit):(atual+soma < startlimit)?(endLimit):(atual+soma);
    }
    /** pega o elemento de cima do mapa em funca das posicoes */
    public int getElementUp(int posPessoaY,int intposPessoaX){
        return map[somaCiclica(posPessoaY,-1,0,29)][somaCiclica(intposPessoaX,0,0,59)];
    }
    /** pega o elemento de baixo do mapa em funca das posicoes */
    public int getElementDown(int posPessoaY,int intposPessoaX){
        return map[somaCiclica(posPessoaY,1,0,29)][somaCiclica(intposPessoaX,0,0,59)];
    }
    /** pega o elemento da direita do mapa em funca das posicoes */
    public int getElementRight(int posPessoaY,int intposPessoaX){
        return map[somaCiclica(posPessoaY,0,0,59)][somaCiclica(intposPessoaX,1,0,59)];
    }
    /** pega o elemento da esquerda do mapa em funca das posicoes */
    public int getElementLeft(int posPessoaY,int intposPessoaX){
        return map[somaCiclica(posPessoaY,0,0,59)][somaCiclica(intposPessoaX,-1,0,59)];
    }
    /**
    * Procura na lista de pessoas do Mundo a ID String
     * @return  retorna o objeto Pessoa que contem a ID
    */
    public Pessoa serchPeopleid(String id){
        for(Pessoa el : listPessoas){
            if(el.getWhatsappId().equals(id)) {
                return el;
            }
        }
        return null;
    }
}

