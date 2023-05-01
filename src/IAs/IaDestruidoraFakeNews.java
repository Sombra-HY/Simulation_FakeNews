package IAs;


import Pessoas.Pessoa;
import Pessoas.PessoaBemInformada;

public class IaDestruidoraFakeNews {
    private int cor;
    IaDestruidoraFakeNews(){
        cor = 6;
    }

    public PessoaBemInformada changePessoaBem(Pessoa pessoa){
        return new PessoaBemInformada(
                pessoa.getX(),
                pessoa.getY(),
                pessoa.getWhatsappId()
        ) ;
    }

    //SETS

    public int getCor() {
        return cor;
    }
}
