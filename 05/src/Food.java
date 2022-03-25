public class Food {
    private String name;
    private int weight;

    public Food(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Food(String name) {
        this(name, 100);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean same(Food food) {
        System.out.println("-- Food.same");
        return name.equals(food.getName());
    }

}
