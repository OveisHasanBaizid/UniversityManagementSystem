import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person{
    private String stdNumber ;
    private String password;
    private ArrayList<Integer> coursesCode;

    public Student(String firstName, String lastName, int age, String address, String stdNumber, String password) {
        super(firstName, lastName, age, address);
        this.stdNumber = stdNumber;
        this.password = password;
        this.coursesCode = new ArrayList<>();
    }
    public Student(Scanner input) {
        super(input);
        do {
            System.out.print("StdNumber : ");
            this.stdNumber = input.nextLine();
        }while (DataBase.getStudent(stdNumber)!=null);
        System.out.print("Password : ");
        this.password  = input.nextLine();
        this.coursesCode = new ArrayList<>();
    }
    public String getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(String stdNumber) {
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
