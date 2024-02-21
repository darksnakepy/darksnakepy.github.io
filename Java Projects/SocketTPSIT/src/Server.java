import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        while (true) {
            ServerSocket serverSocket = new ServerSocket(4444);
            Socket socket = serverSocket.accept();
            OutputStream writer = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println("Hello World");
            printWriter.flush();
            socket.close();
        }
    }
}