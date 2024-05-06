using System.Collections;
using System.Collections.Concurrent;

namespace Task1;

class MusicItemPool : IEnumerable<MusicItem>
{
    private readonly ConcurrentQueue<MusicItem> items = new();
    
    // Инициализация пула объектов
    public MusicItemPool(int initialCapacity)
    {
        for (int i = 0; i < initialCapacity; i++)
        {
            items.Enqueue(new MusicItem() { Name = string.Empty });
        }
    }

    public IEnumerator<MusicItem> GetEnumerator()
    {
        return items.GetEnumerator();
    }

    // Аренда объекта из пула
    public MusicItem Rent()
    {
        if (items.TryDequeue(out var item))
        {
            return item;
        }
        else
        {
            // Создаем новый объект, если пул пуст
            return new MusicItem() { Name = string.Empty };
        }
    }

    // Возврат объекта в пул
    public void Return(MusicItem item)
    {
        items.Enqueue(item);
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return items.GetEnumerator();
    }
}

