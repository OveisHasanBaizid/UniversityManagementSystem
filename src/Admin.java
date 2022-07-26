import java.util.Scanner;

public class Admin extends Person {
    private String username;
    private final String password;
    private TypeAdmin typeAdmin;
    public Admin(String line) {
        super(line);
        String[] array = line.split(",");
        this.username = array[4];
        this.password = array[5];
        setTypeAdmin(array[6]);
    }

    public Admin(Scanner input) {
        super(input);
        while (true) {
            System.out.print("Username : ");
            this.username = input.nextLine();
            if (DataBase.getAdmin(username) != null)
                System.out.println("The username entered is duplicate.");
            else
                break;
        }
        System.out.print("Password : ");
        this.password = input.nextLine();
        while (true) {
            System.out.print("Type Admin (1.Education , 2.Nutrition , 3.Library) : ");
            int item = input.nextInt();
            if (item > 3 || item < 1)
                System.out.println("The entered number is invalid.");
            else {
                this.typeAdmin = getTypeAdmin(item);
                break;
            }
        }
    }

    public TypeAdmin getTypeAdmin() {
        return typeAdmin;
    }


    public void setTypeAdmin(String typeAdmin) {
        if (typeAdmin.equals("Education"))
            this.typeAdmin = TypeAdmin.Education;
        else if (typeAdmin.equals("Nutrition"))
            this.typeAdmin = TypeAdmin.Nutrition;
        else
            this.typeAdmin = TypeAdmin.Library;

    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public String coder() {
        return super.coder() + "," + username + "," + password + "," + typeAdmin;
    }

    public static TypeAdmin getTypeAdmin(int i) {
        if (i == 1)
            return TypeAdmin.Education;
        else if (i == 2)
            return TypeAdmin.Nutrition;
        else
            return TypeAdmin.Library;
    }

    @Override
    public String toString() {
        return super.coder()+"\tUsername : " + username + "\tPassword : " + password +"\tTypeAdmin : " + typeAdmin;
    }
}
