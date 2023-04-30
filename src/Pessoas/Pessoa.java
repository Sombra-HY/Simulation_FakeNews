package Pessoas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Pessoa {
    private int x,y;
    private int cor;
    private String whatsappId;
    private ArrayList<Object> agendaContatos = new ArrayList<>();
    private final Random numRandom = new Random();

    Pessoa(){
    }
    //Methodos

    //Move all directions
    protected void moveUp(){
        if(this.y == 1){
            this.y = 28;
            return;
        }
        this.y --;
    }
    protected void moveDown(){
        if(this.y == 28){
            this.y = 1;
            return;
        }
        this.y ++;
    }
    protected void moveRight(){
        if(this.x == 59){
            this.x = 0;
            return;
        }
        this.x ++;
    }
    protected void moveleft(){
        if(this.x == 1){
            this.x = 58;
            return;
        }
        this.x--;
    }


    //SETs
    protected void setX() {
        this.x = numRandom.nextInt(30);
    }
    protected void setY() {
        this.y = numRandom.nextInt(60);
    }
    protected void setCor(int cor){
        this.cor = cor;
    }

    /**
     * Gera Id Aleatorio
     **/
    protected void setWhatsappId() {
        this.whatsappId = (System.currentTimeMillis()) + "ID";
    }


    //GETs
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getCor() {
        return cor;
    }
    public String getWhatsappId() {
        return whatsappId;
    }

}
