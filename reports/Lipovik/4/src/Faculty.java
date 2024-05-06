import java.util.Vector;

public class Faculty {
    private String name;
    private Vector<Applicant> applicantList= new Vector<>();
    private Vector<Applicant> acceptedApplicantsList= new Vector<>();
    private Vector<Exam> examList= new Vector<>();

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void registerApplicant(Applicant applicant){
        applicantList.add(applicant);
    }
    public void addExam(Exam exam){
        examList.add(exam);
    }
    public void passExams(){
        for(Exam exam:examList){
            exam.giveMarks(applicantList);
        }
        for(Applicant applicant:applicantList){
            float GPA=0;
            for(Mark mark:applicant.getMarkList()){
                GPA+= mark.getMark();
            }
            GPA/=applicant.getMarkList().size();
            if(GPA>=6){
                acceptedApplicantsList.add(applicant);
            }
        }
    }
    public void printInfo(){
        System.out.println("Faculty name: "+getName()+"\nexam list:\n"+examList);
    }
    public void printAcceptedApplicantsList(){
        System.out.println("Accepted applicants:");
        for(Applicant applicant:acceptedApplicantsList){
            System.out.println(applicant);
        }
    }
    public void printApplicantList(){
        System.out.println("Applicants:");
        for(Applicant applicant:applicantList){
            System.out.println(applicant);
        }
    }
}
