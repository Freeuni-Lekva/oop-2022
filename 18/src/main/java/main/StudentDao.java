package main;

import main.filter.Filter;

import java.util.List;

public interface StudentDao {
    List<Student> getStudents();
    List<Student> getFiltered(Filter f);
    void createStudent(Student st);
}
