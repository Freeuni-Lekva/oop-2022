public class Test {
    interface Foo {
        void run();
    }

    public static void main(String[] args) {
        final Integer x = Integer.valueOf(5);
        Integer y = Integer.valueOf(10);
        new Foo(){
            @Override
            public void run() {
                x = Integer.valueOf(3);
            }
        }
                ..
        ..
        process(x);
    }
}

class FooTemporary implements Foo {
    private Integer x;

    public FooTemporary(Integer x) {
        this.x = x;
    }

    @Override
    public void run() {
        // x = Integer.valueOf(3);
        x.add(5);
    }
}