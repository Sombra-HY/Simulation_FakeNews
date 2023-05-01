package Pessoas;

import java.util.Random;

public class PessoaBemInformada extends Pessoa implements Imovable {
    private Boolean protecaoFakenews = false;
    public PessoaBemInformada(){
        setWhatsappId();
        setCor(2);
        setX();
        setY();

    }
    public void moveRandom() {
        switch (new Random().nextInt(4)) {
            case 0 -> moveUp();
            case 1 -> moveDown();
            case 2 -> moveleft();
            case 3 -> moveRight();
        }
    }

    public void setProtecaoFakenews() {
        this.protecaoFakenews = true;

    }
}
