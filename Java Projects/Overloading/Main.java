import java.util.ArrayList;
import java.util.Scanner;

class Main{
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Persona> listapersone = new ArrayList<>();
    static ArrayList<Studente> listastudenti = new ArrayList<>();

    public static void main(String[] args){
        int choice;
        do{
            System.out.prinltn("""
                    [1] Inserisci una persona
                    [2] Saluto persone
                    [3] Inserisci uno studente
                    [4] Saluto studenti
                    """);
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    inserisciPersona(); 
                    break;
                case 2:
                    for(Persona persona : listapersone){
                        saluta(persona);
                    }
                    break;
                case 3:{
                    inserisciStudente();
                    break;
                }
                case 4:
                    for(Studente studente : listastudenti){
                        saluta(studente);
                    }
                    break;
            }

        }while(choice!=4);

    }

    static void saluta(Persona persona){
        System.out.println("Nome "+ persona.nome());
        System.out.println("Cognome "+ persona.cognome());
        System.out.println("Eta "+ persona.eta());
        
    }

    static void saluta(Studente studente){
        System.out.println("Nome "+ studente.nome());
        System.out.println("Cognome "+ studente.cognome());
        System.out.println("Eta "+ studente.eta());
        System.out.println("Scuola "+ studente.scuola());
        System.out.println("Classe "+ studente.classe());
    }

    static void inserisciPersona(){
        System.out.println("Inserisci il nome: ");
        String nome = scanner.next();
        System.out.println("Inserisci il cognome: ");
        String cognome = scanner.next();
        System.out.println("Inserisci l'eta: ");
        int eta = scanner.nextInt();
        listapersone.add(new Persona(nome, cognome, eta));
    }

    static void inserisciStudente(){
        System.out.println("Inserisci il nome: ");
        String nome = scanner.next();
        System.out.println("Inserisci il cognome: ");
        String cognome = scanner.next();
        System.out.println("Inserisci l'eta: ");
        int eta = scanner.nextInt();
        System.out.println("Inserisci la scuola: ");
        String scuola = scanner.nextInt();
        System.out.println("Inserisci la classe: ");
        String classe = scanner.nextInt();

        listastudenti.add(new Studente(nome, cognome, eta, scuola, classe));
    }
}

class Persona{
    private final String nome;
    private final String cognome;
    private final int eta;

    String nome(){
        return nome;
    }
    
    String cognome(){
        return cognome;
    }

    int eta(){
        return eta;
    }

    public Persona(String nome, String cognome, int eta){
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

}

class Studente extends Persona{
    private final String scuola;
    private final String classe;  

    public Studente(String nome, String cognome, int eta, String scuola, String classe){
        super(nome, cognome, eta);
        this.scuola = scuola;
        this.classe = classe;
    }

    String scuola(){
        return scuola;
    }

    String classe(){
        return classe;
    }
}
