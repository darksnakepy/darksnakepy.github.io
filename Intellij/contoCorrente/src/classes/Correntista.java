package classes;

import java.util.Scanner;

public class Correntista {
    String nome = "";
    String cognome = "";
    String CF = "";
    int pin = 0;
    float saldo = 0;
    final Float fido = -3000.0F;
    boolean opened = false;

    public void Registrati() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Inserisci il nome\n");
        nome = inp.next();
        System.out.println("Inserisci il cognome\n");
        cognome = inp.next();
        System.out.println("Inserisci il codice fiscale\n");
        CF = inp.next();
        System.out.println("Inserisci il pin\n");
        pin = inp.nextInt();

        System.out.println("Perfetto, ti sei registrato. Ecco a te le credenziali \n"+"\nNome: "+nome+"\nCognome: "+cognome+"\nCodice Fiscale: "+CF+"\nPin: "+pin);
    }
}



