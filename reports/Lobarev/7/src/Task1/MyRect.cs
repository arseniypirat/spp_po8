using System.Windows;

namespace Task1;

public class MyRect
{
    public Point TopLeft { get; set; }
    public double Width { get; set; }
    public double Height { get; set; }

    public MyRect(Point topLeft, double width, double height)
    {
        TopLeft = topLeft;
        Width = width;
        Height = height;
    }

    // Метод, который проверяет, лежит ли точка внутри прямоугольника.
    public bool Contains(Point point)
    {
        return point.X >= TopLeft.X && point.X <= TopLeft.X + Width &&
               point.Y >= TopLeft.Y && point.Y <= TopLeft.Y + Height;
    }
}
