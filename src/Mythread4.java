public class Mythread4 extends Thread {
    private int id;
    private volatile static int turn = 0;

    public Mythread4(int id) {
        this.id = id;
    }

    public void siesta() {
        try {
            System.out.println(" Inside Siesta Section Process  :" + id);
            sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }

    public void entry_Section() {
        while (id != turn) siesta();
    }

    public void criticalSection() {
        System.out.println(" Inside Critical Section Process  :" + id);
        siesta();
    }

    public void exit_Section() {
        System.out.println("Process OutSide:" + id);
        turn = 1 - id;
    }
    public void run() {
        do {
            entry_Section();
            criticalSection();
            exit_Section();
        } while (id!=1);
    }

    public static void main(String[] args) {
        for (int i = 0; i <2;i++){
            Mythread4 process = new Mythread4(i);
            process.start();
        }
    }}
