package classes;

import java.util.Scanner;

public class Rettangolo {

    int Triangolo1;
    int Triangolo2;
    int Triangolo3;

    public float readBase()
    {
        float base;
        Scanner inp = new Scanner(System.in);
        System.out.println("Inserisci la base >");
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
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci l'altezza >");
        altezza = input.nextFloat();
        if (altezza>0) {
            return altezza;
        }
        else{
            System.out.println("L'altezza non puo essere minore di 0");
            return 0;
        }
    }

    public float calcArea(float b, float h)
    {
        float area;
        area = b*h;
        return area;
    }
    
    public float calcperimetro(float b, float h)
    {
        float perimetro;
        perimetro = (2*b)+(2*h);
        return perimetro;
    }
}

