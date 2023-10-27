public class Train extends Thread {
    public volatile State status;

    public Train() { // starts with waiting status
        status = State.WAITING;
    }

    public void setStatus(State status){
        this.status = status;
    }

    public void run() {

    }

}
