public class StudentOfFaculty extends Student{
    String faculty;
    StudentOfFaculty(String _firstName, String _lastName, String _faculty) {
        super(_firstName, _lastName);
        faculty=_faculty;
    }
    public String getFaculty(){
        return faculty;
    }
    public void setFaculty(String _faculty){
        faculty=_faculty;
    }
    @Override
    public void printInfo(){
        System.out.println("faculty: "+faculty+"\nfisrt name: "+firstName+"\nlast name: "+lastName);
    }
}
