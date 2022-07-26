import java.util.Scanner;

public class Course {
    private int code;
    private final String title;
    private final int unit;
    private int codeProfessor;
    public Course(String line) {
        String[] array = line.split(",");
        this.code = Integer.parseInt(array[0]);
        this.title = array[1];
        this.unit =  Integer.parseInt(array[2]);
        this.codeProfessor = Integer.parseInt(array[3]);
    }
    public Course(Scanner input) {
        do {
            System.out.print("Code : ");
            this.code = input.nextInt();
        } while (DataBase.getCourse(code) != null);
        input.nextLine();
        System.out.print("Title : ");
        this.title = input.nextLine();
        System.out.print("Number unit : ");
        this.unit = input.nextInt();
        do {
            System.out.print("Professor Code (0 for null): ");
            this.codeProfessor = input.nextInt();
            if (codeProfessor == 0)
                break;
        } while (DataBase.getProfessor(codeProfessor) != null);
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public int getUnit() {
        return unit;
    }
    public void setCodeProfessor(int codeProfessor) {
        this.codeProfessor = codeProfessor;
    }
    public String coder(){
        return code+","+title+","+unit+","+codeProfessor;
    }
    @Override
    public String toString() {
        return "Code : " + code + "\tTitle : " + title +"\tUnit : " + unit + "\tCode Professor=" + codeProfessor;
    }
}
