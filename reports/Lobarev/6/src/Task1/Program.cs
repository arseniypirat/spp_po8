using System.Diagnostics;
using System.Globalization;

namespace Task1;

class Program
{
    static void Main()
    {
        CultureInfo.CurrentCulture = CultureInfo.GetCultureInfo("en-US");

        var musicItemPool = new MusicItemPool(initialCapacity: 2);
        
        var task1 = new Task(() =>
        {
            var item1 = musicItemPool.Rent();
            item1.Name = "Album A";
            item1.Cost = 5.97m;
            musicItemPool.Return(item1);
        });

        var task2 = new Task(() =>
        {
            var item2 = musicItemPool.Rent();
            item2.Name = "Album B";
            item2.Cost = 10.61m;
            musicItemPool.Return(item2);
        });

        task1.Start();
        task2.Start();

        Task.WaitAll(task1, task2);

        foreach (var item in musicItemPool)
        {
            Console.WriteLine(item);
        }
    }
}

