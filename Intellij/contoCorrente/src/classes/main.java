package classes;
import classes.Correntista;
import classes.startContoCorrente;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        int choice; 
        System.out.println("1. Registrati\n2. Versare soldi sul conto corrente\n3. Prelevare soldi sul conto corrente\n4. Esci");
        Scanner inp = new Scanner(System.in);
        choice = inp.nextInt();
        startContoCorrente scc = new startContoCorrente();
        switch(choice) {
            case 1:
                Correntista cc = new Correntista();
                cc.Registrati();

            case 2: // Versamento
                float inpSaldo;
                Scanner versamento = new Scanner(System.in);
                System.out.println("Quanto vuoi versare?\n");
                inpSaldo = versamento.nextFloat();
                scc.Versamento(inpSaldo);
                System.out.println("Saldo totale: "+ scc.visualizzaSaldo());

            case 3: // Prelievo
                float inpPrelievo;
                Scanner prelievo = new Scanner(System.in);
                System.out.println("Quanto vuoi prelevare?");
                inpPrelievo = prelievo.nextFloat();
                scc.Preleva(inpPrelievo);
                System.out.println("Hai prelevato: " + inpPrelievo + "Saldo totale: " + scc.visualizzaSaldo());

            case 4:


            default:
                System.out.println("Scelta sbagliata\n");
        }
    }
}
