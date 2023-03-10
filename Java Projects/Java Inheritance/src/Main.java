import java.util.ArrayList;
import java.util.Scanner;

/*
TRACCIA
La classe Persona ha attributi nome e cognome e un metodo visualizza per stampare i dati anagrafici.
La classe Dipendente specializza la classe Persona, aggiungendo gli attributi data assunzione e stipendio e ridefinendo il metodo visualizza per stampare anche i dati lavorativi.
Creare opportunamente costruttori e metodi get e set.
Si definisca inoltre
un metodo guadagnaPiuDi che prende come parametro un altro oggetto Dipendente e restituisce true
se l’oggetto corrente ha uno stipendio maggiore di quello ricevuto come parametro, o false altrimenti.

Per testare la classe, scrivere un Main che crea tre oggetti Dipendente
e li visualizza in ordine di stipendio
 */



class Main {

    public static void main(String[] args){

        ArrayList<Dipendente> dipendenti = new ArrayList<>();
        dipendenti.add(new Dipendente("Luca", "Rossi", "07/2/2023", 1700.0));
        dipendenti.add(new Dipendente("Vito", "Lorusso","07/2/2023", 2000.0));
        dipendenti.add(new Dipendente("Francesco", "Ursi","16/2/2023", 1500.0));

    }
}

class Persona{
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
    }

    // funzioni get set

    public void setNome(String nome){
        this.nome=nome;
    }
    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public void visualizza(){
        System.out.println("Nome:"+nome + " Cognome: "+cognome);
    }
}

class Dipendente extends Persona{

    private String dataAssunzione;
    private double stipendio;

    public Dipendente(String nome, String cognome, String dataAssunzione, double stipendio) {
        super(nome, cognome);
        this.dataAssunzione = dataAssunzione;
        this.stipendio = stipendio;
    }

    public void setData(){
        this.dataAssunzione = dataAssunzione;
    }

    public String getData(){
        return dataAssunzione;
    }

    public void setStipendio(){
        this.stipendio = stipendio;
    }

    public double getStipendio(){
        return stipendio;
    }

    public void visualizza(){
        System.out.println("Nome:"+getNome()
                + " Cognome: "+getCognome()
                + " Data assunzione"+getData()
                + " Stipendio" + getStipendio());
    }

    public boolean guadagnaPiuDi(Dipendente dipendenteInput){
        if(this.stipendio>dipendenteInput.stipendio){
            return true;
        }
        else{
            return false;
        }
    }

}
