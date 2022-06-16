package main.filter;

import main.Student;

public interface Filter {
    boolean filter(Student st);
    String toSQL();
}
