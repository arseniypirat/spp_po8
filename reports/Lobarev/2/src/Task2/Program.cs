using System.IO;

namespace Task2;

internal class Program
{
    struct Utility
    {
        public bool c;
        public bool d;
        public bool u;

        public bool i;

        public string? input;
        public string? output;

        public Utility()
        {
            c = false;
            d = false;
            u = true;

            i = false;

            input = null;
            output = null;
        }
    }


    static void Main(params string[] args)
    {
        Utility utility = new();

        var arguments = new List<string>(args);

        if (arguments.Count > 4)
        {
            Console.WriteLine($"Too many arguments ({arguments.Count})");
            Console.WriteLine("Press any button to continue...");
            Console.ReadKey();
            return;
        }

        HashSet<string?> outputStyle = ["-c", "-d", "-u"];

        if (outputStyle.Contains(arguments.FirstOrDefault()))
        {
            switch (arguments.First())
            {
                case "-c":
                    utility.c = true;
                    utility.d = false;
                    utility.u = false;
                    break;

                case "-d":
                    utility.c = false;
                    utility.d = true;
                    utility.u = false;
                    break;

                case "-u":
                    utility.c = false;
                    utility.d = false;
                    utility.u = true;
                    break;

                default:
                    Console.WriteLine("Fatal comparing error");
                    Console.WriteLine("Press any button to continue...");
                    Console.ReadKey();
                    return;
            }

            arguments.Remove(arguments.First());
        }

        HashSet<string?> compareStyle = ["-i"];

        if (compareStyle.Contains(arguments.FirstOrDefault()))
        {
            switch (arguments.First())
            {
                case "-i":
                    utility.i = true;
                    break;

                default:
                    Console.WriteLine("Fatal matching error");
                    Console.WriteLine("Press any button to continue...");
                    Console.ReadKey();
                    return;
            }

            arguments.Remove(arguments.First());
        }

        var input = arguments.FirstOrDefault();
        if (input is not null)
        {
            if (input is not "-")
            {
                utility.input = input;
            }

            arguments.Remove(arguments.First());
        }

        var output = arguments.FirstOrDefault();
        if (output is not null)
        {
            if (output is not "-")
            {
                utility.output = output;
            }

            arguments.Remove(arguments.First());
        }

        Uniq(utility);

        Console.OpenStandardOutput();
        Console.WriteLine("\nFinished. Press any button to continue...");

        Console.OpenStandardInput();
        Console.ReadKey();
    }

    static void Uniq(Utility utility)
    {
        var reader = Console.In;

        if (utility.input is not null)
        {
            if (!File.Exists(utility.input))
            {
                Console.WriteLine($"File {utility.input} does not exist");
                return;
            }

            reader = new StreamReader(utility.input);
        }


        var writer = Console.Out;

        if (utility.output is not null)
        {
            if (File.Exists(utility.output))
            {
                Console.WriteLine($"File {utility.output} already exists. Do you want to rewrite it? (y/n)");
                var choice = Console.ReadKey();
                if (choice.Key != ConsoleKey.Y)
                {
                    return;
                }
            }

            writer = new StreamWriter(utility.output, false);
        }


        Uniq(reader, writer, utility.d, utility.c, utility.i);
    }

    static void Uniq(TextReader reader, TextWriter writer, bool inverse, bool countRepeats, bool ignoreCase)
    {
        var dict = new Dictionary<string, (int, int)>();

        int number = 1;

        var line = reader.ReadLine();
        while (line is not null and not "^Z")
        {
            if (ignoreCase)
            {
                line = line.ToLowerInvariant();
            }

            if (dict.TryGetValue(line, out (int, int) value))
            {
                value.Item1++;
                dict[line] = value;
            }
            else
            {
                dict.Add(line, (1, number++));
            }

            line = reader.ReadLine();
        }
        reader.Close();

        Console.Clear();

        Func<KeyValuePair<string, (int, int)>, bool> func = kvp => kvp.Value.Item1 == 1;
        
        if (inverse)
        {
            func = kvp => kvp.Value.Item1 > 1;
        }

        if (countRepeats)
        {
            func = _ => true;
        }

        var sorted = dict.Where(func).OrderBy(kvp => kvp.Value.Item2);

        foreach (var str in sorted)
        {
            if (countRepeats)
            {
                writer.WriteLine($"{str.Value.Item1} {str.Key}");
            }
            else
            {
                writer.WriteLine(str.Key);
            }
        }
        writer.Close();
    }
}
