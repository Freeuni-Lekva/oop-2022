package shared;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TT {
    private static void printObject(Object o) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = o.getClass();
        for (Field f : cls.getDeclaredFields()) {
            // f.setAccessible(true);
            System.out.printf("%s %f\n", f.getName(), f.get(o));
        }
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Point p = new Point(5, 6);
        Point q = new Point(5, 7);
        // printObject(p);
        // printObject(q);
        Method distance = Point.class.getDeclaredMethod("distance", Point.class);
        System.out.println(distance.invoke(p, q));

        Method distance2 = Point.class.getDeclaredMethod("distance", double.class, double.class);
        System.out.println(distance2.invoke(p, q.x, q.y));

        System.out.println(Point.class.getAnnotation(Author.class).email());
        System.out.println(Point.class.getField("x").getAnnotation(Author.class).name());
        System.out.println(Point.class.getMethod("getX").getAnnotation(Author.class).name());
    }
}


//            String name = f.getName();
//            char first = Character.toUpperCase(name.charAt(0));
//            Method m = cls.getMethod("get" + first + name.substring(1));
//            System.out.println(m.invoke(p));
//            // System.out.println(f.get(p));

