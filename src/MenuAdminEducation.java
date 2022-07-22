import java.util.Scanner;

public class MenuAdminEducation {
    Scanner input = new Scanner(System.in);
    Admin admin;

    public MenuAdminEducation(Admin admin) {
        this.admin = admin;
        menu();
    }
    public void menu() {
        System.out.println("----------------------------------");
        System.out.println("* * * Menu Admin Education  * * *");
        int item;
        do {
            System.out.println("1.Add course");
            System.out.println("2.Remove course");
            System.out.println("3.Add Student");
            System.out.println("4.Remove Student");
            System.out.println("5.Add professor");
            System.out.println("6.Remove professor");
            System.out.println("7.Assignment of lessons to the professor");
            System.out.println("8.Exit");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 10 || item < 1);
        switch (item) {
            case 1 -> addCourse();
            case 2 -> removeCourse();
            case 3 -> addStudent();
            case 4 -> removeStudent();
            case 5 -> System.out.println();
            case 6 -> System.out.println();
            case 7 -> System.out.println();
            default -> menu();
        }
    }
    public void addCourse(){
        System.out.println("----------------------------------");
        System.out.println("* * * Add Course  * * *");
        DataBase.courses.add(new Course(input));
        System.out.println("New course added successfully");
        menu();
    }
    public void removeCourse(){
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Course  * * *");
        Course course;
        while (true){
            System.out.print("Enter code course for remove : ");
            int code = input.nextInt();
            course = DataBase.getCourse(code);
            if (course == null){
                System.out.println("There is no course with this code.");
                System.out.print("enter y try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch!='y')
                    menu();
            }else
                break;
        }
        DataBase.removeCourse(course);
        System.out.println("Course removed successfully");
        menu();
    }
    public void addStudent(){
        System.out.println("----------------------------------");
        System.out.println("* * * Add Student  * * *");
        DataBase.students.add(new Student(input));
        System.out.println("New student added successfully");
        menu();
    }
    public void removeStudent(){
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Student  * * *");
        Student student;
        while (true){
            System.out.print("Enter student number for remove : ");
            String stdNumber = input.nextLine();
            student = DataBase.getStudent(stdNumber);
            if (student == null){
                System.out.println("There is no student with this student number.");
                System.out.print("enter 'y' for try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch!='y')
                    menu();
            }else
                break;
        }
        DataBase.removeStudent(student);
        System.out.println("Course removed successfully");
        menu();
    }
}
