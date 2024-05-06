package task02;

public class Main {
    public static void main(String[] args) {
        Word word1 = new Word("Hello");
        Word word2 = new Word("World");

        Paragraph paragraph = new Paragraph();

        paragraph.addWord(word1);
        paragraph.addWord(word2);

        System.out.println("Added words:");
        for (Word word : paragraph.getWords()) {
            System.out.println(word.getWord());
        }

        System.out.println("The number of words in a paragraph: " + paragraph.wordCount());
        System.out.println("Paragraph length: " + paragraph.length());
    }
}
