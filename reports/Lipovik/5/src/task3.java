public class task3 {
    public static void main(String[] args){
        Faculty faculty1 = new Faculty("Faculty a");
        Faculty faculty2 = new Faculty("Faculty b");
        Teacher teacher1 = new Teacher("a", "teacher");
        Teacher teacher2 = new Teacher("b", "teacher");
        Teacher teacher3 = new Teacher("c", "teacher");
        Applicant applicant1 = new Applicant("a", "applicant");
        Applicant applicant2 = new Applicant("b", "applicant");
        Applicant applicant3 = new Applicant("c", "applicant");
        Applicant applicant4 = new Applicant("d", "applicant");
        faculty1.addExam(new Exam("exam1", teacher1));
        faculty1.addExam(new Exam("exam2", teacher2));
        faculty2.addExam(new Exam("exam3", teacher3));
        faculty1.registerApplicant(applicant1);
        faculty1.registerApplicant(applicant2);
        faculty2.registerApplicant(applicant3);
        faculty2.registerApplicant(applicant4);
        faculty1.passExams();
        faculty1.printApplicantList();
        faculty1.printAcceptedApplicantsList();
        faculty2.passExams();
        faculty2.printApplicantList();
        faculty2.printAcceptedApplicantsList();
    }
}
