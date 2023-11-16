import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Train train = new Train();
        train.start();

        Thread main = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    String inp = scanner.next();
                    if (inp.charAt(0) == 'q') {
                        train.interrupt();
                        System.exit(0);
                    }
                }
            }
        });
        main.start();

    }
}
