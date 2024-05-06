import java.util.ArrayList;

public class Catalog {
    private ArrayList<issueInformation> issueInformationList;
    Catalog(){
        issueInformationList = new ArrayList<>();
    }
    public static class issueInformation {
        private String bookName;
        private String readerName;
        private String dateOfIssue;
        issueInformation(String _bookName, String _readerName, String _dateOfIssue){
            bookName=_bookName;
            readerName=_readerName;
            dateOfIssue=_dateOfIssue;
        }
        @Override
        public String toString(){
            return new String("-------------\nbook name: "+bookName+"\nreader name: "+readerName+"\ndate of issue: "+dateOfIssue+"\n");
        }

        public String getBookName() {
            return bookName;
        }

        public String getDateOfIssue() {
            return dateOfIssue;
        }

        public String getReaderName() {
            return readerName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public void setDateOfIssue(String dateOfIssue) {
            this.dateOfIssue = dateOfIssue;
        }

        public void setReaderName(String readerName) {
            this.readerName = readerName;
        }
    }
    @Override
    public String toString(){
        String result = "";
        for(issueInformation issueInformation : issueInformationList){
            result+= issueInformation.toString();
        }
        return result;
    }
    public void addBook(String _bookName, String _readerName, String _dateOfIssue){
        issueInformation issueInformation = new issueInformation(_bookName, _readerName, _dateOfIssue);
        issueInformationList.add(issueInformation);
    }
    public void addBook(issueInformation issueInformation){
        issueInformationList.add(issueInformation);
    }

    public void setBookList(ArrayList<issueInformation> issueInformationList) {
        this.issueInformationList = issueInformationList;
    }
}
