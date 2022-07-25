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
    public Professor(String line) {
        super(line);
        String [] array = line.split(",");
        this.masterCode = Integer.parseInt(array[4]);
        setProfessorSpecialty(array[5]);
        this.salary = Integer.parseInt(array[6]);
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
    public void setProfessorSpecialty(String professorSpecialty) {
        switch (professorSpecialty) {
            case "Mathematics" -> this.professorSpecialty = ProfessorSpecialty.Mathematics;
            case "Physics" -> this.professorSpecialty = ProfessorSpecialty.Physics;
            case "Chemistry" -> this.professorSpecialty = ProfessorSpecialty.Chemistry;
            case "Computer" -> this.professorSpecialty = ProfessorSpecialty.Computer;
            case "Electricity" -> this.professorSpecialty = ProfessorSpecialty.Electricity;
            case "Mining" -> this.professorSpecialty = ProfessorSpecialty.Mining;
            default -> this.professorSpecialty = ProfessorSpecialty.Mechanics;
        }
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

    public String coder(){
        return super.coder()+","+masterCode+","+professorSpecialty+","+salary;
    }
}
