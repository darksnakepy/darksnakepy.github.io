package classes;

import java.util.Scanner;

public class Correntista {
    String nome = "";
    String cognome = "";
    int pinUtente = 0;

    Scanner inp = new Scanner(System.in);

    public void Registrati() {
        System.out.println("Inserisci il nome\n");
        nome = inp.next();
        System.out.println("Inserisci il cognome\n");
        cognome = inp.next();
        System.out.println("Inserisci il pin\n");
        pinUtente = inp.nextInt();
    }

    public void profilo(){
        int pinInp = 0;
        pinInp = inp.nextInt();
        if(pinInp == pinUtente){
            System.out.println("Credenziali \n"+"\nNome: "+nome+"\nCognome: "+cognome+"\nPin: "+pinUtente);
        }
        else{
            System.out.println("Pin Sbagliato, utente non riconosciuto.");
        }
    }
}




