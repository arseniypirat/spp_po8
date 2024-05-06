namespace Task1;

public class RealNumberSet
{
    private double[] elements;
    private int capacity;
    private int count;

    public RealNumberSet(int capacity)
    {
        this.capacity = capacity;
        elements = new double[capacity];
        count = 0;
    }

    public bool Add(double element)
    {
        if (count < capacity && !this.Contains(element))
        {
            elements[count++] = element;
            return true;
        }
        return false;
    }

    public bool Remove(double element)
    {
        int index = Array.IndexOf(elements, element);
        if (index >= 0)
        {
            elements[index] = elements[--count];
            return true;
        }
        return false;
    }

    public bool Contains(double element)
    {
        return Array.IndexOf(elements, element) >= 0;
    }

    public void Print()
    {
        Console.WriteLine(this.ToString());
    }

    public RealNumberSet Union(RealNumberSet other)
    {
        RealNumberSet unionSet = new RealNumberSet(this.capacity + other.capacity);
        foreach (double element in this.elements)
        {
            unionSet.Add(element);
        }
        foreach (double element in other.elements)
        {
            if (!unionSet.Contains(element))
            {
                unionSet.Add(element);
            }
        }
        return unionSet;
    }

    public override bool Equals(object? obj)
    {
        RealNumberSet? other = obj as RealNumberSet;
        if (other == null || this.count != other.count)
            return false;

        return this.elements.OrderBy(element => element).SequenceEqual(other.elements.OrderBy(element => element));
    }


    public override int GetHashCode()
    {
        return base.GetHashCode();
    }

    public override string ToString()
    {
        return $"RealNumberSet with {count} elements: " + string.Join(", ", elements.Select(x => $"{x}").ToArray(), 0, count);
    }
}

