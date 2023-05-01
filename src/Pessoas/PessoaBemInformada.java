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
        setX();
        setY();

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
