package b_mistakes;

public class DeckerSolution extends Thread {
    private int id;
    private static int turn;
    private static boolean[] flag = new boolean[2];

    public DeckerSolution(int id) {
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
            siesta();
        } while (id!=0);
    }

    public static void main(String[] args) {
        for (int i = 0; i <2;i++){
            DeckerSolution process = new DeckerSolution(i);
            process.start();
        }
    }
}
