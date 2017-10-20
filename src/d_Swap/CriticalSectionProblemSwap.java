package d_Swap;

public class CriticalSectionProblemSwap extends Thread
{
    private volatile static Lock lock = new Lock();
    private int id;
    private volatile Key key;

    public CriticalSectionProblemSwap(int id) {
        this.id = id;
        key = new Key();
    }


    public void siesta() {
        try {
            sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }

    public void entry_Section() {
        key.set(true);
        while (key.get()) {
//            System.out.println(id);
            Swap.swap(key, lock);
            siesta();
        }
    }


    public void criticalSection() {
        System.out.println(" Inside Critical  Section Process  :" + id);
        siesta();
    }

    public void exit_Section() {
        System.out.println("Process OutSide:" + id);
        lock.set(false);
    }

    public void remainderSection() {
        siesta();
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
        for (int i = 0; i <= 2; i++) {
            CriticalSectionProblemSwap processI = new CriticalSectionProblemSwap(i);
            processI.start();
        }
    }
}