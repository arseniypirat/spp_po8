public class Mark {
    private int mark;
    private Exam exam;

    public Mark(int mark, Exam exam) {
        this.mark = mark;
        this.exam = exam;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
    @Override
    public String toString(){
        String resultStr=getExam()+"\nmark: "+getMark();
        return  resultStr;
    }
}
