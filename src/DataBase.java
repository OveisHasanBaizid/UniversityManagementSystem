import java.util.ArrayList;

public class DataBase {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Professor> professors = new ArrayList<>();
    public static Student getStudent(String stdNumber){
        for (Student s:students) {
            if (s.getStdNumber().equals(stdNumber))
                return s;
        }
        return null;
    }
    public static Admin getAdmin(String stdNumber){
        for (Admin a:admins) {
            if (a.getUsername().equals(stdNumber))
                return a;
        }
        return null;
    }
    public static Course getCourse(int code){
        for (Course c:courses) {
            if (c.getCode()==code)
                return c;
        }
        return null;
    }
    public static Professor getProfessor(int code){
        for (Professor p:professors) {
            if (p.getMasterCode()==code)
                return p;
        }
        return null;
    }
    public static void removeCourse(Course course){
        courses.remove(course);
    }
    public static void removeStudent(Student student){
        students.remove(student);
    }
}
