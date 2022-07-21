import java.util.ArrayList;

public class Student extends Person{
    private long stdNumber ;
    private String password;
    private ArrayList<Integer> coursesCode;

    public Student(String firstName, String lastName, int age, String address, long stdNumber, String password) {
        super(firstName, lastName, age, address);
        this.stdNumber = stdNumber;
        this.password = password;
        this.coursesCode = new ArrayList<>();
    }

    public long getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(long stdNumber) {
        this.stdNumber = stdNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Integer> getCoursesCode() {
        return coursesCode;
    }

    public void setCoursesCode(ArrayList<Integer> coursesCode) {
        this.coursesCode = coursesCode;
    }
}
