package classes;
import classes.Correntista;
import classes.startContoCorrente;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        int choice; 
        System.out.println("1. Registrati\n2. Prelevare soldi sul conto corrente\n3. Versare soldi sul conto corrente\n4. Esci");
        Scanner inp = new Scanner(System.in);
        choice = inp.nextInt();

        do{
            switch(choice) {
                case 1:
                    Correntista cc = new Correntista();
                    cc.Registrati();
                    break;
                case 2:

                default:
                    System.out.println("Scelta sbagliata\n");
            }

        }while(true);
    }
}
