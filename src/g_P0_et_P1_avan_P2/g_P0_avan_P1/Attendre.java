package g_P0_et_P1_avan_P2.g_P0_avan_P1;

import java.util.concurrent.Semaphore;

public class Attendre {
    static Semaphore semaphore = new Semaphore(0,true);
    static Semaphore semaphore1 = new Semaphore(0,true);
    public static void main(String[] args) {
        ProcessusP0 p0 = new ProcessusP0(semaphore);
        ProcessusP1 p1 = new ProcessusP1(semaphore1);
        ProcessusP2 p2 = new ProcessusP2(semaphore,semaphore1);
        p0.start();
        p1.start();
        p2.start();
    }
}

class ProcessusP0 extends Thread{
    Semaphore semaphore;
    ProcessusP0(Semaphore semap){
        semaphore=semap;
    }
    @Override
    public void run() {

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
            P1_section();
            exit_section();

    }

    private void exit_section() {
semaphore.release();
    }

    private void P1_section() {
        System.out.println("P1 est en execution");
    }



}
class ProcessusP2 extends Thread{
    Semaphore semaphore;
    Semaphore semaphore2;
    ProcessusP2(Semaphore semap,Semaphore semap2){
        semaphore=semap;
        semaphore2 = semap2;
    }
    @Override
    public void run() {

        try {
            semaphore.acquire();
            semaphore2.acquire();
        } catch (InterruptedException e) {

        }
        P2_section();


    }

    private void P2_section() {
        System.out.println("P2 execute");
    }

    private void exit_section() {
        semaphore.release();
    }

}