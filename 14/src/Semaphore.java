public interface Semaphore {
    // Blocks if current value is zero
    void acquire() throws InterruptedException; // --

    void release(int k); // + k
}
