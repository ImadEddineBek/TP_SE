package b_mistakes;

public class CriticalSectionProblem extends Thread {
    private int id;

    public CriticalSectionProblem(int id) {
        this.id = id;
    }

    public void siesta() {
        try {
            sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entry_Section() {
    }

    public synchronized void criticalSection() {
        System.out.println("      critical Section Process  :" + id);
        System.out.println("Process OutSide:" + id);
    }

    public void exit_Section() {

    }

    public  void run() {
        do {
            entry_Section();
            criticalSection();
            exit_Section();
            siesta();
        } while (true);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            CriticalSectionProblem process = new CriticalSectionProblem(i);
            process.start();
        }
    }
}