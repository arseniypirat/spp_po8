package task02;

import java.util.ArrayList;

public class Paragraph {
    private ArrayList<Word> words;

    public Paragraph() {
        words = new ArrayList<>();
    }
    public void addWord(Word word) {
        words.add(word);
    }
    public int wordCount() {
        return words.size();
    }
    public int length() {
        int totalLength = 0;
        for (Word word : words) {
            totalLength += word.length();
        }
        return totalLength;
    }
    public ArrayList<Word> getWords() {
        return words;
    }
}
