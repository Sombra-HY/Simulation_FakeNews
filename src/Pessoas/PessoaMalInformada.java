package Pessoas;

import java.util.Random;

public class PessoaMalInformada extends Pessoa implements Imovable{
    public PessoaMalInformada(){
        setWhatsappId();
        setCor(3);
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
}
