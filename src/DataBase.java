import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class DataBase {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Professor> professors = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<BorrowedBook> borrowedBooks = new ArrayList<>();
    static ArrayList<Food> foods = new ArrayList<>();
    static ArrayList<ReservedFood> reservedFoods = new ArrayList<>();
    public DataBase(){
        try {
            readStudents();
            readAdmins();
            readCourses();
            readProfessors();
            readBooks();
            readBorrowedBooks();
            readFoods();
            readReservedFoods();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
    public static BorrowedBook getBorrowedBook(int code) {
        for (BorrowedBook b: borrowedBooks) {
            if (b.getCodeBook() == code)
                return b;
        }
        return null;
    }
    public static ReservedFood getReservedFood(int code) {
        for (ReservedFood b: reservedFoods) {
            if (b.getCodeFood() == code)
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
    //--------------------------------------------------------------------------------
    public static void writeAdmins() throws IOException {
        FileWriter fileWriter = new FileWriter("Admins.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (Admin admin : admins) {
            stringBuilder.append(admin.coder()).append("\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static void readAdmins() throws IOException {
        admins = new ArrayList<>();
        FileReader fileReader = new FileReader("Admins.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s;
        while ((s = br.readLine()) != null) {
            admins.add(new Admin(s));
        }
        fileReader.close();
    }
    //--------------------------------------------------------------------------------
    public static void writeBooks() throws IOException {
        FileWriter fileWriter = new FileWriter("Books.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.coder()).append("\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static void readBooks() throws IOException {
        books = new ArrayList<>();
        FileReader fileReader = new FileReader("Books.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s;
        while ((s = br.readLine()) != null) {
            books.add(new Book(s));
        }
        fileReader.close();
    }
    //--------------------------------------------------------------------------------
    public static void writeFoods() throws IOException {
        FileWriter fileWriter = new FileWriter("Foods.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (Food food : foods) {
            stringBuilder.append(food.coder()).append("\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static void readFoods() throws IOException {
        foods = new ArrayList<>();
        FileReader fileReader = new FileReader("Foods.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s;
        while ((s = br.readLine()) != null) {
            foods.add(new Food(s));
        }
        fileReader.close();
    }
    //--------------------------------------------------------------------------------
    public static void writeBorrowedBooks() throws IOException {
        FileWriter fileWriter = new FileWriter("BorrowedBooks.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (BorrowedBook borrowedBook : borrowedBooks) {
            stringBuilder.append(borrowedBook.coder()).append("\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static void readBorrowedBooks() throws IOException {
        borrowedBooks = new ArrayList<>();
        FileReader fileReader = new FileReader("BorrowedBooks.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s;
        while ((s = br.readLine()) != null) {
            borrowedBooks.add(new BorrowedBook(s));
        }
        fileReader.close();
    }
    //--------------------------------------------------------------------------------
    public static void writeReservedFoods() throws IOException {
        FileWriter fileWriter = new FileWriter("ReservedFoods.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (ReservedFood reservedFood : reservedFoods) {
            stringBuilder.append(reservedFood.coder()).append("\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static void readReservedFoods() throws IOException {
        reservedFoods = new ArrayList<>();
        FileReader fileReader = new FileReader("ReservedFoods.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s;
        while ((s = br.readLine()) != null) {
            reservedFoods.add(new ReservedFood(s));
        }
        fileReader.close();
    }
    //--------------------------------------------------------------------------------
    public static void writeProfessors() throws IOException {
        FileWriter fileWriter = new FileWriter("Professors.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (Professor professor : professors) {
            stringBuilder.append(professor.coder()).append("\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static void readProfessors() throws IOException {
        professors = new ArrayList<>();
        FileReader fileReader = new FileReader("Professors.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s;
        while ((s = br.readLine()) != null) {
            professors.add(new Professor(s));
        }
        fileReader.close();
    }
    //--------------------------------------------------------------------------------
    public static void writeCourses() throws IOException {
        FileWriter fileWriter = new FileWriter("Courses.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (Course cours : courses) {
            stringBuilder.append(cours.coder()).append("\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static void readCourses() throws IOException {
        courses = new ArrayList<>();
        FileReader fileReader = new FileReader("Courses.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s;
        while ((s = br.readLine()) != null) {
            courses.add(new Course(s));
        }
        fileReader.close();
    }
    //--------------------------------------------------------------------------------
    public static void writeStudents() throws IOException {
        FileWriter fileWriter = new FileWriter("Students.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : students) {
            stringBuilder.append(student.coder()).append("\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static void readStudents() throws IOException {
        students = new ArrayList<>();
        FileReader fileReader = new FileReader("Students.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s;
        while ((s = br.readLine()) != null) {
            students.add(new Student(s));
        }
        fileReader.close();
    }
}
