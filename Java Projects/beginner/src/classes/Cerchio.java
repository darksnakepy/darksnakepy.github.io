package classes;

import java.util.Scanner;


public class Cerchio {
    public float Read()
    {
        float raggio;
        Scanner inp = new Scanner(System.in);
        System.out.println("Inserisci il raggio\n>");
        raggio = inp.nextFloat();
        if (raggio>0) {
            return raggio;
        }
        else{
            System.out.println("Il raggio non puo essere minore di 0");
            return 0;
        }
    }

    public float CalcoloCerchio()
    {
        float r, area;
        float pi = (float) 3.14;
        Cerchio c = new Cerchio();
        r = c.Read();
        area = pi*(r*r);
        System.out.println(area);
        return area;
    }
}
