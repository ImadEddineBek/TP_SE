public class Mythread3 extends Thread {
    private int id;

    public Mythread3(int id) {
        this.id = id;
    }

    public void siesta() throws InterruptedException {
        sleep((int) (Math.random() * 500));
    }

    public void entry_Section() {
    }

    public void criticalSection() throws InterruptedException {
        System.out.println("      critical Section Process  :" + id);
        siesta();
    }

    public void exit_Section() {
        System.out.println("Process OutSide:" + id);
    }

    public void run() {
        do {
            entry_Section();
            try {
                criticalSection();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exit_Section();
        } while (true);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Mythread3 process = new Mythread3(i);
            process.start();
        }
    }
}