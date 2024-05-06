import java.util.Vector;

public class Applicant {
    private String firstName;
    private String lastName;
    private Vector<Mark> markList= new Vector<>();

    public Applicant(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Vector<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(Vector<Mark> markList) {
        this.markList = markList;
    }
    public void addMark(Mark mark){
        markList.add(mark);
    }
    @Override
    public String toString(){
        String resultStr=getLastName()+" "+getFirstName();
        return resultStr;
    }
    public void printMarkList(){
        for(Mark mark:markList){
            System.out.println(mark);
        }
    }
}
