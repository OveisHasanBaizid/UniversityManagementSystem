import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    private String studentNumber;
    private String password;
    private float average;
    private ArrayList<Integer> coursesCode;

    public Student(float average, String firstName, String lastName, int age, String address, String stdNumber, String password) {
        super(firstName, lastName, age, address);
        this.average = average;
        this.studentNumber = stdNumber;
        this.password = password;
        this.coursesCode = new ArrayList<>();
    }

    public Student(String line) {
        super(line);
        String[] array = line.split(",");
        this.average = Float.parseFloat(array[4]);
        this.studentNumber = array[5];
        this.password = array[6];
        this.coursesCode = new ArrayList<>();
        if (!array[7].isEmpty()) {
            String[] array2 = array[7].split("-");
            for (String s : array2) {
                coursesCode.add(Integer.parseInt(s));
            }
        }
    }

    public Student(Scanner input) {
        super(input);
        while (true) {
            System.out.print("Average : ");
            this.average = input.nextInt();
            if (average < 20 && average >= 0)
                break;
            else
                System.out.println("The average entered is invalid");
        }
        do {
            System.out.print("StdNumber : ");
            this.studentNumber = input.nextLine();
        } while (DataBase.getStudent(studentNumber) != null);
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
        return studentNumber;
    }

    public void setStdNumber(String stdNumber) {
        this.studentNumber = stdNumber;
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

    public boolean addCourse(int code) {
        if (existCourse(code))
            return false;
        coursesCode.add(code);
        return true;
    }

    public boolean removeCourse(int code) {
        for (Integer i : coursesCode) {
            if (code == i) {
                coursesCode.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean existCourse(int code) {
        for (Integer i : coursesCode) {
            if (code == i)
                return false;
        }
        return true;
    }
    public String coderCodeCourse(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < coursesCode.size() ; i++) {
            s.append(coursesCode.get(i));
            if (i<coursesCode.size()-1)
                s.append("-");
        }
        return s.toString();
    }
    public String coder(){
        return super.coder()+","+studentNumber+","+password+","+average+","+coderCodeCourse();
    }
    @Override
    public String toString() {
        return "\tStudent Number : " + studentNumber + "\tPassword : " + password + "\tAverage : " + average + "\tCoursesCode : " + coursesCode;
    }
}
