package Pessoas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Pessoa {
    private int x,y;
    private int cor;
    private String whatsappId;
    private ArrayList<String> agendaContatos = new ArrayList<>();
    private final Random numRandom = new Random();

    Pessoa(){
    }
    //Methodos
    protected int numRandomInterval(int start, int end){
        return numRandom.nextInt(end-start+1)+start;
    }
    // Share whatsapp
    protected void ShareWhatsapp(String ID){
        if(!agendaContatos.contains(ID))
            agendaContatos.add(ID);
    }

    //Move all directions

//    protected void moveDown(){
//        if(this.y == 28){
//            this.y = 1;
//            return;
//        }
//        this.y ++;
//    }
//    protected void moveRight(){
//        if(this.x == 59){
//            this.x = 0;
//            return;
//        }
//        this.x ++;
//    }
//    protected void moveleft(){
//        if(this.x == 1){
//            this.x = 58;
//            return;
//        }
//        this.x--;
//    }


    //SETs
    protected void setX(int num) {
        this.x = num;
    }
    protected void setY(int num) {
        this.y = num;
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
