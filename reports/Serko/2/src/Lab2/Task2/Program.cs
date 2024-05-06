if (args.Length == 0)
{
    Console.WriteLine("Pass arguments");
    
}
else
{

    string str = "";
    foreach (var item in args)
    {
        if (item == "-")
        {
            str += "\n";
            str += Console.ReadLine();
            str += "\n";

        }
        else
        {
            using (StreamReader reader = new StreamReader(item))
            {
                str += reader.ReadToEnd();

            }

        }

    }

    Console.WriteLine(str);
}
Console.ReadLine();