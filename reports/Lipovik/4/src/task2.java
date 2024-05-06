public class task2 {
    public static void main(String[] args){
        Page page = new Page();
        page.addParagraph(new Paragraph("first paragraph"));
        page.addParagraph("second paragraph");
        System.out.println(page);
    }
}
