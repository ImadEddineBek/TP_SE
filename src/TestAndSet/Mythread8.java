package TestAndSet;

public class Mythread8 extends Thread {
    private int id;
    private volatile static Target target = new Target();

    Mythread8(int id) {
        this.id = id;
    }


    public void siesta() {
        try {
            sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }

    public void entry_Section() {
        while (TestAndSet.testandSet(target)) {
            System.out.println(id);
            siesta();
        }
    }

    public void criticalSection() {
        System.out.println(" Inside Critical  Section Process  :" + id);
        siesta();
    }

    public void exit_Section() {
        System.out.println("Process OutSide:" + id);
        target.set(false);
    }

    public void remainderSection() {
        siesta();
    }

    public void run() {
        do {
            entry_Section();
            criticalSection();
            exit_Section();
            remainderSection();

    } while(true);
}

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Mythread8 processI = new Mythread8(i);
            processI.start();
        }}}
