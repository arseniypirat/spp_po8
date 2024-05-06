using Lab3;

MySet set1 = new MySet("Set1");
MySet set2 = new MySet("Set2",true);
set1.Add(3.2f);
set1.Add(1.2f);
set1.Add(3.8f);
set1.Add(4.2f);
set1.Add(5.6f);
set1.PrintValues();
set2.Add(4.2f);
set2.Add(3.8f);
set2.Add(3.9f);
set2.PrintValues();
Console.WriteLine(set1.Equals(set1));
Console.WriteLine(set1.Equals(set2));
set1.Intersection(set2);
Console.WriteLine($"Does {set1.name} contain 1.2?");
Console.WriteLine(set1.Contains(1.2f));
Console.WriteLine($"Does {set2.name} contain 1.0?");
Console.WriteLine(set2.Contains(1.0f));
set2.Remove(1.0f);
Console.WriteLine($"Does {set2.name} contain 1.0?");
Console.WriteLine(set2.Contains(1.0f));





