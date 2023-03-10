import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner inp = new Scanner(System.in);
        System.out.println("Click massimi prima che la lampadina si fulmini: ");
        Lampadina lampadina = new Lampadina(inp.nextInt());
        do {
            System.out.println("[1] Status Lampadina\n" + "[2] Accendi o Spegni\n" + "[3] Esci\n");
            choice = inp.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Status della lampadina: " + lampadina.stato());
                case 2:
                    lampadina.click();
            }
        }while(choice != 3);
    }
}

class Lampadina {
    int click = 0;
    int numeroClickMax = 0;

    StatoLampadina st = new StatoLampadina();

    public Lampadina(int numeroClickMax) {
        this.numeroClickMax = numeroClickMax;
    }

    String stato() {
        if (st.accesa == true) {
            return "La lampadina è accesa.\n";
        }
        else if (st.spenta == true) {
            return "La lampadina è spenta.\n";
        }
        else if (st.rotta == true) {
            return "La lampadina si è fulminata.\n";
        }
        return null;
    }

    void click(){
        if(!st.rotta && click < numeroClickMax)
        {
            st.accesa = true;
            st.spenta = false;
            click++;
        }
        if(!st.rotta && st.accesa) {
            st.spenta = true;
            st.accesa = false;
            click++;
        }
        if(click > numeroClickMax)
        {
            st.rotta = true;
        }
    }
}

class StatoLampadina{
    boolean accesa = false;
    boolean spenta = true;
    boolean rotta = false;
}
