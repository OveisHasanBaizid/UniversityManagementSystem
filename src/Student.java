import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    private String studentNumber;
    private final String password;
    private float average;
    private final ArrayList<Integer> coursesCode;
    public Student(String line) {
        super(line);
        String[] array = line.split(",");
        this.average = Float.parseFloat(array[4]);
        this.studentNumber = array[5];
        this.password = array[6];
        this.coursesCode = new ArrayList<>();
        if (array.length>7) {
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
        input.nextLine();
        do {
            System.out.print("Student Number : ");
            this.studentNumber = input.nextLine();
        } while (DataBase.getStudent(studentNumber) != null);
        System.out.print("Password : ");
        this.password = input.nextLine();
        this.coursesCode = new ArrayList<>();
    }

    public float getAverage() {
        return average;
    }

    public String getStdNumber() {
        return studentNumber;
    }

    public String getPassword() {
        return password;
    }
    public ArrayList<Integer> getCoursesCode() {
        return coursesCode;
    }
    public boolean addCourse(int code) {
        if (existCourse(code))
            return false;
        coursesCode.add(code);
        return true;
    }

    public boolean removeCourse(int code) {
        if (!existCourse(code))
            return false;
        coursesCode.remove((Integer) code);
        return true;
    }

    public boolean existCourse(int code) {
        for (Integer i : coursesCode) {
            if (code == i)
                return true;
        }
        return false;
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
        return super.coder()+","+average+","+studentNumber+","+password+","+coderCodeCourse();
    }
    @Override
    public String toString() {
        return super.toString()+"\tStudent Number : " + studentNumber + "\tPassword : " + password + "\tAverage : " + average + "\tCoursesCode : " + coursesCode;
    }
}
