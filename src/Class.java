public class Class {
    private String className;
    private int credWeight;
    private double gradePoint;

    public Class (String className, int credWeight, double gradePoint) {
        this.className = className;
        this.credWeight = credWeight;
        this.gradePoint = gradePoint;
    }

    public int getCredWeight() {
        return credWeight;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public String getClassName() {
        return className;
    }
}
