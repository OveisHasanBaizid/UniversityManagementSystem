import java.util.Scanner;

public class Professor extends Person{
    private int masterCode ;
    private ProfessorSpecialty professorSpecialty;
    private int salary;

    public Professor(String firstName, String lastName, int age, String address
            , int masterCode, ProfessorSpecialty professorSpecialty, int salary) {
        super(firstName, lastName, age, address);
        this.masterCode = masterCode;
        this.professorSpecialty = professorSpecialty;
        this.salary = salary;
    }

    public Professor(Scanner input) {
        super(input);
        System.out.print("Professor code : ");
        this.masterCode = input.nextInt();
        int i;
        do {
            System.out.println("1.Mathematics");
            System.out.println("2.Physics");
            System.out.println("3.Chemistry");
            System.out.println("4.Computer");
            System.out.println("5.Electricity");
            System.out.println("6.Mining");
            System.out.println("7.Mechanics");
            System.out.print("please choice a professor specialty :");
            i = input.nextInt();
        }while (i>7 || i<1);
        getProfessorSpecialty(i);
        System.out.print("Salary : ");
        this.salary = input.nextInt();
    }
    public void getProfessorSpecialty(int i){
        if (i==1)
            this.professorSpecialty = ProfessorSpecialty.Mathematics;
        else if (i==2)
            this.professorSpecialty = ProfessorSpecialty.Physics;
        else if (i==3)
            this.professorSpecialty = ProfessorSpecialty.Chemistry;
        else if (i==4)
            this.professorSpecialty = ProfessorSpecialty.Computer;
        else if (i==5)
            this.professorSpecialty = ProfessorSpecialty.Electricity;
        else if (i==6)
            this.professorSpecialty = ProfessorSpecialty.Mining;
        else
            this.professorSpecialty = ProfessorSpecialty.Mechanics;
    }
    public int getMasterCode() {
        return masterCode;
    }

    public void setMasterCode(int masterCode) {
        this.masterCode = masterCode;
    }

    public ProfessorSpecialty getProfessorSpecialty() {
        return professorSpecialty;
    }

    public void setProfessorSpecialty(ProfessorSpecialty professorSpecialty) {
        this.professorSpecialty = professorSpecialty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
