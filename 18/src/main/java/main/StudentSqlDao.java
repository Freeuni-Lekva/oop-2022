package main;

import main.filter.Filter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentSqlDao implements StudentDao {
    private Connection conn;

    public StudentSqlDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Statement stm = null;
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT first_name, last_name, admission_year FROM students;");
            while (rs.next()) {
                students.add(new Student(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> getFiltered(Filter f) {
        List<Student> students = new ArrayList<>();
        Statement stm = null;
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT first_name, last_name, admission_year FROM students WHERE " + f.toSQL() + ";");
            while (rs.next()) {
                students.add(new Student(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void createStudent(Student st) {
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement("INSERT INTO students (first_name, last_name, admission_year) VALUES (?, ?, ?);");
            stm.setString(1, st.getFirstName());
            stm.setString(2, st.getLastName());
            stm.setInt(3, st.getAdmissionYear());
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
