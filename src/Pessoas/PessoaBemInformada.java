package Pessoas;

import Pessoas.FakeNews.FakeNews;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PessoaBemInformada extends Pessoa implements Imovable {
    private Boolean protecaoFakenews;
    private final Timer time = new Timer();
    public PessoaBemInformada(){
        super(2);
        protecaoFakenews = false;
    }
    public PessoaBemInformada(int X, int Y, String ID){
        super(2,X,Y,ID);
    }


    //Methods
    @Override
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
    public void moveRight()  {
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
    //SETS
    public void setProtecaoFakenews() {
        class SetFalse extends TimerTask{
            @Override
            public void run() {
                protecaoFakenews = false;
            }
        }

        TimerTask tarefa = new SetFalse();
        protecaoFakenews = true;
        time.schedule(tarefa,5000);
    }

    //GETS
    public Boolean getProtecaoFakenews() {
        return protecaoFakenews;
    }
}


//   map=   {[][][],
//           [][1][],
//           [][][]}

//  obj = [1][1]

// cima = [--][1]
// baixo = [++][1]

// direi = [][++]
// esquer = [][--]