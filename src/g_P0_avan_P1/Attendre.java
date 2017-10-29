package g_P0_avan_P1;

import java.util.concurrent.Semaphore;

public class Attendre {
    static Semaphore semaphore = new Semaphore(0,true);
    public static void main(String[] args) {
        ProcessusP0 p0 = new ProcessusP0(semaphore);
        ProcessusP1 p1 = new ProcessusP1(semaphore);
        p0.start();
        p1.start();
    }
}
class ProcessusP0 extends Thread{
    Semaphore semaphore;
    ProcessusP0(Semaphore semap){
        semaphore=semap;
    }
    @Override
    public void run() {

            entry_section();
            P0_section();
            exit_section();

    }

    private void P0_section() {
        System.out.println("P0 execute");
    }

    private void exit_section() {
        semaphore.release();
    }

    private void entry_section() {

    }
}
class ProcessusP1 extends Thread{
    Semaphore semaphore;
    ProcessusP1(Semaphore semap){
        semaphore=semap;
    }
    @Override
    public void run() {

            entry_section();
            P1_section();
            exit_section();

    }

    private void exit_section() {

    }

    private void P1_section() {
        System.out.println("P1 est en execution");
    }

    private void entry_section() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}