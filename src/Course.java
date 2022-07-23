import java.util.Scanner;

public class Course {
    private int code;
    private String title;
    private int unit;
    private int codeProfessor;

    public Course(int code, String title, int unit, int codeProfessor) {
        this.code = code;
        this.title = title;
        this.unit = unit;
        this.codeProfessor = codeProfessor;
    }

    public Course(Scanner input) {
        do {
            System.out.print("Code : ");
            this.code = input.nextInt();
        } while (DataBase.getCourse(code) != null);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getCodeProfessor() {
        return codeProfessor;
    }

    public void setCodeProfessor(int codeProfessor) {
        this.codeProfessor = codeProfessor;
    }
}
