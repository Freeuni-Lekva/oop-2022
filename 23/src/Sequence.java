public interface Sequence<T> extends Iterable<T> {
    default <Q> Sequence<Q> map(Mapper<T, Q> mapper) {
        ListSequence<Q> ret = new ListSequence<>();
        for (T elem : this) {
            Q q = mapper.map(elem);
            ret.add(q);
        }
        return ret;
    }

    default Sequence<T> filter(Filter<T> filter) {
        ListSequence<T> ret = new ListSequence<>();
        for (T elem : this) {
            if (filter.filter(elem)) {
                ret.add(elem);
            }
        }
        return ret;
    }

    default <Q> Q reduce(Reducer<T, Q> reducer, Q init) {
        Q current = init;
        for (T elem : this) {
            current = reducer.reduce(current, elem);
        }
        return current;
    }

    static <T> Sequence<T> flatten(Sequence<Sequence<T>> s) {
        ListSequence<T> ret = new ListSequence<>();
//        for (Sequence<T> i :  s) {
//            for (T j  : i) {
//                ret.add(j);
//            }
//        }
        s.reduce((r, elem) -> {
            elem.reduce((r1, elem1) -> {
                r1.add(elem1);
                return r1;
            }, r);
            return r;
        }, ret);
        return ret;
    }
}
