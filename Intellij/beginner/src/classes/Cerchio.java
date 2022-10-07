package classes;

import java.util.Scanner;

public class Cerchio {
    public float Read()
    {
        float raggio;
        Scanner inp = new Scanner(System.in);
        System.out.println("Inserisci il raggio\n>");
        raggio = inp.nextFloat();
        return raggio;
    }
    public float Calcolo()
    {
        float r;
        Cerchio c = new Cerchio();
        r = c.Read();
        

    }

}
