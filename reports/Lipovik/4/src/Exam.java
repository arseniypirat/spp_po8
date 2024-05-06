import java.util.Scanner;
import java.util.Vector;

public class Exam {
    private  String name;
    private Teacher teacher;

    public Exam(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void giveMarks(Vector<Applicant> applicantList){
        System.out.println("Exam name: "+getName());
        Scanner scanner=new Scanner(System.in);
        for(Applicant applicant:applicantList){
            System.out.print("Set mark for applicant "+applicant.getLastName()+" "+applicant.getFirstName()+": ");
            int mark = scanner.nextInt();
            applicant.addMark(new Mark(mark, this));
        }
    }
    @Override
    public String toString(){
        String resultStr="Exam name: "+getName()+"\nteacher: "+teacher;
        return resultStr;
    }
}
