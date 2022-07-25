import javax.xml.crypto.Data;
import java.util.Scanner;

public class Food {
    private int code;
    private String name;
    private int amount ;
    private TypeFood typeFood;
    private double price;

    public Food(int code ,String name, int amount, TypeFood typeFood, double price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.typeFood = typeFood;
        this.price = price;
    }
    public Food(String line) {
        String[] array = line.split(",");
        this.code = Integer.parseInt(array[0]);
        this.name = array[1];
        this.amount = Integer.parseInt(array[2]);
        setTypeFood(array[3]);
        this.price = Double.parseDouble(array[4]);
    }
    public Food(Scanner input) {
        while (true){
            System.out.print("Code : ");
            this.code = input.nextInt();
            if (DataBase.getFood(code)!=null)
                System.out.println("There is another food with this code.");
            else
                break;
        }
        System.out.print("Name : ");
        this.name = input.nextLine();
        System.out.print("Amount : ");
        this.amount = input.nextInt();
        while (true){
            System.out.print("TypeFood (1.Breakfast , 2.Lunch , 3.Dinner) : ");
            int item = input.nextInt();
            if (item>3 || item<1)
                System.out.println("The entered number is invalid.");
            else{
                this.typeFood = getTypeFood(item);
                break;
            }
        }
        System.out.print("Price : ");
        this.price = input.nextInt();
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TypeFood getTypeFood() {
        return typeFood;
    }
    public TypeFood getTypeFood(int i) {
        if(i==1)
            return TypeFood.Breakfast;
        else if(i==2)
            return TypeFood.Lunch;
        return TypeFood.Dinner;
    }
    public void setTypeFood(TypeFood typeFood) {
        this.typeFood = typeFood;
    }
    public void setTypeFood(String typeFood) {
        if (typeFood.equals("Breakfast"))
            this.typeFood = TypeFood.Breakfast;
        else if (typeFood.equals("Lunch"))
            this.typeFood = TypeFood.Lunch;
        else
            this.typeFood = TypeFood.Dinner;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String coder(){
        return code+","+name+","+amount+","+typeFood+","+price;
    }
    @Override
    public String toString() {
        return "Code : " + code + "\tName : " + name + "\tAmount : " + amount + "\tTypeFood=" + typeFood + "\tPrice=" + price;
    }
}
