namespace Task1;

class MusicItem
{
    public required string Name { get; set; }
    public decimal Cost { get; set; }

    public override string ToString()
    {
        return $"Item: name - {Name}, cost - {Cost:C}";
    }
}

