package c_TestAndSet;

public class Target {
    private volatile boolean target = false;

    public boolean get() {
        return target;
    }

    public void set(boolean target) {
        this.target = target;
    }
}
