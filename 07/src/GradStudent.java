public class GradStudent extends Student {
    private int numYearsOnThesis;

    public GradStudent(int numUnits, int numYearsOnThesis) {
        super(numUnits);
        this.numYearsOnThesis = numYearsOnThesis;
    }

    @Override
    public int getStress() {
        System.out.println("GRAD STRESS");
        return super.getStress() + numYearsOnThesis * 100;
    }
}
