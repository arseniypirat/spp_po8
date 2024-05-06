public abstract class Student implements Abiturient {
    protected String firstName;
    protected String lastName;
    Student(String _firstName, String _lastName){
        firstName=_firstName;
        lastName=_lastName;
    }
    @Override
    public String getFirstName(){
        return firstName;
    }
    @Override
    public String getLastName(){
        return lastName;
    }
    @Override
    public void setFirstName(String FirstName){
        firstName=FirstName;
    }
    @Override
    public void setLastName(String LastName) {
        lastName=LastName;
    }

    @Override
    public void printInfo() {
        System.out.println("fisrt name: "+firstName+"\nlast name: "+lastName);
    }
}
