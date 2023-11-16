public class TrainCrossing extends Thread{
    private final Train train;

    public TrainCrossing(Train train) {
        this.train = train;
    }

    public void run(){
        while (true) {
            while (train.getStatus() != Status.ARRIVING) {
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                System.out.println("--------------------");
                System.out.println("Abbasso la sbarra\n" +
                        "Semaforo rosso acceso\n" +
                        "Il treno sta arrivando");
                System.out.println("--------------------");
                Thread.sleep(4000);
                train.setStatus(Status.CROSSING);
                System.out.println("--------------------");
                System.out.println("La sbarra è abbassata\n" +
                        "Il treno sta passando");
                System.out.println("--------------------");
                Thread.sleep(4000);
                train.setStatus(Status.WAITING);
                System.out.println("--------------------");
                System.out.println("Sbarra alzata\n" +
                        "Aspetto che passi un treno");
                System.out.println("--------------------");
            } catch (InterruptedException e) {

            }
        }
    }
}

