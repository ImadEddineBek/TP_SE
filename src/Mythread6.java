public class Mythread6 extends Thread {
    private int id;
    private static int turn;
    private static boolean[] flag = new boolean[2];

    public Mythread6(int id) {
        this.id = id;

    }

    public void siesta() {
        try {
            sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }

    public void entry_Section() {
        flag[id] = true;
        turn = 1 - id;
        while (flag[1 - id] && turn == 1 - id) siesta();
    }

    public void criticalSection() {
        System.out.println(" Inside Critical  Section Process  :" + id);
        siesta();
    }

    public void exit_Section() {
        System.out.println("Process OutSide:" + id);
        flag[id] = false;
    }

    public void remainder_Section() {
        if (id==0)siesta();
    }
    public void run() {
        do {
            entry_Section();
            criticalSection();
            exit_Section();
            remainder_Section();
        } while (true);
    }

    public static void main(String[] args) {
        for (int i = 0; i <2;i++){
            Mythread6 process = new Mythread6(i);
            process.start();
        }
    }
}
