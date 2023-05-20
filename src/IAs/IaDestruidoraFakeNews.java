package IAs;


import Pessoas.Pessoa;
import Pessoas.PessoaBemInformada;

public class IaDestruidoraFakeNews {
    private final int x;
    private final int y;
    private final int cor;
    public IaDestruidoraFakeNews(){
        cor = 6;
        this.x = 50;
        this.y = 26;
    }
    /**
     * Copia os Atributos da pessoa e transforma esta instancia em PessoaBemINFORMADA
    */
    public PessoaBemInformada changePessoaBem(Pessoa pessoa){
        return new PessoaBemInformada(
                pessoa.getX(),
                pessoa.getY(),
                pessoa.getWhatsappId(),
                pessoa.getAgendaContatos()
        ) ;
    }
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getCor() {
        return cor;
    }
}
