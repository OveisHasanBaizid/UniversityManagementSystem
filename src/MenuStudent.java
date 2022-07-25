import java.util.Scanner;

public class MenuStudent {
    Scanner input = new Scanner(System.in);
    Student student;

    public MenuStudent(Student student) {
        this.student = student;
        menu();
    }

    public void menu() {
        System.out.println("----------------------------------");
        System.out.println("* * * Menu Admin Student  * * *");
        int item;
        do {
            System.out.println("1.Manage Courses");
            System.out.println("2.Feeding automation");
            System.out.println("3.Library");
            System.out.println("4.Profile");
            System.out.println("5.Back");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 5 || item < 1);
        switch (item) {
            case 1 -> menuManageCourse();
            case 2 -> new FeedingAutomation(student);
            case 3 -> System.out.println();
            case 4 -> System.out.println();
            default -> new Main();
        }
        menu();
    }

    public void menuManageCourse() {
        System.out.println("----------------------------------");
        System.out.println("* * * Menu Manage Course * * *");
        int item;
        do {
            System.out.println("1.Add Course");
            System.out.println("2.Remove Course");
            System.out.println("3.List Courses");
            System.out.println("4.Back");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 4 || item < 1);
        switch (item) {
            case 1 -> addCourse();
            case 2 -> removeCourse();
            case 3 -> listAllCourse();
            default -> new Main();
        }
        menu();
    }

    public void listAllCourse() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Course * * *");
        int i = 1;
        for (Integer x : student.getCoursesCode()) {
            System.out.println((i++) + ". " + DataBase.getCourse(x));
        }
    }

    public void removeCourse() {
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Course  * * *");
        while (true) {
            System.out.print("Enter code food for remove : ");
            int code = input.nextInt();
            if (!student.removeCourse(code)) {
                student.removeCourse(code);
                System.out.println("course removed successfully");
                break;
            } else {
                System.out.println("There is no course with this code.");
                System.out.print("enter y try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            }
        }
    }

    public void addCourse() {
        System.out.println("----------------------------------");
        System.out.println("* * * Add Course  * * *");
        System.out.println("List Course : ");
        int i = 1;
        for (Course c : DataBase.courses) {
            System.out.println((i + 1) + ". " + c);
        }
        int numberUnit = countUnitStudent();
        System.out.println("The number of units you have earned : " + numberUnit);
        while (true) {
            System.out.print("Enter code course : ");
            int code = input.nextInt();
            if (!checkValidGetUnit(code)) {
                System.out.println("The number of units selected is more than the allowed limit.");
                System.out.print("Enter 'y' try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    break;
            } else {
                if (!student.addCourse(code))
                    System.out.println("This course has already been taken by you.");
                else
                    System.out.println("Course added successfully.");
                break;
            }
        }
        menuManageCourse();
    }

    public int countUnitStudent() {
        int sum = 0;
        for (Integer i : student.getCoursesCode()) {
            Course course = DataBase.getCourse(i);
            if (course != null)
                sum += course.getUnit();
        }
        return sum;
    }

    public boolean checkValidGetUnit(int codeCourse) {
        int numberUnit = countUnitStudent();
        Course course = DataBase.getCourse(codeCourse);
        if (course != null)
            numberUnit += course.getUnit();
        if (student.getAverage() < 12 && numberUnit > 14)
            return false;
        if (student.getAverage() < 17 && numberUnit > 20)
            return false;
        return !(student.getAverage() > 17) || numberUnit <= 24;
    }
}
