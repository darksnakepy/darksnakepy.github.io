import java.util.Random;
/*
    Scrivere una classe Veicolo che prevede una targa, una marca e un modello. La classe
    prevede anche una variabile booleana che descrive se il veicolo è guasto. Aggiungere un costruttore opportuno e vari metodi get e set opportuni.
    Scrivere la classi Vettura e Motociclo che estendono la classe Veicolo.
    La classe Vettura prevede una stringa che ne descrive la tipologia ("utilitaria","station wagon",
    "SUV",....) mentre la classe Motociclo prevede un numero che ne descrive la cilindrata (50, 125, ....).
    Per testare le classi, scrivere un programma UsaVeicoli che crea un array inizializzato con veicoli
    delle varie tipologie. Alcuni dei veicoli inseriti nell'array dovranno diventare guasti. Il programma deve
    stampare la lista delle targhe dei veicoli guasti.
 */


import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Veicolo> veicoloList = new ArrayList<>();
        Random random = new Random();

        veicoloList.add(new Vettura("123214", "Ferrari", "Roma", false));
        veicoloList.add(new Motociclo("696969", "Kawasaki", "Ninja", false));
        veicoloList.add(new Vettura("617862", "Lamborghini", "Aventador", false));
        veicoloList.add(new Motociclo("481926", "Yamaha", "r125", false));

        for(int i=0; i<veicoloList.size(); i++){
            veicoloList.get(random.nextInt(3 - 1 + 1) + 1).setRotto();
            if(veicoloList.get(i).getStatus()){
                System.out.println("[" + i + "] " + veicoloList.get(i).getTarga());
            }
        }
    }
}
class Veicolo{
    private String targa;
    private String marca;
    private String modello;
    private boolean rotto = false;

    public Veicolo(String targa, String marca, String modello, boolean rotto){
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.rotto = rotto;
    }

    public String getTarga(){
        return targa;
    }

    public String getMarca(){
        return marca;
    }

    public String getModello(){
        return modello;
    }

    public boolean getStatus(){
        return rotto;
    }

    public void setRotto(){
        this.rotto = true;
    }
}

class Vettura extends Veicolo{

    public Vettura(String targa, String marca, String modello, boolean rotto) {
        super(targa, marca, modello, rotto);
    }

    /*public void getInfo(){
        System.out.println("Targa: "+getTarga()+"\n"+
                           "Marca: "+getMarca()+ "\n"+
                           "Modello: "+getModello() +"\n"+
                           "Stato vettura: "+getStatus());
    }
     */
}

class Motociclo extends Veicolo{
    public Motociclo(String targa, String marca, String modello, boolean rotto) {
        super(targa, marca, modello, rotto);
    }
}