import java.util.Scanner;

public class Admin extends Person{
    private String username;
    private String password;
    private TypeAdmin typeAdmin;

    public Admin(String firstName, String lastName, int age, String address, String username, String password, TypeAdmin typeAdmin) {
        super(firstName, lastName, age, address);
        this.username = username;
        this.password = password;
        this.typeAdmin = typeAdmin;
    }
    public Admin(Scanner input) {
        super(input);
        while (true){
            System.out.print("Username : ");
            this.username = input.nextLine();
            if (DataBase.getAdmin(username)!=null)
                System.out.println("The username entered is duplicate.");
            else
                break;
        }
        System.out.print("Password : ");
        this.password = input.nextLine();
        while (true){
            System.out.print("Type Admin (1.Education , 2.Nutrition , 3.Library) : ");
            int item = input.nextInt();
            if (item>3 || item<1)
                System.out.println("The entered number is invalid.");
            else{
                this.typeAdmin = getTypeAdmin(item);
                break;
            }
        }
    }
    public TypeAdmin getTypeAdmin() {
        return typeAdmin;
    }

    public void setTypeAdmin(TypeAdmin typeAdmin) {
        this.typeAdmin = typeAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static TypeAdmin getTypeAdmin(int i){
        if (i==1)
            return TypeAdmin.Education;
        else if (i==2)
            return TypeAdmin.nutrition;
        else
            return TypeAdmin.library;
    }
}
