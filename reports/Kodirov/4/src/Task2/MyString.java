package Task2;

import java.util.Arrays;

public class MyString {
    Word[] words;

    public MyString(Word[] words) {
        this.words = words;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return Arrays.equals(words, myString.words);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(words);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Word word : words) {
            builder.append(word.toString()).append(' ');
        }
        return builder.toString();
    }

    public int length() {
        return words.length;
    }

    public Word wordAt(int index) throws Exception {
        if (index < 0 || index > words.length) {
            throw new Exception("Неверный индекс!");
        }
        return words[index];
    }
}
