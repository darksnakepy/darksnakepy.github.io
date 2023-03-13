import java.io.*;
import java.util.Scanner;
import java.net.*;

class Client {
    static Scanner scanner = new Scanner(System.in);
    static Socket sk = null;

    public static void main(String[] args) {
        String user_global = "";
        boolean userlogged = false;
        boolean running = false;
        if (initialize()) {
            running = true;
            do {
                System.out.println("""
                        [1] Register an account 
                        [2] Login to an existent account""");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("Insert the username:\n>");
                        String user = scanner.next();
                        System.out.println("Insert the password:\n>");
                        String pass = scanner.next();
                        String response = login(user, pass);
                        if(response.equals("true")){
                            System.out.println("User logged correctly.");
                            userlogged = true;
                            user_global = user;
                            break;
                        }
                        else{
                            System.out.println("User doesn't exist.");
                        }
                    default:
                        System.out.println("An error occurred");
                        break;
                }
                if(userlogged){
                    do{
                        mainMenu();
                        choice = scanner.nextInt();
                        switch(choice){
                            case 1:
                                System.out.println("Insert the amount of money you want to deposit: ");
                                double inputMoney = scanner.nextDouble();
                                try {
                                    String deposit_response = deposit(inputMoney, user_global);
                                    if(deposit_response.equals("successful_deposit")){
                                        System.out.println("Done.");
                                    }
                                    else {
                                        System.out.println("An error occurred: ");
                                    }
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 2:
                                System.out.println("Insert the amount of money you want to withdraw: ");
                                double money = scanner.nextDouble();
                                try {
                                    String deposit_response = withdraw(money, user_global);
                                    if (deposit_response.equals("successful_withdraw")) {
                                        System.out.println("Done.");
                                    } else {
                                        System.out.println("An error occurred: ");
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error" + e.getMessage());
                                }
                                break;
                            case 3:
                                try {
                                    balance(user_global);
                                }catch(IOException e){
                                    System.out.println("Error" + e.getMessage());
                                }
                                break;
                        }
                        }while(choice!=5);
                    }
                }while (running);
            }
        }


    static boolean initialize() {
        try {
            sk = new Socket("192.168.1.8", 4444);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void mainMenu() {
        System.out.println("""
                [1] Deposit 
                [2] Withdraw
                [3] View your balance
                [4] View your movement list
                [5] Exit
                
                Choose an option:
                """);
    }

    // to code register function


    public static String login(String username, String password) {
        try {
            OutputStream output = sk.getOutputStream();
            DataOutputStream data = new DataOutputStream(output);
            data.writeUTF("login;"+username + ";" + password);
            data.flush();
            InputStream input_stream = sk.getInputStream();
            DataInputStream data2 = new DataInputStream(input_stream);
            return data2.readUTF();

        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public static String deposit(double moneyInput, String user) throws IOException {
        OutputStream output = sk.getOutputStream();
        DataOutputStream data = new DataOutputStream(output);
        data.writeUTF("deposit;"+moneyInput + ";" + user);
        data.flush();
        InputStream input_stream = sk.getInputStream();
        DataInputStream data2 = new DataInputStream(input_stream);
        return data2.readUTF();
    }

    public static String withdraw(double moneyInput, String user) throws IOException {
        OutputStream output = sk.getOutputStream();
        DataOutputStream data = new DataOutputStream(output);
        data.writeUTF("withdraw;"+moneyInput + ";" + user);
        data.flush();
        InputStream input_stream = sk.getInputStream();
        DataInputStream data2 = new DataInputStream(input_stream);
        return data2.readUTF();
    }

    public static String balance(String user) throws IOException {
        OutputStream output = sk.getOutputStream();
        DataOutputStream data = new DataOutputStream(output);
        data.writeUTF("balance;"+user);
        InputStream input_stream = sk.getInputStream();
        DataInputStream data2 = new DataInputStream(input_stream);
        return data2.readUTF();
    }
}
