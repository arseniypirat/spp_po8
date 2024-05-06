import java.util.Vector;

public class Page {
    private Vector<Paragraph> pageContent;
    Page(){
        pageContent = new Vector<>();
    }
    public void addParagraph(String paragraphText){
        pageContent.add(new Paragraph(paragraphText));
    }
    public void addParagraph(Paragraph paragraph){
        pageContent.add(paragraph);
    }
    @Override
    public String toString(){
        String result ="";
        for(Paragraph paragraph: pageContent){
            result+=paragraph+"\n";
        }
        return result;
    }
    public void setPageContent(Vector<Paragraph> pageContent) {
        this.pageContent = pageContent;
    }
}
