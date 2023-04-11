public class Main {
    public static void main(String[] args) {
        Rubrica r = new Rubrica();

        r.addContatto("Mario", "Rossi", "343762842");
        r.addContatto("Luca", "Bianchi", "334885672");
        r.addContatto("Pippo", "Baud", "334889154");

        String ricerca = r.cerca("Mario", "Rossi");
        if(ricerca!=null) {
            System.out.println(ricerca); // stampa il numero di telefono
        }else{
            System.out.println("Questo utente non è presente in rubrica");
        }

        r.stampaLista();

        r.deleteContatto("Mario", "Rossi");

        r.stampaLista();

    }
}
