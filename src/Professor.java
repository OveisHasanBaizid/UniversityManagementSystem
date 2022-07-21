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
