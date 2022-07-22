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
