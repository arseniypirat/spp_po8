package task02;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int length() {
        return word.length();
    }

    public boolean isPalindrome() {
        String reversedWord = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversedWord);
    }
}
