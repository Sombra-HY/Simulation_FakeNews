package IAs;

import Pessoas.Pessoa;
import Pessoas.PessoaMalInformada;

public class IaGeradoraFakeNews {
    private int cor;
    private int x,y;
    public IaGeradoraFakeNews(){
        this.x = 35;
        this.y = 26;
        cor = 5;
    }

    public PessoaMalInformada changeMalInform(Pessoa pessoa){
        return new PessoaMalInformada(
                pessoa.getX(),
                pessoa.getY(),
                pessoa.getWhatsappId(),
                pessoa.getAgendaContatos());
    }

    //SETS

    public int getCor() {
        return cor;
    }

    //GETS
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
