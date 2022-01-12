package commons;

public class Member {

    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private String registeryDate;
    private String password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.length()>=3 || id.length()<8)
            this.id = id;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        if(age.length()>=1 || age.length()<=2)
            this.age = age;
    }

    public String getRegisteryDate() {
        return registeryDate;
    }

    public void setRegisteryDate(String registeryDate) {
        this.registeryDate = registeryDate;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if(password.length()>=8 || password.length()<=15 ){
            this.password = password;
        }else{
            System.out.println("Enter a new password!!!");
        }
    }
}
