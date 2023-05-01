package Pessoas;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PessoaBemInformada extends Pessoa implements Imovable {
    private Boolean protecaoFakenews;
    private final Timer time = new Timer();
    public PessoaBemInformada(){
        protecaoFakenews = false;
        setWhatsappId();
        setCor(2);
        setY(numRandomInterval(1,29));
        setX(numRandomInterval(1,59));

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
