package classes;
import java.util.Scanner;

public class Main{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la base e l'altezza");
        Rettangolo r = new Rettangolo(scanner.nextFloat(), scanner.nextFloat());
        System.out.println("Perimetro = " + r.calcperimetro());
        System.out.println("Area = " + r.calcArea());
        

    }
}

class Rettangolo {
    float base;
    float altezza;

    public Rettangolo(float base, float altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    float calcArea()
    {
        float area;
        area = base*altezza;
        return area;
    }
    
    float calcperimetro()
    {
        float perimetro;
        perimetro = (2*base)+(2*altezza);
        return perimetro;
    }
}

