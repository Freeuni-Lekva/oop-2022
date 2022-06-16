package main;

import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private int admissionYear;

    public Student(String firstName, String lastName, int admissionYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.admissionYear = admissionYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }
}
