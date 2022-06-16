package main.filter;

import main.Student;

public class AdmissionYearFilter implements Filter {
    private int admissionYear;

    public AdmissionYearFilter(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    @Override
    public boolean filter(Student st) {
        return st.getAdmissionYear() == admissionYear;
    }

    @Override
    public String toSQL() {
        return "admission_year = " + admissionYear;
    }
}
