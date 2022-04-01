import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Moodable> l = new ArrayList<>();
        l.add(new Student(10));
        l.add(new GradStudent(20, 4));
        l.add(new Account(5000000));
        for (Moodable m : l) {
            System.out.println(m.getMood());
        }

        System.out.println("--------");

        Valuable v = (Valuable) l.get(2);
        System.out.printf("VALUE IS: %d\n", v.getValue());

//        Moodable[] x = new Moodable[3];
//        x[0] = new Student(10);
//        x[1] = new GradStudent(20, 4);
//        x[2] = new Account(5000000);
//        for (Moodable m : x) {
//            System.out.println(m.getMood());
//        }


        Container<Account> c = new ArrayContainer<>(3);
        c.set(0, new Account(100));
        c.set(1, new Account(1000));
        c.set(2, new Account(10));
        Account max = c.findMax();
//        Account max = c.findMax(new Comparator<Account>() {
//            @Override
//            public int compare(Account a, Account b) {
//                if (a == null && b == null) {
//                    return 0;
//                }
//                if (a == null) {
//                    return -1;
//                }
//                if (b == null) {
//                    return 1;
//                }
//                return a.getValue() - b.getValue();
//            }
//        });

//        Account mm = c.findMax((a,  b) -> {
//                if (a == null && b == null) {
//                    return 0;
//                }
//                if (a == null) {
//                    return -1;
//                }
//                if (b == null) {
//                    return 1;
//                }
//                return a.getValue() - b.getValue();
//        });

        System.out.printf("MAX: %d\n", max.getValue());




        Button okButton = new Button(new ButtonClickHandler(){
            void onClick() {
                // send email
            }
        });
        Button cancelButton = new Button(new ButtonClickHandler(){
            void onClick() {
                // delete email
            }
        });
    }
}
