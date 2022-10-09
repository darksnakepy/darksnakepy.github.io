package classes;

import java.util.Scanner;

public class Correntista {
    String nome = "";
    String cognome = "";
    int pinUtente = 0; // DA MODIFICARE CON INPUT

    Scanner inp = new Scanner(System.in);

    public void Registrati() {
        System.out.println("Inserisci il nome\n");
        nome = inp.next();
        System.out.println("Inserisci il cognome\n");
        cognome = inp.next();
        System.out.println("Inserisci un PIN (Attenzione, ricordarsi sempre le cifre del suo pin)\n");
        pinUtente = inp.nextInt();
    }

    public String controlloPin() {
        int controllo;
        controllo = inp.nextInt();
        if (controllo == pinUtente) {
            return "Pin corretto";
        } else {
            return "Pin sbagliato";
        }
    }
}





