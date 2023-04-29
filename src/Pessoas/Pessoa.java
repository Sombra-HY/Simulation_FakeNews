package Pessoas;

import java.util.ArrayList;
import java.util.Date;

public class Pessoa {
    private int x, y, cor;
    private String whatsappId;
    private ArrayList<Object> agendaContatos = new ArrayList<>();

    /**
     * Gera Id Aleatorio
     * **/
    protected void setWhatsappId(){
        Date data_de_hoje = new Date();
        this.whatsappId = (System.currentTimeMillis()) + "ID";
    }

    public String getWhatsappId() {
        return whatsappId;
    }

    public static void main(String[] args) {
        ArrayList<Pessoa> list= new ArrayList<>();
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());
        list.add(new PessoaMalInformada());

        for (Pessoa a : list){
            System.out.println(a.getWhatsappId());
        }
    }
}
