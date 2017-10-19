package TestAndSet;

public final class TestAndSet {
    public static synchronized boolean testandSet(Target target) {
        boolean oldtarget;
        oldtarget = target.get();
        target.set(true);
        return oldtarget;
    }
}