package Socket;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import sqlite.*;

class Server {
    static SQL_FUNCTIONS sql = new SQL_FUNCTIONS();
    static Socket sk = null;
    public static void main(String[] args) throws SQLException {
        boolean running = true;

        ServerSocket serverSock = null;
        System.out.println("Socket Created");

        try {
            serverSock = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println(e.getMessage()); // debug message
            System.exit(1);
        }

        while (running) {
            try {
                sk = serverSock.accept();
                System.out.println("Connected at server at " + sk);
                if (sql.connectionHandle()) {
                    // testing sql functions
                    System.out.println("DB IS READY");

                    while (true) {
                        try {
                            InputStream inp = sk.getInputStream();
                            DataInputStream data = new DataInputStream(inp);
                            String msg = data.readUTF();
                            /*if(login(msg.split("\\s+"))) {
                                break;
                            }
                             */
                            String[] action = msg.split(";");
                            switch(action[0]){
                               case "register"->{
                                   try {
                                       if (register(action[1], action[2], Double.parseDouble(action[3]), action[4])) {
                                           System.out.println("User registered");
                                           update_list(action[1], "User Created in the database");
                                       }
                                   }catch (SQLException e){
                                       System.out.println("Error"+e.getMessage());
                                   }
                               }
                                case "login"->{
                                    if(login(msg.split(";"))) {
                                        System.out.println("User logged correcty");
                                    }
                                }
                                case "deposit"->{
                                    if(deposit(action[1], action[2])){
                                        System.out.println("Deposit by client");
                                    }
                                    if(update_list(action[2], "User deposited "+action[1] +" $")){
                                        System.out.println("deposit list");
                                    };
                                }
                                case "withdraw"->{
                                    if(withdraw(action[1], action[2])){
                                        System.out.println("Withdraw by client");
                                    }
                                    update_list(action[2], "User took "+action[1] +" $");
                                }
                                case "balance"->{
                                    balance(action[1]);
                                    System.out.println("Balance");
                                }
                            }
                        }catch(IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Failed to connect to a socket. Aborting");
                System.exit(2);
                running = false;
            }

        }
    }

    public static boolean register(String user, String pass, double balance, String movement_list) throws SQLException {
        //System.out.println(credentials[0] + " " + credentials[1]);
        boolean is_registered = false;
        if (sql.register(user, pass, balance, movement_list)) {
            send(sk,"true");
            is_registered = true;
        }
        else{
            send(sk,"false");
            is_registered = false;
        }
        return is_registered;
    }



    public static boolean login(String credentials[]) throws SQLException {
        //System.out.println(credentials[0] + " " + credentials[1]);
        boolean is_logged = false;
        if (sql.login(credentials[1], credentials[2])) {
            send(sk,"true");
            is_logged = true;
        }
        else{
            send(sk,"false");
            is_logged = false;
        }
        return is_logged;
    }

    public static boolean deposit(String money, String user) throws SQLException {
        if(sql.deposit(Double.parseDouble(money), user)){
            send(sk, "successful_deposit");
            return true;
        }

        else{
            send(sk,"failed_deposit");
            return false;
        }
    }

    public static boolean withdraw(String money, String user) throws SQLException {
        if(sql.withdraw(user, Double.parseDouble(money))){
            send(sk, "successful_withdraw");
            return true;
        }
        else{
            send(sk,"failed_withdraw");
            return false;
        }
    }

    //sends data
    public static void send(Socket sk, String argument) {
        try {
            if(sk!=null) {
                OutputStream output = sk.getOutputStream();
                DataOutputStream data = new DataOutputStream(output);
                data.writeUTF(argument);
                data.flush();
            }else {
                System.out.println("Socket is null");
            }
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
    }
    public static Double balance(String user) {
        try {
            double balance = sql.balance(user);
            return balance;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean update_list(String user, String text){
        try {
            sql.movementUpdate(user,text);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
