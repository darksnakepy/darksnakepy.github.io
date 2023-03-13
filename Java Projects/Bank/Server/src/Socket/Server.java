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
                    //sql.register("dio", "cane", 5000.0, "gesu cristo fritto misto");
                    //sql.login("dio", "cane");
                    //sql.balance("dio");
                    //sql.withdraw(3000.0, "dio");
                    //sql.deposit(3000, "dio");

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
                                case "login"->{
                                    if(login(msg.split(";"))) {
                                        System.out.println("User logged correcty");
                                    }
                                }
                                case "deposit"->{
                                    if(deposit(action[1], action[2])){
                                        System.out.println("Deposit by client");
                                    }
                                }
                                case "withdraw"->{
                                    if(withdraw(action[1], action[2])){
                                        System.out.println("Withdraw by client");
                                    }
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
    public static boolean balance(String user) {
        try {
            sql.balance(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
