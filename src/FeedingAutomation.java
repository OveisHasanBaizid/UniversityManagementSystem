import java.util.Scanner;

public class FeedingAutomation {
    Scanner input = new Scanner(System.in);
    Student student;

    public FeedingAutomation(Student student) {
        this.student = student;
    }

    public void menu() {
        System.out.println("----------------------------------");
        System.out.println("* * * Menu Feeding Automation * * *");
        int item;
        do {
            System.out.println("1.Reserve Food");
            System.out.println("2.Remove Food");
            System.out.println("3.List All Food");
            System.out.println("4.My food list");
            System.out.println("5.Back");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 5 || item < 1);
        switch (item) {
            case 1 -> reserveFood();
            case 2 -> removeFood();
            case 3 -> listAllFood();
            case 4 -> MyFoodList();
            default -> new Main();
        }
        menu();
    }
    public void MyFoodList(){
        System.out.println("----------------------------------");
        System.out.println("* * * My Food List * * *");
        int counter=0, i=1;
        for (ReservedFood r:DataBase.reservedFoods) {
            System.out.println((i+1)+". "+DataBase.getFood(r.getCodeFood()));
            counter++;
        }
        if (counter==0)
            System.out.println("Your reserved food list is empty");
    }
    public void listAllFood() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Food * * *");
        int i = 1;
        for (Food f : DataBase.foods) {
            System.out.println((i++) + ". " + f);
        }
    }

    public void removeFood() {
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Food  * * *");
        while (true) {
            System.out.print("Enter code food for remove : ");
            int code = input.nextInt();
            if (!student.existCourse(code)) {
                System.out.println("There is no course with this code.");
                System.out.print("enter y try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            } else {
                student.removeCourse(code);
                System.out.println("course removed successfully");
                break;
            }
        }
    }

    public void reserveFood() {
        System.out.println("----------------------------------");
        System.out.println("* * * Add Food  * * *");
        System.out.println("Menu Food : ");
        int i = 1;
        for (Food f : DataBase.foods) {
            System.out.println((i + 1) + ". " + f);
        }
        Food food;
        while (true) {
            System.out.print("Enter code Food : ");
            int code = input.nextInt();
            food = DataBase.getFood(code);
            if (food == null) {
                System.out.println("There is no food with this code.");
                System.out.print("enter 'y' try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            } else {
                DataBase.reservedFoods.add(new ReservedFood(student.getStdNumber(), food.getCode()));
                System.out.println("The food was successfully reserved.");
                break;
            }
        }
    }
}
