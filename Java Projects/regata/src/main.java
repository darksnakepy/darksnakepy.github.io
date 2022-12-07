package classes;
import classes.Barche;
import classes.Equip;
import classes.Sponsors;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Sponsors sponzor = new Sponsors();
        Barche regate = new Barche();
        System.out.println("Inserisci il nome dello sponsor\n");
        sponzor.name = input.next();
        System.out.println("Inserisci il cognome dello sponsor\n");
        sponzor.lastName = input.next();
        System.out.println(sponzor.name +  sponzor.lastName);

    }
}
