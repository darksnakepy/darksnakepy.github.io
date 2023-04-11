import java.util.ArrayList;

public class Rubrica {
    ArrayList<Contatto> contatti = new ArrayList<>();

    public void addContatto(String nome, String cognome, String numeroTelefonico) {
        contatti.add(new Contatto(nome, cognome, numeroTelefonico));
    }

    public void deleteContatto(String nome,String cognome){
       for(Contatto c : contatti){
           if(c.getNome().equals(nome) && c.getCognome().equals(cognome)){
                contatti.remove(c);
                break;
           }
       }
    }
    public String cerca(String nome,String cognome){
        for (Contatto c : contatti){
            if(c.getNome().equals(nome) && c.getCognome().equals(cognome)){
                return c.getNumeroTelefonico();
            }
            else return null;
        }
        return null;
    }

    public void stampaLista() {
        System.out.println(contatti.toString());
    }
}
