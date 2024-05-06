int seqLen = Convert.ToInt32(args[0]);
int[] sequence = new int[seqLen];
for (int i = 0; i < sequence.Length; i++)
{
    sequence[i] = Convert.ToInt32(args[i+1]);
}
calcRange(sequence);
Console.ReadLine();
void calcRange(int[] sequence)
{
    int range = sequence.Max() - sequence.Min();
    Console.WriteLine("Sequence Range is  " + range);
}


