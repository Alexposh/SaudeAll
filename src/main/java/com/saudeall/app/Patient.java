public class Patient {
    public String firstName;
    public String lastName;
    public int age;

    public Patient(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;        
    }
    
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
}
