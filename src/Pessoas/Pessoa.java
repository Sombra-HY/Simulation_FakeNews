package Pessoas;

import java.util.ArrayList;

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
    protected int numRandomInterval(int end){
        return numRandom.nextInt(end- 1 +1)+ 1;
    }
    // Share whatsapp
    protected void ShareWhatsapp(String ID){
        if(!agendaContatos.contains(ID))
            agendaContatos.add(ID);
    }


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
    protected void setWhatsappId(String ID) {
        this.whatsappId = ID;
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
