package d_Swap;

public class Lock

{
    private volatile boolean lock = false;

    public boolean get() {
        return lock;
    }

    public void set(boolean lock) {
        this.lock = lock;
    }
}