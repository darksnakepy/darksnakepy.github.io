package classes;
import classes.Correntista;
import classes.startContoCorrente;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        int choice; 
        System.out.println("Benvenuto nell'interfaccia del Conto Corrente, scelga un'opzione: \n" +
                "1. Registrati\n2. Versare soldi sul conto corrente\n3. Prelevare soldi sul conto corrente\n4. Visualizza informazioni utente");
        Scanner inp = new Scanner(System.in);
        choice = inp.nextInt();

        startContoCorrente scc = new startContoCorrente();
        Correntista cc = new Correntista();

        do {
            switch (choice) {
                case 1: {
                    cc.Registrati();
                    break;
                }
                case 2: {
                    System.out.println("Inserisci il pin:\n");
                    String controllo = cc.controlloPin();

                    float inpSaldo;
                    Scanner versamento = new Scanner(System.in);
                    System.out.println("Quanto vuoi versare?\n");
                    inpSaldo = versamento.nextFloat();
                    scc.Versamento(inpSaldo);
                    System.out.println("Saldo totale: " + scc.visualizzaSaldo());
                }
                case 3: {
                    System.out.println("Inserisci il pin\n");
                    String controllo = cc.controlloPin();
                    System.out.println(controllo);

                    float inpPrelievo;
                    Scanner prelievo = new Scanner(System.in);
                    System.out.println("Quanto vuoi prelevare?");
                    inpPrelievo = prelievo.nextFloat();
                    scc.Preleva(inpPrelievo);
                    System.out.println("Hai prelevato: " + inpPrelievo + "\nSaldo totale: " + scc.visualizzaSaldo());

                }
                case 4: {
                    int pinInp = 0;
                    pinInp = inp.nextInt();
                    if (pinInp == cc.pinUtente) {
                        System.out.println("Credenziali \n" + "\nNome: " + cc.nome + "\nCognome: " + cc.cognome + "\nPin: " + cc.pinUtente + "Conto Corrente: " + scc.visualizzaSaldo());
                        break;
                    } else {
                        System.out.println("Pin Sbagliato, utente non riconosciuto.");
                        break;
                    }
                }
                default: {
                    System.out.println("Scelta sbagliata\n");
                }
            }
        }while(true);
    }
}
