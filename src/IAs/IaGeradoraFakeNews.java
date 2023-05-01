package IAs;

import Pessoas.Pessoa;
import Pessoas.PessoaBemInformada;
import Pessoas.PessoaMalInformada;

public class IaGeradoraFakeNews {
    private int cor;

    IaGeradoraFakeNews(){
        cor = 5;
    }

    public PessoaMalInformada changeMalInform(Pessoa pessoa){
        return new PessoaMalInformada(
                pessoa.getX(),
                pessoa.getY(),
                pessoa.getWhatsappId());
    }

    //SETS

    public int getCor() {
        return cor;
    }
}
