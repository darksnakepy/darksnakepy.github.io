import java.util.Random;

public class Train extends Thread {
    private volatile Status status;

    public Train() { // starts with waiting status
        status = status.WAITING;
    }
    public void setStatus(Status status){
        this.status = status;
    }

    public Status getStatus(){
        return status;
    }

    public void run() {
        int randomNumber = 0;
        Random rand = new Random();
        TrainCrossing trainCrossing = new TrainCrossing(this);
        trainCrossing.start();

        while (true) {
            randomNumber = rand.nextInt(5);
            System.out.println("Numero random > " + randomNumber);
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (randomNumber == 0) {
                status = Status.ARRIVING;
                while (status != Status.WAITING) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException exc) {
                    }
                }
            }
        }
    }
}
