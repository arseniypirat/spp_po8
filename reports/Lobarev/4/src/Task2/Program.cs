namespace Task2;

internal class Program
{
    static void Main()
    {
        Word word1 = new Word("Привет");
        Word word2 = new Word("мир");
        Word word3 = new Word("это");
        Word word4 = new Word("тест");

        Page page1 = new Page();
        page1.AddWord(word1);
        page1.AddWord(word2);

        Page page2 = new Page();
        page2.AddWord(word3);
        page2.AddWord(word4);

        Text text = new Text();
        text.AddPage(page1);
        text.AddPage(page2);

        text.PrintText();
    }
}







