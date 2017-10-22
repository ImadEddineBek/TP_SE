package e_waitNotify;

import e_waitNotify.AttenteActiveSemaphore;

public class CriticalSectionSemaphore extends Thread {
    private int id;
    private volatile static AttenteActiveSemaphore s = new AttenteActiveSemaphore(0);

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
        s.waitAttenteActive();
    }

    public void criticalSection() {
        System.out.println(" Inside Critical Section Process  :" + id);
    }

    public void exit_Section() {
        s.signalAttenteActive();
        System.out.println("Process OutSide:" + id);
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
        } while (true);
//        if (id ==0) {
//            System.out.println("hello World "+id);
//            s.signalAttenteActive();
//        }else {
//            s.waitAttenteActive();
//            System.out.println("hello World "+id);
//        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 1; i++) {
            CriticalSectionSemaphore processI = new CriticalSectionSemaphore(i);
            processI.start();
        }
    }
}