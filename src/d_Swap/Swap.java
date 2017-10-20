package d_Swap;

public final class Swap {
    public static synchronized void swap(Key key, Lock lock) {
        boolean temp;
        temp = lock.get();
        lock.set(key.get());
        key.set(temp);
    }
}