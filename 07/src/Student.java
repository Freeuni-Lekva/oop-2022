public class Student implements Moodable {
    private int numUnits;

    public Student(int numUnits) {
        this.numUnits = numUnits;
    }

    public int getNumUnits() {
        return numUnits;
    }

    public void setNumUnits(int numUnits) {
        this.numUnits = numUnits;
    }

    public int getStress() {
        System.out.println("STUD STRESS");
        return numUnits * 10;
    }

    @Override
    public boolean getMood() {
        System.out.println("STUD GETMOOD");
        return getStress() < 500;
    }
}
