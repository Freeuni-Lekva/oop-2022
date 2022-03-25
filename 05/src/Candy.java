public class Candy extends Food {
    public Candy(String name) {
        super(name);
    }

    @Override
    public boolean same(Food candy) {
        System.out.println("-- Candy.same");
        return this == candy;
    }
}
