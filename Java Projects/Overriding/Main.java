import java.util.Scanner;

class Main{
    public static void main(String[] args){
        int choice;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("""
                    [1] Gatto
                    [2] Cane
                    [3] Esci
                    """);
            choice = scanner.nextInt();
        }while(choice!=3);
        switch(choice){
            case 1:
                Gatto gatto = new Gatto();
                gatto.verso();
                break;
            case 2:
                Cane cane = new Cane();
                cane.verso();
                break;
            case 3:
                break;
        }
    }
}


class Mammifero{
    void verso(){

    }
}

class Cane extends Mammifero{
    void verso(){
        System.out.println("Woof");
    }
}

class Gatto extends Mammifero{
    void verso(){
        System.out.println("Meow");
    }
}

