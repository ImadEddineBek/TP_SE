package a_Creation;

public class Mythread1 extends Thread{
    static  int x = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            x++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Mythread1 mythread = new Mythread1();
        mythread.start();
        Mythread1 mythread2 = new Mythread1();
        mythread2.start();
        mythread.join();
        mythread2.join();
        System.out.println(x);
    }
}
