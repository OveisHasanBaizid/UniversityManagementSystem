import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private int age ;
    private String address;

    public Person(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }
    public Person(String line) {
        String [] array = line.split(",");
        this.firstName = array[0];
        this.lastName = array[1];
        this.age = Integer.parseInt(array[2]);
        this.address = array[3];
    }
    public Person(Scanner input) {
        input.nextLine();
        System.out.print("FirstName : ");
        this.firstName = input.nextLine();
        System.out.print("LastName : ");
        this.lastName = input.nextLine();
        System.out.print("Age : ");
        this.age = input.nextInt();
        input.nextLine();
        System.out.print("Address : ");
        this.address = input.nextLine();
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String coder(){
        return firstName+","+lastName+","+age+","+address;
    }
    @Override
    public String toString() {
        return "FirstName : " + firstName + "\tLastName : " + lastName + "\tAge : " + age +
                "\tAddress : " + address;
    }
}
