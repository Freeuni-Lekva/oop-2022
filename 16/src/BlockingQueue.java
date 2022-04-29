import java.util.Optional;

public interface BlockingQueue<T> {
    void push(T elem);
    boolean tryPush(T elem);
    T remove();
    // Pair instead of optional
    Optional<T> tryRemove();
}
