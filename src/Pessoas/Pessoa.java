package Pessoas;

import java.util.ArrayList;

import java.util.Random;
import java.util.UUID;

public class Pessoa {
    private Integer x,y;
    private Integer cor;
    private String whatsappId;
    private ArrayList<String> agendaContatos = new ArrayList<>();
    private final Random numRandom = new Random();
    // Construtor padrao
    Pessoa(Integer cor){
        this.cor = cor;
        this.x = numRandomInterval(59);
        this.y = numRandomInterval(29);
        setWhatsappId();
    }
    //Construtor para troca de tipo e duplicacao de objeto ( Beminformada e Malinformada)
    Pessoa(Integer cor, Integer x, Integer y,String whatsappId, ArrayList<String> agendaContatos){
        this.agendaContatos = (ArrayList<String>) agendaContatos.clone();
        this.whatsappId = whatsappId;
        this.cor = cor;
        this.x = x;
        this.y = y;
    }


    //Methodos
    protected int numRandomInterval(int end){
        return numRandom.nextInt(end)+ 1;
    }
    /**
    * Verifica se contem o elemento ID na agenda e adiciona caso
    * nao tenha e difera do whatsappId
    */
    public void ShareWhatsapp(String ID){
        if(!agendaContatos.contains(ID) && !ID.equals(whatsappId))
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
    protected void setWhatsappId() {
        this.whatsappId = UUID.randomUUID().toString();
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
    public ArrayList<String> getAgendaContatos() {
        return agendaContatos;
    }
}
