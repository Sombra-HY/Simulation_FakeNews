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

    public void ativaProtecaoFN(PessoaBemInformada pessoa){
        pessoa.setProtecaoFakenews();
    }

    //SETs

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
