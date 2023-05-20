package IAs;

import Pessoas.PessoaBemInformada;

public class MeioComunicacaoConfiavel {
    private final int cor;
    private final int x;
    private final int y;

    public MeioComunicacaoConfiavel(){
        this.x = 10;
        this.y = 26;
        cor = 4;
    }
    /**
     * Ativa protecao da pessoa durante 30 segundos impossibilitando de ser transformada em PessoaMalInformada
     * */
    public void ativaProtecaoFN(PessoaBemInformada pessoa){
        pessoa.setProtecaoFakenews();
    }


    //GETS
    public int getCor() {
        return cor;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
}
