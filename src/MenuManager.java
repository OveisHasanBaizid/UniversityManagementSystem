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
            System.out.println("1.Student management");
            System.out.println("2.Course management");
            System.out.println("3.Feeding automation");
            System.out.println("4.Add User");
            System.out.println("5.Remove User");
            System.out.println("6.Manage Apartment status change requests");
            System.out.println("7.List of status of apartment");
            System.out.println("8.Send notice for unpaid bills");
            System.out.println("9.Send monthly bills to apartment");
            System.out.println("10.Exit");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 10 || item < 1);
    }
}
