public class Main {
    public static void main(String[] args) {
//        List l;
//        l = new ArrayList();
//        ...
//        ...
//        l = new DoubleLinkedList();

        // Food brocolli = new Food("brocolli");
        Food c = new Candy("lolipop");
        Integer i = Integer.valueOf(5);
        Object o = i;
        Food f = (Food) o;
        c.same();

//        Boolean o = c.same(null);
//
//
//        System.out.println(c.same(new Candy("123123")));
//        System.out.println(c.same((Food) new Candy("lolipop")));
    }
}
