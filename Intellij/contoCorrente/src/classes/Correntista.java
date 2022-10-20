package classes;

import java.util.Scanner;

public class Correntista {
    String nome, cognome;
    float saldoUtente = 0;
    int pinUtente = 0;
    boolean verificato = false;

    public void controlloPin() throws Exception {
        System.out.println("Inserisci il pin: \n");
        boolean exists = false;
        Scanner inp = new Scanner(System.in);
        int controllo;
        controllo = inp.nextInt();
        if (controllo == pinUtente) {
            exists = true;
            System.out.println("Trovato");
        }
        if(!exists){
            throw new Exception();
        }
    }
}






