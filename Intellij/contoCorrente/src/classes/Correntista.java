package classes;

import java.util.Scanner;

public class Correntista {
    String nome, cognome;
    float saldoUtente = 0;
    int pinUtente = 0;

    Scanner inp = new Scanner(System.in);

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






