package main.filter;

import main.Student;

public class LastNameFilter implements Filter {
    private String lastName;

    public LastNameFilter(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean filter(Student st) {
        return st.getLastName().equals(lastName);
    }

    @Override
    public String toSQL() {
        return "last_name = '" + lastName + "'";
    }
}
