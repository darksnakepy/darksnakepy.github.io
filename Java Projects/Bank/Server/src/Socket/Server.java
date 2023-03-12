package Socket;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

import sqlite.*;

class Server {
    static SQL_FUNCTIONS sql = new SQL_FUNCTIONS();

    public static void main(String[] args) throws SQLException {

        boolean running = true;

        ServerSocket serverSock = null;
        Socket sk = null;
        System.out.println("Socket Creation..");

        try {
            serverSock = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println(e.getMessage()); // debug message
            System.exit(1);
        }

        System.out.println("Checking for connection.. ");

        while (running) {
            try {
                sk = serverSock.accept();
                running = true;
            } catch (IOException e) {
                System.out.println("Failed to connect to a socket. ");
                System.exit(2);
                running = false;
            }
            if (running) {
                System.out.println("Connected at server at " + sk.getInetAddress().getHostName());
                if(sql.connectionHandle()){
                    // testing sql functions
                    System.out.println("DB EXISTS");
                    //sql.register("dio", "cane", 5000.0, "gesu cristo fritto misto");
                    //sql.login("dio", "cane");
                    //sql.balance("dio");
                    //sql.withdraw(3000.0, "dio");
                    //sql.deposit(3000, "dio");
                }
                try {
                    BufferedInputStream ib = new BufferedInputStream(sk.getInputStream());
                    DataInputStream is = new DataInputStream(ib);
                    BufferedOutputStream ob = new BufferedOutputStream(sk.getOutputStream());
                    PrintStream os = new PrintStream(ob, false);


                } catch (IOException e) {

                }
            }
        }
    }
}
