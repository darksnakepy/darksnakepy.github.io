package Socket;
import java.io.*;
import java.net.*;

class Main {
    public static void main(String[] args) {

        boolean running = false;

        ServerSocket serverSock = null;
        Socket sk = null;
        System.out.println("Socket Creation..");
        try {
            serverSock = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println(e.getMessage()); // debug message
            System.exit(1);
        }

        do {
            try {
                System.out.println("Checking for connection.. ");
                sk = serverSock.accept();
                running = true;
            } catch (IOException e) {
                System.out.println("Failed to connect to a socket. ");
                System.exit(2);
                running = false;
            }
            if(running) {
                System.out.println("Connected at server at  " + sk.getInetAddress().getHostName());
                try {
                    BufferedInputStream ib = new BufferedInputStream(sk.getInputStream());
                    DataInputStream is = new DataInputStream(ib);
                    BufferedOutputStream ob = new BufferedOutputStream(sk.getOutputStream());
                    PrintStream os = new PrintStream(ob, false);


                } catch (IOException e) {

                }
            }

        } while (running);
    }
    public boolean login(){
        return false;
    }
}
