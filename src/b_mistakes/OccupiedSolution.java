package b_mistakes;

public class OccupiedSolution extends Thread {
    public volatile static boolean occupied ;
    int id;
    public OccupiedSolution(int id) {
        this.id = id;
    }

    public void siesta() {
        try {
            sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }

    public void entry_Section() {
        while (occupied) siesta();
        occupied = true;
    }

    public  void criticalSection() {
        System.out.println(" Inside Critical  Section Process  :" + id);
        siesta();
    }

    public void exit_Section() {
        System.out.println(" Outside Process  :" + id);
        occupied = false;
    }

    public void run() {
        do {
            entry_Section();
            criticalSection();
            exit_Section();
            siesta();
        } while (true);
    }

    public static void main(String[] args) {
        for (int i = 0; i <2;i++){
            OccupiedSolution process = new OccupiedSolution(i);
            process.start();
        }
    }
}
