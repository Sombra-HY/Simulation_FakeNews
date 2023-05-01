package Pessoas;

import Pessoas.FakeNews.FakeNews;

import java.util.Random;

public class PessoaMalInformada extends Pessoa implements Imovable{
    final private FakeNews fakeNews;
    public PessoaMalInformada(){
        setWhatsappId();
        setCor(3);
        setY(numRandomInterval(29));
        setX(numRandomInterval(59));
        this.fakeNews = new FakeNews();
    }

    public PessoaMalInformada(int X, int Y,String ID){
        setX(X);
        setY(Y);
        super.setWhatsappId(ID);
        setCor(3);
        this.fakeNews = new FakeNews();
    }


    //Methods
    public void moveRandom() {
        switch (new Random().nextInt(4)) {
            case 0 -> moveUp();
            case 1 -> moveDown();
            case 2 -> moveleft();
            case 3 -> moveRight();
        }
    }

    @Override
    public void moveUp(){
        if(getY() == 1){
            setY(29);
        }
        setY(getY()-1);
    }

    @Override
    public void moveDown() {
        if(getY() == 29){
            setY(1);
        }
        setY(getY()+1);
    }

    @Override
    public void moveRight() {
        if(getX() == 59){
            setX(1);
        }
        setX(getX()+1);
    }

    @Override
    public void moveleft() {
        if(getX() == 1){
            setX(59);
        }
        setX(getX()-1);
    }
}
