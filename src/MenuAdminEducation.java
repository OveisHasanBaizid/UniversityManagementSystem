import java.io.IOException;
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
            System.out.println("3.List All course");
            System.out.println("4.Add Student");
            System.out.println("5.Remove Student");
            System.out.println("6.List All Student");
            System.out.println("7.Add professor");
            System.out.println("8.Remove professor");
            System.out.println("9.List All professor");
            System.out.println("10.Assignment of course to the professor");
            System.out.println("11.Back");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 11 || item < 1);
        switch (item) {
            case 1 -> addCourse();
            case 2 -> removeCourse();
            case 3 -> listAllCourse();
            case 4 -> addStudent();
            case 5 -> removeStudent();
            case 6 -> listAllStudent();
            case 7 -> addProfessor();
            case 8 -> removeProfessor();
            case 9 -> listAllProfessor();
            case 10 -> assignmentCourseProfessor();
        }
    }
    public void listAllCourse() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Course * * *");
        int i = 1;
        for (Course c : DataBase.courses) {
            System.out.println((i++) + ". " + c);
        }
        if (i==1)
            System.out.println("Courses list is empty");
        menu();
    }
    public void listAllStudent() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Student * * *");
        int i = 1;
        for (Student s : DataBase.students) {
            System.out.println((i++) + ". " + s);
        }
        if (i==1)
            System.out.println("Students list is empty");
        menu();
    }
    public void listAllProfessor() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Professor * * *");
        int i = 1;
        for (Professor p : DataBase.professors) {
            System.out.println((i++) + ". " + p);
        }
        if (i==1)
            System.out.println("Professors list is empty");
        menu();
    }
    public void addCourse() {
        System.out.println("----------------------------------");
        System.out.println("* * * Add Course  * * *");
        DataBase.courses.add(new Course(input));
        System.out.println("New course added successfully");
        try {
            DataBase.writeCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void removeCourse() {
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Course  * * *");
        Course course;
        while (true) {
            System.out.print("Enter code course for remove : ");
            int code = input.nextInt();
            course = DataBase.getCourse(code);
            if (course == null) {
                System.out.println("There is no course with this code.");
                System.out.print("enter y try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            } else
                break;
        }
        DataBase.removeCourse(course);
        System.out.println("Course removed successfully");
        try {
            DataBase.writeCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void addStudent() {
        System.out.println("----------------------------------");
        System.out.println("* * * Add Student  * * *");
        DataBase.students.add(new Student(input));
        System.out.println("New student added successfully");
        try {
            DataBase.writeStudents();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void removeStudent() {
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Student  * * *");
        Student student;
        input.nextLine();
        while (true) {
            System.out.print("Enter student number for remove : ");
            String stdNumber = input.nextLine();
            student = DataBase.getStudent(stdNumber);
            if (student == null) {
                System.out.println("There is no student with this student number.");
                System.out.print("enter 'y' for try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            } else
                break;
        }
        DataBase.removeStudent(student);
        System.out.println("Course removed successfully");
        try {
            DataBase.writeStudents();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void addProfessor() {
        System.out.println("----------------------------------");
        System.out.println("* * * Add Professor  * * *");
        DataBase.professors.add(new Professor(input));
        System.out.println("New student added successfully");
        try {
            DataBase.writeProfessors();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void removeProfessor() {
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Professor  * * *");
        Professor professor;
        while (true) {
            System.out.print("Enter professor code for remove : ");
            int code = input.nextInt();
            professor = DataBase.getProfessor(code);
            if (professor == null) {
                System.out.println("There is no student with this professor code.");
                System.out.print("enter 'y' for try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            } else
                break;
        }
        DataBase.removeProfessor(professor);
        System.out.println("Professor removed successfully");
        try {
            DataBase.writeProfessors();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void assignmentCourseProfessor() {
        System.out.println("----------------------------------");
        System.out.println("* * * Assignment of course to the professor * * *");
        Course course;
        while (true) {
            System.out.print("Enter code course : ");
            int code = input.nextInt();
            course = DataBase.getCourse(code);
            if (course != null)
                break;
            else {
                System.out.println("There is no course with this course code.");
                System.out.print("enter 'y' for try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            }
        }
        Professor professor;
        while (true) {
            System.out.print("Enter professor code : ");
            int code = input.nextInt();
            professor = DataBase.getProfessor(code);
            if (professor == null) {
                System.out.println("There is no course with this professor code.");
                System.out.print("enter 'y' for try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();

            } else {
                break;
            }
        }
            course.setCodeProfessor(professor.getMasterCode());
            System.out.println("Assignment of course to the professor successfully");
        try {
            DataBase.writeCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }
}
