public interface Mapper<T, Q> {
    Q map(T elem);

    static <T, Q, R> Mapper<T, R> compose(Mapper<T, Q> a, Mapper<Q, R> b) {
        return new Mapper<T, R>() {
            @Override
            public R map(T elem) {
                return b.map(a.map(elem));
            }
        };
        // return x -> b.map(a.map(x));
    }

    static <T, Q, R> Mapper<T, R> chain(Mapper<T, Q> a, Mapper<Q, R> b) {
        return x -> b.map(a.map(x));
    }

    static <T, Q, R, E> Mapper<T, E> chain(Mapper<T, Q> a, Mapper<Q, R> b, Mapper<R, E> c) {
        return x -> c.map(b.map(a.map(x)));
    }
}
