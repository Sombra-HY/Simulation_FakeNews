package Pessoas;

import Pessoas.FakeNews.FakeNews;

import java.util.ArrayList;
import java.util.Random;

public class PessoaMalInformada extends Pessoa implements Imovable{
    FakeNews fakeNews;

    public PessoaMalInformada(int X, int Y, String ID,ArrayList<String> agenda){
        super(3,X,Y,ID,agenda);
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
            setY(0);
        }
        setY(getY()+1);
    }

    @Override
    public void moveRight() {
        if(getX() == 59){
            setX(0);
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
