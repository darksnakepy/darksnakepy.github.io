package classes;

import java.util.Scanner;

public class Triangolo {
    public float readBase()
    {
        float base;
        Scanner inp = new Scanner(System.in);
        System.out.println("Inserisci la base\n>");
        base = inp.nextFloat();
        if (base>0) {
            return base;
        }
        else{
            System.out.println("La base non puo essere minore di 0");
            return 0;
        }
    }

    public float readAltezza() {
        float altezza;
        Scanner inp = new Scanner(System.in);
        System.out.println("Inserisci l'altezza\n>");
        altezza = inp.nextFloat();
        if (altezza>0) {
            return altezza;
        }
        else{
            System.out.println("L'altezza non puo essere minore di 0");
            return 0;
        }
    }
    public float CalcoloTriangolo()
    {
        float b, h, area;
        Rettangolo r = new Rettangolo();
        b = r.readBase();
        h = r.readAltezza();
        area = (b*h)/2;
        System.out.println(area);
        return area;
    }
}
