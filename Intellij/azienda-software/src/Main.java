import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Monitor admin = new Monitor();
        Scanner inp = new Scanner(System.in);

        int choice = 0;
        do{
            System.out.println("[1] Aggiungi dipendenti alla lista\n[2] Crea progetto\n[3] Monitora progetto\n[4] Chiudi");
            choice = inp.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Nome dell'impiegato: ");
                    String nomeInp = inp.next();
                    System.out.println("Cognome dell'impiegato: ");
                    String cognomeInp = inp.next();
                    admin.aggDipendenti(nomeInp, cognomeInp);
                    break;
                case 2:
                    admin.stampadipendenti();
                case 3:
                    break;
                case 4:
                    break;
            }
        } while(choice != 4);

    }
}

class Monitor{

    Scanner input = new Scanner(System.in);
    ArrayList<Dipendenti> ListaDipendenti = new ArrayList<>();

    void aggDipendenti(String nome, String cognome) {
        ListaDipendenti.add(new Dipendenti(nome, cognome));
    }

    void stampadipendenti() {
        for (Dipendenti dip: ListaDipendenti) {
            System.out.println(dip);
        }
    }

    void creaProgetto(){
        System.out.println("Scegli il nome del progetto: ");
        String nomeprogetto = input.next();
        System.out.println("Scegli un dipendente: ");
        for(int i=0; i < ListaDipendenti.size(); i++){
            System.out.println("Dipendente numero:" + i +ListaDipendenti.get(i) +"\n");
        }
        int sceltaImpiegato;
        sceltaImpiegato = input.nextInt();
        new Progetto(nomeprogetto, sceltaImpiegato);
        ArrayList<Dipendenti> idk = new ArrayList<>();
        idk.add(ListaDipendenti.get(sceltaImpiegato));
        System.out.println("Perfetto. Hai creato il progetto: " + nomeprogetto + "\nCon impiegato: " + sceltaImpiegato);
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
    ArrayList<Dipendenti> dipendentiList;
    ArrayList<Milestone> milestoneList = new ArrayList<>();;
    int nDipendenti;

    public Progetto(String nomeProg, int nDipendenti){
        this.nomeProg = nomeProg;
        this.nDipendenti = nDipendenti;
    }

    /*void Info(){
        System.out.println("Informazioni del progetto:\n" + "Nome Progetto" + ": " + nomeProg + "\n" + "Dipendente: " + dipendentiList.size() + "\n"
        );
    }
    */

    void creaMilestone(){
        System.out.println("Inserisci il nome dell'obbiettivo: ");
        String tempMIle = input.next();
        milestoneList.add(new Milestone(tempMIle));
    }

    void printaMilestone(){
        for(Milestone m : milestoneList){
            System.out.println(m);
        }
    }
}


class Milestone{
    float percentMilestone = 0;
    String nomeMIlestone;
    ArrayList<Tasks> taskList = new ArrayList<>();

    int contMilestone;
    boolean milestoneRaggiunta = false;

    public Milestone(String nomeMIlestone) {
        this.nomeMIlestone = nomeMIlestone;
    }

    String statoMilestone(){
        if (milestoneRaggiunta){
            return "MIlestone completata";
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





