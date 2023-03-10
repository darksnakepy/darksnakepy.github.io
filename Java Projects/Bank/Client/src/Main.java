import javax.print.DocFlavor;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Client {
    static Scanner scanner = new Scanner(System.in);
    static Socket sk = null;
    //DataInputStream is = null;
    //PrintStream os = null;

    public static void main(String[] args) {
        String user_global;

        boolean running = false;
        if(initialize()) {
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
                        System.out.println("Insert the username\n>");
                        String user = scanner.next();
                        System.out.println("Insert the password\n>");
                        String password = scanner.next();
                        login(user,password);
                        user_global = user;

                        do{
                            mainMenu();
                            choice = scanner.nextInt();
                            switch(choice){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    getBalance(user_global);
                                case 4:
                                    movementList(user_global);

                                default:
                                    System.out.println("Error");
                            }


                        }while (running);
                        break;
                    default:
                        System.out.println("Error.");
                        running = false;
                }
            } while (running);
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

    public static void mainMenu(){
        System.out.println("""
                [1] Deposit 
                [2] Withdraw
                [3] View your balance
                [4] View your movement list
                [5] Exit
                """);
    }

    public static String login(String username, String password){
        try{
            OutputStream output = sk.getOutputStream();
            DataOutputStream data = new DataOutputStream(output);
            data.writeUTF(username + " "+ password);
            data.flush();
            InputStream inputStream = sk.getInputStream();
            DataInputStream data2 = new DataInputStream(inputStream);
            String msg = data2.readUTF();
            return msg;
        }catch(IOException e){
            return "Error: "+e;
        }
    }

    public static String getBalance(String username){
        try{
            InputStream inputStream = sk.getInputStream();
            DataInputStream data = new DataInputStream(inputStream);
            return data.readUTF();
        }catch(IOException e){
            return "Error: "+e;
        }
    }

    public static String deposit(String moneyInput, String username){
        try{
           /*
            OutputStream output = sk.getOutputStream();
            DataOutputStream data = new DataOutputStream(output);
            data.writeUTF(moneyInput + " "+ username);
            data.flush();

            */
        }catch(IOException e){
            return "Error: "+e;
        }
    }

    public static String movementList(String username){

    }

}