public class Paragraph {
    private String paragraphText;
    Paragraph(String _text){
        paragraphText =_text;
    }
    @Override
    public String toString(){
        return paragraphText;
    }
    public String getParagraphText() {
        return paragraphText;
    }
    public void setParagraphText(String paragraphText) {
        this.paragraphText = paragraphText;
    }
}
