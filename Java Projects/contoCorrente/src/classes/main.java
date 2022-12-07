package classes;
import classes.Correntista;
import classes.startContoCorrente;

import java.io.IOException;
import java.lang.Runtime;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        startContoCorrente scc = new startContoCorrente();
        Correntista cc = new Correntista();
        do {
            int choice;
            System.out.println("Benvenuto nell'interfaccia iniziale del Conto Corrente, scelga un'opzione: \n");

        if (cc.verificato==false){
            System.out.println("1. Crea un nuovo utente\n2. Versare soldi sul conto corrente\n3. Prelevare soldi sul conto corrente\n4. Visualizza informazioni utente");
        }
        else{
                System.out.println("2. Versare soldi sul conto corrente\n3. Prelevare soldi sul conto corrente\n4. Visualizza informazioni utente");
            }
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                        System.out.println("Nome: ");
                        cc.nome = scanner.next();
                        System.out.println("Cognome: ");
                        cc.cognome = scanner.next();
                        System.out.println("Pin: ");
                        cc.pinUtente = scanner.nextInt();
                        System.out.println("Saldo iniziale");
                        scc.saldoCorrente = scanner.nextFloat();
                        System.out.println("Perfetto! ti sei registrato.");
                        cc.verificato = true;
                        break;

                }
                case 2: {
                    try{
                        cc.controlloPin();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    float inpSaldo;
                    Scanner versamento = new Scanner(System.in);
                    System.out.println("Quanto vuoi versare?\n");
                    inpSaldo = versamento.nextFloat();
                    scc.Versamento(inpSaldo);
                    System.out.println("Saldo totale: " + scc.visualizzaSaldo() + "$");
                    break;
                }
                case 3: {
                    try{
                        cc.controlloPin();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    float inpPrelievo;
                    Scanner prelievo = new Scanner(System.in);
                    System.out.println("Quanto vuoi prelevare?");
                    inpPrelievo = prelievo.nextFloat();
                    try {
                        scc.Preleva(inpPrelievo);
                        System.out.println("Hai prelevato: " + inpPrelievo + "\nSaldo totale: " + scc.visualizzaSaldo() + "$");
                    }catch (Exception e){
                        System.out.println("Il conto e' in rosso.");
                        System.out.println("Ecco il tuo conto: " + scc.visualizzaSaldo());
                    }
                    break;
                }
                case 4: {
                    try{
                        cc.controlloPin();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
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
