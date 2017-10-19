public class Mythread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("My runnable 1");
    }

    public static void main(String[] args) {
     Thread thread = new Thread(new Mythread2());
     thread.start();
    }
}
