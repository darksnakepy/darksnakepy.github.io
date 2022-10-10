package classes;
import classes.Correntista;
import classes.startContoCorrente;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        do {
            int choice;
            System.out.println("Benvenuto nell'interfaccia del Conto Corrente, scelga un'opzione: \n" +
                    "1. Registrati\n2. Versare soldi sul conto corrente\n3. Prelevare soldi sul conto corrente\n4. Visualizza informazioni utente");
            Scanner inp = new Scanner(System.in);
            choice = inp.nextInt();

            startContoCorrente scc = new startContoCorrente();
            Correntista cc = new Correntista();


            switch (choice) {
                case 1: {
                    cc.Registrati();
                    break;
                }
                case 2: {
                    float inpSaldo;
                    Scanner versamento = new Scanner(System.in);
                    System.out.println("Quanto vuoi versare?\n");
                    inpSaldo = versamento.nextFloat();
                    scc.Versamento(inpSaldo);
                    System.out.println("Saldo totale: " + scc.visualizzaSaldo() + "$");
                    break;
                }
                case 3: {

                    float inpPrelievo;
                    Scanner prelievo = new Scanner(System.in);
                    System.out.println("Quanto vuoi prelevare?");
                    inpPrelievo = prelievo.nextFloat();
                    scc.Preleva(inpPrelievo);
                    System.out.println("Hai prelevato: " + inpPrelievo + "\nSaldo totale: " + scc.visualizzaSaldo() + "$");
                    break;
                }
                case 4: {
                    System.out.println("Credenziali \n" + "\nNome: " + cc.nome + "\nCognome: " + cc.cognome + "\nPin: " + cc.pinUtente + "\nConto Corrente: " + scc.visualizzaSaldo() + "$");
                    break;
                }
                default: {
                    System.out.println("Scelta sbagliata\n");
                    break;
                }
            }
        }while(true);
    }
}
