/*Напишите программу, которая cчитывает текст и печатает таблицу, показывающую, сколь-
ко раз в этом тексте встречаются однобуквенные слова, двухбуквенные слова, трехбуквенные

слова и т.д.*/



string text = File.ReadAllText("test.txt");

Dictionary<int, int> wordDict = new Dictionary<int, int>();

string[] words = text.Split(new char[] { ' ', '.', ',', ';', ':', '!', '?' }, StringSplitOptions.RemoveEmptyEntries);

foreach (string word in words)
{
    int length = word.Length;
    if (wordDict.ContainsKey(length))
    {
        wordDict[length]++;
    }
    else
    {
        wordDict[length] = 1;
    }
}

foreach (var pair in wordDict)
{
    Console.WriteLine($"Number of {pair.Key}-letter words: {pair.Value}");
}