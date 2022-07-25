import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MenuManager {
    Scanner input = new Scanner(System.in);

    public MenuManager() {
        menu();
    }

    public void menu() {
        System.out.println("----------------------------------");
        System.out.println("* * * Menu Login Admin * * *");
        int item;
        do {
            System.out.println("1.Add admin");
            System.out.println("2.Remove admin");
            System.out.println("3.List all admins");
            System.out.println("4.Exit");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 4 || item < 1);
        switch (item) {
            case 1 -> addAdmin();
            case 2 -> removeAdmin();
            case 3 -> listAllAdmin();
        }
    }
    public void listAllAdmin() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Admins * * *");
        int i = 1;
        for (Admin a : DataBase.admins) {
            System.out.println((i++) + ". " + a);
        }
        if (i==1)
            System.out.println("The list of admins is empty.");
    }
    public void addAdmin() {
        System.out.println("----------------------------------");
        System.out.println("* * * Add Admin  * * *");
        DataBase.admins.add(new Admin(input));
        System.out.println("New admin added successfully");
        menu();
    }
    public void removeAdmin() {
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Admin  * * *");
        Admin admin;
        while (true) {
            System.out.print("Enter username admin for remove : ");
            String username = input.nextLine();
            admin = DataBase.getAdmin(username);
            if (admin==null) {
                System.out.println("There is no admin with this username.");
                System.out.print("enter 'y' try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            } else
                break;
        }
        DataBase.admins.remove(admin);
        System.out.println("Admin removed successfully");
        menu();
    }
}
