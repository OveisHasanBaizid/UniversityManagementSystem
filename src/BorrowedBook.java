public class BorrowedBook {
    private String studentNumber;
    private int codeBook;

    public BorrowedBook(String studentNumber, int codeBook) {
        this.studentNumber = studentNumber;
        this.codeBook = codeBook;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(int codeBook) {
        this.codeBook = codeBook;
    }

    @Override
    public String toString() {
        return "Student Number : " + studentNumber + "\tCode Book : " + codeBook;
    }
}
