package Pessoas;

import Pessoas.FakeNews.FakeNews;

import java.util.Random;

public class PessoaMalInformada extends Pessoa implements Imovable{
    private FakeNews fakeNews;
    public PessoaMalInformada(){
        setWhatsappId();
        setCor(3);
        setX();
        setY();
        this.fakeNews = new FakeNews();
    }


    public void moveRandom() {
        switch (new Random().nextInt(4)) {
            case 0 -> moveUp();
            case 1 -> moveDown();
            case 2 -> moveleft();
            case 3 -> moveRight();
        }
    }
}
