package e_waitNotify;

public final class AttenteActiveSemaphore {
    private volatile int value;

    public AttenteActiveSemaphore(int value) {
        this.value = value;
    }

    public void signalAttenteActive() {
        synchronized (this) {
            value++;
        }
    }

    public void waitAttenteActive() {
        boolean blocked;
        do {
            blocked = atomicWaitBlocked();
        } while (blocked != false);
    }

    private synchronized boolean atomicWaitBlocked() {
        if (value > 0) {
            value--;
            return false;
        } return true;
    }
}