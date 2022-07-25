public class ReservedFood {
    private String studentNumber;
    private int codeFood;

    public ReservedFood(String studentNumber, int codeFood) {
        this.studentNumber = studentNumber;
        this.codeFood = codeFood;
    }
    public ReservedFood(String line) {
        String[] array = line.split(",");
        this.studentNumber = array[0];
        this.codeFood = Integer.parseInt(array[1]);
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
    public String coder(){
        return studentNumber+","+codeFood;
    }
}
