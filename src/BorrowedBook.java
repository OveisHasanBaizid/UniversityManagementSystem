public class BorrowedBook {
    private final String studentNumber;
    private final int codeBook;

    public BorrowedBook(String studentNumber, int codeBook) {
        this.studentNumber = studentNumber;
        this.codeBook = codeBook;
    }
    public BorrowedBook(String line) {
        String[] array = line.split(",");
        this.studentNumber = array[0];
        this.codeBook = Integer.parseInt(array[1]);
    }
    public String getStudentNumber() {
        return studentNumber;
    }

    public int getCodeBook() {
        return codeBook;
    }
    public String coder(){
        return studentNumber+","+codeBook;
    }
    @Override
    public String toString() {
        return "Student Number : " + studentNumber + "\tCode Book : " + codeBook;
    }
}
