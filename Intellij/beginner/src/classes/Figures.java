package classes;
import java.util.Scanner;
import classes.Cerchio;
import classes.Rettangolo;
import classes.Triangolo;

public class Figures {

    public int menu()
    {
        int choice;
        System.out.println("1. Cerchio \n2. Triangolo\n3. Rettangolo\n>");
        Scanner inp = new Scanner(System.in);
        choice = inp.nextInt();
        return choice;
    }

    public static void main(String[] args)
    {
        int choice;
        Figures fg = new Figures();
        choice = fg.menu();
        switch (choice) {
            case 1:
                Cerchio c = new Cerchio();
                c.CalcoloCerchio();
                break;
            case 2:
                Triangolo t = new Triangolo();
                t.CalcoloTriangolo();
                break;
            case 3:
                Rettangolo r = new Rettangolo();
                r.CalcoloRettangolo();
                break;
            default:
                System.out.println("Wrong choice.");
                break;
        }
    }
}


