package Task2;

public class Main {
    public static void main(String[] args) throws Exception {
        Word wordTest = new Word(new Symbol[] {
                new Symbol('T'),
                new Symbol('e'),
                new Symbol('s'),
                new Symbol('t')
        });
        Word wordString = new Word(new Symbol[] {
                new Symbol('s'),
                new Symbol('t'),
                new Symbol('r'),
                new Symbol('i'),
                new Symbol('n'),
                new Symbol(' '),
                new Symbol('g'),
                new Symbol('!')
        });

        MyString str = new MyString(new Word[] {
                wordTest,
                wordString
        });

        System.out.println(str.length());
        System.out.println(str);
        System.out.println(str.wordAt(1));
    }
}
