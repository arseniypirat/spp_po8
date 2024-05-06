import java.util.Vector;

public class Applicant extends Person {
    private Vector<Mark> markList= new Vector<>();

    public Applicant(String firstName, String lastName) {
        super(firstName, lastName);
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
