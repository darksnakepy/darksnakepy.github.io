package classes;
import java.util.Scanner;

public class Main{

    public static void main(String[] args)
    {
        float base;
        float altezza;
        float areaTot, perTot;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la base e l'altezza del primo rettangolo: ");
        base = scanner.nextFloat();
        altezza = scanner.nextFloat();
        Rettangolo r1 = new Rettangolo(base, altezza);
        System.out.println("Perimetro: " + r1.calcperimetro(base, altezza));
        System.out.println("Area: " + r1.calcArea(base, altezza));

        System.out.println("Inserisci la base e l'altezza del secondo rettangolo:");
        Rettangolo r2 = new Rettangolo(base, altezza);
        base = scanner.nextFloat();
        altezza = scanner.nextFloat();
        System.out.println("Perimetro: " + r2.calcperimetro(base, altezza));
        System.out.println("Area: " + r2.calcArea(base, altezza));

        System.out.println("Inserisci la base e l'altezza del secondo rettangolo:");
        base = scanner.nextFloat();
        altezza = scanner.nextFloat();
        Rettangolo r3 = new Rettangolo(base, altezza);
        System.out.println("Perimetro: " + r3.calcperimetro(base, altezza));
        System.out.println("Area: " + r3.calcArea(base, altezza));
        
        areaTot = r1.calcArea(base, altezza) + r2.calcArea(base, altezza) + r3.calcArea(base, altezza);
        System.out.println("Area totale dei 3 rettangoli: " + areaTot);

        perTot = r1.calcperimetro(base, altezza) + r2.calcperimetro(base, altezza) + r3.calcperimetro(base, altezza);
        System.out.println("Perimetro totale dei 3 rettangoli: " + perTot);
    }
}

class Rettangolo {
    float base;
    float altezza;

    public Rettangolo(float base, float altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    float calcArea(float base, float altezza)
    {
        return this.base*this.altezza;
    }
    
    float calcperimetro(float base, float altezza)
    {
        return (2*this.base)+(2*this.altezza);
    }
}

