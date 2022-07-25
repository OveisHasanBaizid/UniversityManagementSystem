import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    private String stdNumber;
    private String password;
    private float average;
    private ArrayList<Integer> coursesCode;

    public Student(float average,String firstName, String lastName, int age, String address, String stdNumber, String password) {
        super(firstName, lastName, age, address);
        this.average = average;
        this.stdNumber = stdNumber;
        this.password = password;
        this.coursesCode = new ArrayList<>();
    }

    public Student(Scanner input) {
        super(input);
        while (true){
            System.out.print("Average : ");
            this.average = input.nextInt();
            if (average<20 && average>=0)
                break;
            else
                System.out.println("The average entered is invalid");
        }
        do {
            System.out.print("StdNumber : ");
            this.stdNumber = input.nextLine();
        } while (DataBase.getStudent(stdNumber) != null);
        System.out.print("Password : ");
        this.password = input.nextLine();
        this.coursesCode = new ArrayList<>();
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
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
    public boolean addCourse(int code){
        if (existCourse(code))
            return false;
        coursesCode.add(code);
        return true;
    }
    public boolean removeCourse(int code){
        for (Integer i:coursesCode) {
            if (code==i){
                coursesCode.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean existCourse(int code){
        for (Integer i:coursesCode) {
            if (code==i)
                return false;
        }
        return true;
    }
}
