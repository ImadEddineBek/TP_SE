package Swap;

public class Key

{
    private volatile boolean key;

    public boolean get() {
        return key;
    }

    public void set(boolean key) {
        this.key = key;
    }
}