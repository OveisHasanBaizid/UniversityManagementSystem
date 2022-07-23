import java.util.Scanner;
public class Main {
    Scanner input = new Scanner(System.in);

    public Main() {
        mainMenu();
    }

    public void mainMenu() {
        System.out.println("----------------------------------");
        System.out.println("* * * Main Menu * * *");
        int item;
        do {
            System.out.println("1.Manager");
            System.out.println("2.Admin education");
            System.out.println("3.Admin nutrition");
            System.out.println("4.Admin library");
            System.out.println("5.Student");
            System.out.println("6.Exit");
            System.out.print("please choice a item :");
            item = input.nextInt();
            input.nextLine();
        } while (item > 3 || item < 1);
        switch (item) {
            case 1 -> loginManager();
            case 2, 3, 4 -> loginAdmin(item);
            case 5 -> loginStudent();
            default -> System.exit(0);
        }
        mainMenu();
    }

    public void loginManager() {
        System.out.println("----------------------------------");
        System.out.println("* * * Login Manager * * *");

        // default username & password for login Admin
        final String userNameManager = "Manager";
        final String passwordManager = "Manager";

        char ch = ' ';
        do {
            System.out.print("Enter username : ");
            String username = input.nextLine();
            System.out.print("Enter password : ");
            String password = input.nextLine();
            if (userNameManager.equals(username) && passwordManager.equals(password)) {
                new MenuManager();
            } else {
                System.out.println("The username or password entered is incorrect.");
                System.out.print("enter y try again : ");
                ch = input.next().charAt(0);
                input.nextLine();
            }
        } while (ch == 'y');
        mainMenu();
    }

    public void loginAdmin(int selected) {
        System.out.println("----------------------------------");
        System.out.println("* * * Login Admin * * *");
        char ch = 0;
        do {
            System.out.print("Enter username : ");
            String username = input.nextLine();
            System.out.print("Enter password : ");
            String password = input.nextLine();
            Admin admin = DataBase.getAdmin(username);
            TypeAdmin typeAdmin = Admin.getTypeAdmin(selected - 1);
            if (admin != null && admin.getPassword().equals(password) && admin.getTypeAdmin() == typeAdmin) {
                if (typeAdmin == TypeAdmin.Education)
                    new MenuAdminEducation(admin);
                else if (typeAdmin == TypeAdmin.nutrition)
                    new MenuAdminNutrition(admin);
                else
                    new MenuAdminLibrary(admin);
            } else {
                System.out.println("The username or password entered is incorrect.");
                System.out.print("enter y try again : ");
                ch = input.next().charAt(0);
                input.nextLine();
            }
        } while (ch == 'y');
        mainMenu();
    }

    public void loginStudent() {
        System.out.println("----------------------------------");
        System.out.println("* * * Login Student * * *");
        char ch = 0;
        do {
            System.out.print("Enter username : ");
            String username = input.nextLine();
            System.out.print("Enter password : ");
            String password = input.nextLine();
            Student student = DataBase.getStudent(username);
            if (student != null && student.getPassword().equals(password)) {
                new MenuStudent(student);
            } else {
                System.out.println("The username or password entered is incorrect.");
                System.out.print("enter y try again : ");
                ch = input.next().charAt(0);
                input.nextLine();
            }
        } while (ch == 'y');
        mainMenu();
    }

    public static void main(String[] args) {
        new Main();
    }
}
