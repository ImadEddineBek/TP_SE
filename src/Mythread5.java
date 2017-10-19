public class Mythread5 extends Thread {
    private int id;
    private volatile static boolean[] flag = {false, false};

    public Mythread5(int id) {
        this.id = id;
    }

    public void siesta() {
        try {
            sleep((int) (Math.random() ));
        } catch (InterruptedException e) {
        }
    }

    public void entry_Section() {
        flag[id] = true;
        while (flag[1 - id]) siesta();
    }

    public void criticalSection() {
        System.out.println(" Inside Critical  Section Process  :" + id);
        siesta();
    }

    public void exit_Section() {
        System.out.println("Process OutSide:" + id);
        flag[id] = false;
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
            Mythread5 process = new Mythread5(i);
            process.start();
        }
    }
}
