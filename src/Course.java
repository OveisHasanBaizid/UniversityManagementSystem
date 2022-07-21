public class Course {
    private int code ;
    private String title;
    private int unit;
    private int codeProfessor;

    public Course(int code, String title, int unit, int codeProfessor) {
        this.code = code;
        this.title = title;
        this.unit = unit;
        this.codeProfessor = codeProfessor;
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
