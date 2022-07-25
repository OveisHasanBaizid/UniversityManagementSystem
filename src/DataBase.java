import java.util.ArrayList;

public class DataBase {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Professor> professors = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<BookLoaned> booksLoaned = new ArrayList<>();
    static ArrayList<Food> foods = new ArrayList<>();
    static ArrayList<ReservedFood> reservedFoods = new ArrayList<>();
    public static Student getStudent(String stdNumber) {
        for (Student s : students) {
            if (s.getStdNumber().equals(stdNumber))
                return s;
        }
        return null;
    }

    public static Admin getAdmin(String stdNumber) {
        for (Admin a : admins) {
            if (a.getUsername().equals(stdNumber))
                return a;
        }
        return null;
    }

    public static Course getCourse(int code) {
        for (Course c : courses) {
            if (c.getCode() == code)
                return c;
        }
        return null;
    }

    public static Professor getProfessor(int code) {
        for (Professor p : professors) {
            if (p.getMasterCode() == code)
                return p;
        }
        return null;
    }

    public static Book getBook(int code) {
        for (Book b: books) {
            if (b.getCode() == code)
                return b;
        }
        return null;
    }
    public static Food getFood(int code) {
        for (Food f: foods) {
            if (f.getCode() == code)
                return f;
        }
        return null;
    }
    public static void removeCourse(Course course) {
        courses.remove(course);
    }

    public static void removeStudent(Student student) {
        students.remove(student);
    }

    public static void removeProfessor(Professor professor) {
        professors.remove(professor);
    }
    public static int counterFoods(int code){
        int count =0;
        for (ReservedFood r:reservedFoods) {
            if (r.getCodeFood()==code)
                count++;
        }
        return count;
    }

}
