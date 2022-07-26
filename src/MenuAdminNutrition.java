import java.io.IOException;
import java.util.Scanner;

public class MenuAdminNutrition {
    Scanner input = new Scanner(System.in);
    Admin admin;

    public MenuAdminNutrition(Admin admin) {
        this.admin = admin;
        menu();
    }

    public void menu() {
        System.out.println("----------------------------------");
        System.out.println("* * * Menu Admin Nutrition  * * *");
        int item;
        do {
            System.out.println("1.Add food");
            System.out.println("2.Remove food");
            System.out.println("3.List All foods");
            System.out.println("4.List Reserved foods");
            System.out.println("5.Back");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 5 || item < 1);
        switch (item) {
            case 1 -> addFood();
            case 2 -> removeFood();
            case 3 -> listAllFood();
            case 4 -> reservedFoods();
            default -> new Main();
        }
    }

    public void addFood() {
        System.out.println("----------------------------------");
        System.out.println("* * * Add Food  * * *");
        DataBase.foods.add(new Food(input));
        System.out.println("New Food added successfully");
        try {
            DataBase.writeFoods();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void removeFood() {
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Food  * * *");
        Food food;
        while (true) {
            System.out.print("Enter code food for remove : ");
            int code = input.nextInt();
            food = DataBase.getFood(code);
            if (food == null) {
                System.out.println("There is no food with this code.");
                System.out.print("enter y try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            } else
                break;
        }
        DataBase.foods.remove(food);
        System.out.println("food removed successfully");
        try {
            DataBase.writeFoods();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public void listAllFood() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Food * * *");
        int i = 1;
        for (Food f : DataBase.foods) {
            System.out.println((i++) + ". " + f);
        }
        menu();
    }

    public void reservedFoods() {
        System.out.println("----------------------------------");
        System.out.println("* * * List Reserved Foods * * *");
        int i = 1;
        int countBreakfast = 0, countLunch = 0, countDinner = 0;
        for (Food f : DataBase.foods) {
            int x = DataBase.counterFoods(f.getCode());
            if (x != 0) {
                System.out.println((i + 1) + ". Code : " + f.getCode() + "\tNumber : " + x);
                if (f.getTypeFood() == TypeFood.Breakfast)
                    countBreakfast += x;
                else if (f.getTypeFood() == TypeFood.Lunch)
                    countLunch += x;
                else
                    countDinner += x;
            }
        }
        System.out.println("Number of reserved breakfast : " + countBreakfast);
        System.out.println("Number of reserved lunches : " + countLunch);
        System.out.println("Number of reserved dinner : " + countDinner);
        menu();
    }
}
