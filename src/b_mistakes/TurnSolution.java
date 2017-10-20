package b_mistakes;

public class TurnSolution extends Thread {
    private int id;
    private volatile static int turn = 0;

    public TurnSolution(int id) {
        this.id = id;
    }

    public void siesta() {
        try {
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
        } while (true);
    }

    public static void main(String[] args) {
        for (int i = 0; i <2;i++){
            TurnSolution process = new TurnSolution(i);
            process.start();
        }
    }}
