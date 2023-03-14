import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;
/*
    Scrivere una classe Officina che prevede solo un metodo ripara() che utilizza veicoli
    (come definiti nell'esercizio precedente). Tale metodo prende un veicolo come parametro, ne cambia (se
    necessario) il valore della variabile booleana che descrive lo stato di guasto e restituisce come risultato
    il prezzo dell'intervento. Il prezzo deve variare a seconda che il veicolo fosse guasto o meno, e a seconda
    della tipologia di veicolo.
    Per testare le classi, scrivere un programma UsaOfficina che crea un po' di veicoli e un oggetto di
    tipo Officina, e usa il metodo ripara() varie volte su oggetti diversi (guasti o meno) stampando i
    prezzi ottenuti.
 */
class Main{
    public static void main(String[] args){
        Veicolo veicolo1= new Veicolo("123", "undefined", "Lamborghini", true);
        Veicolo veicolo2 = new Veicolo("615", "undefined", "Mustang", true);
        Officina officina = new Officina();

        officina.ripara(veicolo1);
        officina.ripara(veicolo2);
        System.out.println("Il prezzo di riparazione della "+veicolo1.getMarca() + "è di: "+veicolo1.price());
        System.out.println("Il prezzo di riparazione della "+veicolo2.getMarca() + "è di: "+veicolo2.price());
    }
}

class Officina {

    public static String ripara(Veicolo veicolo){
        if(veicolo.visualizzaStato()){
            switch(veicolo.getMarca()) {
                case "Lamborghini":
                    veicolo.changePrice(veicolo, 5000);
                    veicolo.cambiaStatus();
                    break;
                case "Mustang":
                    veicolo.changePrice(veicolo, 4000);
                    veicolo.cambiaStatus();
                    break;
            }
            return "riparato";
        }
        else{
            return "Il veicolo non è rotto.";
        }
    }
}

class Veicolo{
    private String targa;
    private String modello;
    private String marca;
    private float price;
    private boolean macchinaRotta = false;

    public Veicolo(String targa, String modello, String marca, boolean macchinaRotta){
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.price = 2000;
        this.macchinaRotta = macchinaRotta;
    }

    public String getTarga(){
        return targa;
    }

    public String getModello(){
        return modello;
    }

    public String getMarca(){
        return marca;
    }

    public float price(){
        return price;
    }

    public boolean visualizzaStato(){
        return macchinaRotta;
    }

    public boolean cambiaStatus(){
        this.macchinaRotta = false;
        return this.macchinaRotta;
    }

    public float changePrice(Veicolo veicolo, float value) { // to fix change price
        if (veicolo.macchinaRotta) {
            return price = value;
        }
        else {
            return 0;
        }
    }
}
