package e_waitNotifyJava.e_waitNotify;
import java.util.concurrent.Semaphore;

public class CriticalSectionSemaphore extends Thread {
    private int id;
    private volatile static Semaphore s = new Semaphore(0, true);

    public CriticalSectionSemaphore(int id) {
        this.id = id;
    }


    public void siesta() {
        try {
            sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }

    public void entry_Section() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void criticalSection() {
        System.out.println(" Inside Critical Section Process  :" + id);
    }

    public void exit_Section() {
        System.out.println("Process OutSide:" + id);
        s.release();
    }

    public void remainderSection() {
        siesta();
    }


    public void run() {
//        do {
//            entry_Section();
//            criticalSection();
//            exit_Section();
//            remainderSection();
//        } while (true);
        if (id == 0){
            System.out.println("thread 1");
            s.release();
        }else {
            System.out.println("thread 2");
            try {
                s.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 1; i++) {
            CriticalSectionSemaphore processI = new CriticalSectionSemaphore(i);
            processI.start();
        }
    }
}