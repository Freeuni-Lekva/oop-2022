public interface Reducer<T, Q> {
    Q reduce(Q r, T elem);
}
