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
        static Socket sk = null;

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
                            if(login(msg.split("\\s+"))) {
                                break;
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
        System.out.println(credentials[0] + " " + credentials[1]);
        boolean is_logged = false;
        if (sql.login(credentials[0], credentials[1])) {
            send(sk,"true");
            is_logged = true;
        }
        else{
            send(sk,"false");
            is_logged = false;
        }
        return is_logged;
    }

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
}
