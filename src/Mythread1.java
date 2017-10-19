public class Mythread1 extends Thread{
    @Override
    public void run() {
        System.out.println("first thread");
    }

    public static void main(String[] args) {
        Mythread1 mythread1 = new Mythread1();
        mythread1.start();
    }
}
