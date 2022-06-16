package main.filter;

import main.Student;

public class FirstNameFilter implements Filter {
    private String firstName;
    
    public FirstNameFilter(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean filter(Student st) {
        return st.getFirstName().equals(firstName);
    }

    @Override
    public String toSQL() {
        return "first_name = '" + firstName + "'";
    }
}
