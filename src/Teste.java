import Pessoas.Pessoa;

public class Teste {
    public static void main(String[] args) {
        Mundo teste = new Mundo();
        teste.addPeople();

        for(Pessoa a: teste.listPessoas){
            System.out.println("Posicoes X e Y: " + a.getX() + " " + a.getY());
            System.out.println("TIpo: "+ a);
            System.out.println("cor" + a.getCor());

            System.out.println("Posicoes X e Y (Igfk): " + teste.iGeraFakenews.getX() + " " + teste.iGeraFakenews.getY());
            System.out.println("Posicoes X e Y (Imc): " + teste.iMeioComunic.getX() + " " + teste.iMeioComunic.getY());
            System.out.println("Posicoes X e Y (Idfn): " + teste.iaDfakenews.getY() + " " + teste.iaDfakenews.getY());

            teste.extracted();

            if(     teste.getElementDown(a.getY(), a.getX()) == 5 ||
                    teste.getElementUp(a.getY(), a.getX()) == 5 ||
                    teste.getElementLeft(a.getY(), a.getX()) == 5 ||
                    teste.getElementRight(a.getY(), a.getX()) == 5
            ){
                teste.listPessoas.set(0,teste.iGeraFakenews.changeMalInform(a));

                System.out.println("Transformado");
                System.out.println("TIpo: "+ a);
                System.out.println("cor" + a.getCor());

            }

        }
        System.out.println(teste.listPessoas.get(0));
    }
}
