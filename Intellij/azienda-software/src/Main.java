import javax.management.StandardEmitterMBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Monitor admin = new Monitor();

        int choice = 0;
        do {
            System.out.println("[1] Aggiungi dipendenti alla lista\n[2] Crea progetto\n[3] Monitora progetto\n[4] Esci");
            choice = inp.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nome dell'impiegato: ");
                    String nomeInp = inp.next();
                    System.out.println("Cognome dell'impiegato: ");
                    String cognomeInp = inp.next();
                    admin.aggDipendenti(nomeInp, cognomeInp);
                    break;
                case 2:
                    admin.creaProgetto();
                    System.out.println("Progetto creato!\n");
                    break;
                case 3:
                    progettoMenu(admin.progetto);
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);

    }

    static void progettoMenu(Progetto progetto) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("[1] Aggiungi Milestone [obbiettivo] \n[2] Aggiungi una task \n[3] Cambia stato del progetto \n[4] Esci");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Inserisci il nome della milestone: ");
                    String inputMilestone = input.next();
                    progetto.aggiungiMilestone(inputMilestone);
                    System.out.println("Milestone aggiunta correttamente\n");
                case 2:
                    System.out.println("Inserisci a quale obbiettivo assegnare la task\n");
                    Milestone mil = progetto.selezioneObbiettivo();
                    System.out.println("Seleziona ora il dipendente\n");
                    for(int i=0; i < progetto.dipendentiList.size(); i++){
                        System.out.println("Dipendente numero [" + i +"] " +progetto.dipendentiList.get(i).nome + progetto.dipendentiList.get(i).cognome +"\n");
                    }
                    int scegliDip = input.nextInt();
                    System.out.println("Seleziona i giorni \n");
                    int sceltaGiorni = input.nextInt();


                    /*void assegnaTask(String nomeTask, int dataScadenza, Dipendenti dipendenteTask){
                                 taskList.add(new Tasks(nomeTask, dataScadenza, dipendenteTask));
                    }*/


                case 3:



                    break;
                case 4:
                    break;
            }
        } while (choice != 5);
    }
}

class Monitor{
    Progetto progetto;
    Scanner input = new Scanner(System.in);
    ArrayList<Dipendenti> dipendentiList = new ArrayList<>();

    void aggDipendenti(String nome, String cognome) {
        dipendentiList.add(new Dipendenti(nome, cognome));
    }

    void creaProgetto(){
        System.out.println("Scegli il nome del progetto: ");
        String nomeprogetto = input.next();
        System.out.println("Scegli un dipendente: ");
        ArrayList<Dipendenti> templist = new ArrayList<>();
        for(int i=0; i < templist.size(); i++){
            System.out.println("Dipendente numero [" + i +"] " +templist.get(i).nome + templist.get(i).cognome +"\n");
        }
        int sceltaDip;
        sceltaDip = input.nextInt();
        Progetto progetto = new Progetto(nomeprogetto, sceltaDip);
        templist.add(this.dipendentiList.get(sceltaDip));
    }
}

class Dipendenti {
    String nome;
    String cognome;
    public Dipendenti(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
}

class Progetto{
    Scanner input = new Scanner(System.in);
    String nomeProg;
    ArrayList<Tasks> task = new ArrayList<>();
    ArrayList<Dipendenti> dipendentiList = new ArrayList<>();
    ArrayList<Milestone> milestoneList = new ArrayList<>();;

    int nDipendenti;
    boolean progettoCompleto = false;

    public Progetto(String nomeProg, int nDipendenti){
        this.nomeProg = nomeProg;
        this.nDipendenti = nDipendenti;
    }

    void aggiungiMilestone(String nomeObb){
        milestoneList.add(new Milestone(nomeObb));
    }

    void printaMilestone(){
        for(Milestone m : milestoneList){
            System.out.println(m);
        }
    }
    Milestone selezioneObbiettivo(){
        for(int i = 0; i < milestoneList.size(); i++){
            System.out.println("Milestone numero ["+ i + "]"+ milestoneList.get(i).nomeMilestone);
        }
        int choice = input.nextInt();
        return milestoneList.get(choice);
    }
}

class Milestone{
    String nomeMilestone;
    ArrayList<Tasks> taskList = new ArrayList<>();
    boolean milestoneRaggiunta = false;

    public Milestone(String nomeMilestone) {
        this.nomeMilestone = nomeMilestone;
    }

    String statoMilestone(){
        if (milestoneRaggiunta){
            return "Milestone completata";
        }
        return null;
    }

    void assegnaTask(String nomeTask, int dataScadenza, Dipendenti dipendenteTask){
        taskList.add(new Tasks(nomeTask, dataScadenza, dipendenteTask));
    }
}

class Tasks{
    String nome;
    int scadenza;
    Dipendenti dipendenteTask;
    boolean taskCompletata = false;
    boolean taskCritica = false;

    public Tasks(String nome, int scadenza, Dipendenti dipendenteTask){
        this.nome = nome;
        this.scadenza = scadenza;
        this.dipendenteTask = dipendenteTask;
    }
}





