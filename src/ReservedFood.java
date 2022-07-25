public class ReservedFood {
    private String studentNumber;
    private int codeFood;

    public ReservedFood(String studentNumber, int codeFood) {
        this.studentNumber = studentNumber;
        this.codeFood = codeFood;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getCodeFood() {
        return codeFood;
    }

    public void setCodeFood(int codeFood) {
        this.codeFood = codeFood;
    }

}
