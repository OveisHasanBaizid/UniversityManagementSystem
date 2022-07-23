public class BookLoaned {
    private int studentNumber;
    private int codeBook;

    public BookLoaned(int studentNumber, int codeBook) {
        this.studentNumber = studentNumber;
        this.codeBook = codeBook;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
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
