package IAs;

import Pessoas.Imovable;
import Pessoas.PessoaBemInformada;
import Pessoas.PessoaMalInformada;

public class MeioComunicacaoConfiavel {
    private int cor;

    MeioComunicacaoConfiavel(){
        cor = 4;
    }

    public void ativaProtecaoFN(PessoaBemInformada pessoa){
        pessoa.setProtecaoFakenews();
    }
}
