public class Contatto {
    private String nome;
    private String cognome;
    private String numeroTelefonico;
    public Contatto(String nome,String cognome,String numeroTelefonico){
        this.nome=nome;
        this.cognome=cognome;
        this.numeroTelefonico=numeroTelefonico;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getNumeroTelefonico(){
        return numeroTelefonico;
    }
    public String toString(){
        return nome + " " + cognome + " " + numeroTelefonico + "\n";
    }
}
