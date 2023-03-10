import java.util.Scanner;
import java.util.ArrayList;

class Main {
    static Scanner inp = new Scanner(System.in); // global scanner
    static float finalPrice;

    public static void main(String[] args){
        ArrayList<Hamburgers> burgers = new ArrayList<>();

        int choice = 0;
        burgers.add(new Hamburgers(1, "Big Mac", 10, 5.0f));
        burgers.add(new Hamburgers(2, "Mc Chicken", 10, 7.0f));
        burgers.add(new Hamburgers(3, "Normal Hambuger", 10, 1.0f));
        burgers.add(new Hamburgers(4, "Crispy McBacon", 10, 5.5f));
        burgers.add(new Hamburgers(5, "Cheeseburger", 2, 5.0f)); // low quantity so we test unavailable burgers function

        do{
            System.out.println("Welcome to McDonald's. Choose an option:\n[1] Get hamburger list\n[2] Shop\n[3] Exit\n");
            choice = inp.nextInt();
            switch(choice){
                case 1 -> printList(burgers);
                case 2 -> Shop(burgers);
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
            System.out.println("[1] Buy a hamburger\n[2] Bill\n[3] Exit");
            choicemenu = inp.nextInt();
            switch(choicemenu) {

                case 1 -> {
                    int inputBurgers;
                    do {
                        System.out.println("Choose a burger (please insert the number id), press 6 to go back to the main menu\n");
                        printList(burgers);
                        inputBurgers = inp.nextInt();
                        for (Hamburgers hamburgers : burgers) {
                            if (hamburgers.id == inputBurgers) {
                                if (hamburgers.quantity != 0) {
                                    hamburgers.quantity -= 1;
                                    bill.add(hamburgers);
                                    finalPrice += hamburgers.price;
                                    //getBill(bill);
                                } else {
                                    System.out.println("We're sorry. The selected product is unavailable.\n");
                                }
                            }
                        }
                    } while (inputBurgers != 6);
                }
                case 2->{
                    float inputPayment;
                    getBill(bill);
                    System.out.println("Payment > ");
                    inputPayment = inp.nextFloat();
                    float rest = payment(finalPrice, inputPayment);
                    System.out.println("Rest of the money: "+ rest +"$");
                }
            }

        }while(choicemenu != 3);
    }

    static void getBill(ArrayList<Hamburgers> burgers){
        for(Hamburgers hamburgers : burgers){
            System.out.println("["+hamburgers.id+"]" + hamburgers.descr + " Price: " + hamburgers.price + "$ \n");
        }
        System.out.println("Final price " +finalPrice);
    }

    static float payment(float price, float inputMoney)
    {
        float restofMoney = inputMoney;
        if(restofMoney >= 1){
            restofMoney = inputMoney - price;
        }
        else if(restofMoney < 0){
            System.out.println("Not enough money, retry.");
        }
        return restofMoney;
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



