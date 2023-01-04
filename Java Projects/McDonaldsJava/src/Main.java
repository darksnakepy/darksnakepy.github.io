import java.util.Scanner;
import java.util.ArrayList;

class Main {

    static Scanner inp = new Scanner(System.in); // global scanner


    public static void main(String[] args){
        McDonalds mcDonalds = new McDonalds();
        ArrayList<Hamburgers> burgers = new ArrayList<>();

        int choice = 0;
        burgers.add(new Hamburgers(1, "Big Mac", 10, 5.0f));
        burgers.add(new Hamburgers(2, "Mc Chicken", 10, 7.0f));
        burgers.add(new Hamburgers(3, "Normal Hambuger", 10, 1.0f));
        burgers.add(new Hamburgers(4, "Crispy McBacon", 10, 5.5f));
        burgers.add(new Hamburgers(5, "Cheeseburger", 2, 5.0f)); // low quantity so we test unavailable burgers function

        do{
            mcDonalds.printMenu();
            choice = inp.nextInt();
            if(choice==1){
                printList(burgers);
            }
        }while(choice != 3);
    }

    static void printList(ArrayList<Hamburgers> burgers){
        for(Hamburgers hamburgers : burgers) {
            System.out.println("["+hamburgers.id+"]" + hamburgers.descr + ", Quantity: [" + hamburgers.quantity + "] , Price: " + hamburgers.price + "$ \n");
        }
    }

    static void Shop(ArrayList<Hamburgers> burgers){
        ArrayList<Hamburgers> bill = new ArrayList<>();

        int choicemenu = 0;
        do{
            System.out.println("""
                    [1] Buy a hamburger
                    [2] Bill
                    [3] Exit
                    """);
            choicemenu = inp.nextInt();
            switch(choicemenu){
                case 1:
                    int inputBurgers;
                    System.out.println("Choose a burger (insert the id)");
                    printList(burgers);
                    inputBurgers = inp.nextInt();





                case 2:

            }


        }while(choicemenu != 3);
    }

}
class Hamburgers{
    int id;
    String descr;
    int quantity;
    float price;

    public Hamburgers(int id, String descr, int quantity, float price){
        this.id = id;
        this.descr = descr;
        this.quantity = quantity;
        this.price = price;
    }
}

class McDonalds{
    ArrayList<Hamburgers> products = new ArrayList<>();

    public String printMenu(){
        return " [1] Get hamburger list\n [2] Shop\n [3] Exit\n ";
    }
}



